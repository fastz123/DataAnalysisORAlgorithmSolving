package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2217_로프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		int min = Integer.MAX_VALUE;
		for(int z=0;z<T;z++) {
			arr[z] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		for(int i=0;i<T;i++) {
			int cur = arr[i] * (T-i);
			max = Math.max(max, cur);
		}
		System.out.println(max);

	}

}
