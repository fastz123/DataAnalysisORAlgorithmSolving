package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_16112_5차전직 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_5차전직.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int len = Integer.parseInt(s[0]);
		int maxinit = Integer.parseInt(s[1]);
		long[] arr = new long[len];
		s = br.readLine().split(" ");
		for(int z=0;z<len;z++) {
			long cur = Long.parseLong(s[z]);
			arr[z]=cur;
		}
		
		Arrays.sort(arr);
		
		int curinit = 0;
		long answer = 0;
		for(int z=0;z<len;z++) {
			answer += (long)(curinit*arr[z]);
			if(curinit < maxinit) {
				curinit+=1;
			}
		}
		System.out.println(answer);
	}

}
