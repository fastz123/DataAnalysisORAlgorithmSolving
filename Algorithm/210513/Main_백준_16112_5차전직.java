package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_16112_5차전직 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_5차전직.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s= br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		long[] arr = new long[N];
		s = br.readLine().split(" ");
		long sum = 0;
		for(int z=0;z<N;z++) {
			long cur = Long.parseLong(s[z]);
			arr[z] = cur;
			sum += cur;
		}
		
		sum*=M;
		
		Arrays.sort(arr);
		
		for(int z=0;z<M;z++) {
			sum -= (arr[z]*(M-z));
		}
		
		System.out.println(sum);
	}

}
