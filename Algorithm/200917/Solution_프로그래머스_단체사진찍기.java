package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_프로그래머스_단체사진찍기 {
	public static int len,N;
    public static char b[],arr[];
    public static boolean v[];
    public static String[] Data;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_단체사진찍기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] data = br.readLine().split(" ");
		
		N = n;
        Data = data;
        arr = new char[]{'A','C','F','J','M','N','R','T'};
        int len = 8;
        
        v = new boolean[8];
        b = new char[8];
        
        dfs(0);
        System.out.println(cnt);
	}
	
	public static int cnt;
    private static void dfs(int count){
        if(count == 8){
        	boolean f= true;
        	for(String cur : Data){
                char to = cur.charAt(0);
                char end = cur.charAt(2);
                char how = cur.charAt(3);
                int len = cur.charAt(4)-'0';
                
                if(check(to,end,how,len)){
                    continue;
                }
                else {
                	f=false;
                	break;
                }
            }
            if(f) {
            	cnt++;
//            	System.out.println(Arrays.toString(b));
            }
            return;
        }
        else{
            for(int i=0;i<8;i++){
                if(!v[i]){
                    v[i]=true;
//                    boolean f=true;
                    b[count]=arr[i];
                    
                    dfs(count+1);
                    v[i]=false;
                }
            }
        }
    }
    
    private static boolean check(char to, char end, char how, int len){
        int toidx = -1;
        int endidx = -1;
        for(int z=0;z<8;z++){
            if(b[z]==to) toidx = z;
            if(b[z]==end) endidx = z;
        }
        
        if(toidx == -1) return true;
        if(endidx == -1) return true;
        
        int curlen = Math.abs(toidx - endidx);
        if(how == '='){
            if(curlen-1 == len) return true;
            else return false;
        }
        else if(how == '<'){
            if(curlen-1 < len) return true;
            else return false;
        }
        else{
            if(curlen-1 > len) return true;
            else return false;
        }
        
    }

}
