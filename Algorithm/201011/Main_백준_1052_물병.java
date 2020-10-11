package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_1052_물병 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_물병.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int result=0;
		while(true) {
			int tempN = N+result;
			
			int cnt =0;
			while(tempN>0) {
				cnt++;
				tempN/=2;
			}
			
			tempN = N+result;
			int c=0;
			for(int k=0;k<cnt;k++) {
				if((tempN & (1<<k))>0) {
					c++;
				}
			}
			
			if(c <= K) break;
			result++;
		}
		
		System.out.println(result);

	}


}
