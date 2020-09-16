package algoProblems;

import java.io.InputStreamReader;

import java.io.BufferedReader;

public class Solution_프로그래머스_점프와순간이동 {
	public static int N,min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		N=n;
        min = Integer.MAX_VALUE;
        
        dfs(0,0);
        System.out.println(min);
	}
	
	private static void dfs(int i, int fuel){
        if(min < fuel) return;
        if(i>N) return;
        if(i==N) {
            min = Math.min(min,fuel);
            return;
        }
        else{
        	if(i!=0) dfs(i*2, fuel);
        	
            for(int k=N-i;k>=1;k--){
                dfs(i+k,fuel+k);
            }
            
        }
    }
}
