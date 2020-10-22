package algo2;

import java.io.*;
public class Main_백준_11729_하노이탑이동순서 {
    public static int N,cnt;
    public static StringBuffer sb;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        cnt = 0;
        sb = new StringBuffer();
        hanoi(N,1,2,3);
        System.out.println(cnt);
        System.out.println(sb.toString());
	}
	
	
	private static void hanoi(int n, int from, int by, int to){
	    cnt++;
	    //1개면 바로 이동
	    if(n==1){
	        sb.append(from+" "+to+"\n");
	    }
	    else{
    	    //1에서 2이동
    	    hanoi(n-1,from,to,by);
    	    //마지막 판 3이동
    	    sb.append(from+" "+to+"\n");
    	    //나머지 3이동
	        hanoi(n-1,by,from,to);
	    }
	}
}
