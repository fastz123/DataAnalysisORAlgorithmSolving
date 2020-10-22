package algo2;

import java.io.*;
public class Main_백준_15810_풍선공장 {

    public static int len;
    public static long min,arr[],m;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        len = Integer.parseInt(s[0]);
        m = Long.parseLong(s[1]);
        arr = new long[len];
        s = br.readLine().split(" ");
        
        long max = -1;
        
        for(int z=0;z<len;z++) {
            arr[z] = Long.parseLong(s[z]);
            if(max < arr[z]) max = arr[z];
        }
        
        min = Long.MAX_VALUE;
        bs(0,max*m);
        System.out.println(min);
    }
    
    private static void bs(long left, long right){
        if(left>right) return;
        
        long mid = (left+right)/2;
        long cnt = 0;
        int idx = 0;
        while(idx<len) {
            cnt += mid/arr[idx]; 
            idx++;
        }
        
        if(cnt >= m) {
            min = Math.min(min,mid);
            bs(left,mid-1);
        }
        else{
            bs(mid+1,right);
        }
    }
}
