package algoProblems;

import java.io.InputStreamReader;

import java.io.BufferedReader;

public class Main_백준_14916_거스름돈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		if(T%5 == 0) System.out.println(T/5);
		else {
			int ans = 0;
			while(true) {
				
				if(T<0) {
					ans = -1;
					break;
				}
				
				T -= 2;
				ans ++;
				
				if(T%5==0) {
					ans += T/5;
					break;
				}
			}
			System.out.println(ans);
		}
		
		
	}

}
