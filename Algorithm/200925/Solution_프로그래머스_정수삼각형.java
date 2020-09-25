package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_프로그래머스_정수삼각형 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_정수삼각형.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[T][];
		int[][] answer = new int[T][];
		for(int z=0;z<T;z++) {
			String[] s = br.readLine().split(", ");
			int[] cur = new int[s.length];
			for(int k=0;k<s.length;k++) {
				cur[k]=Integer.parseInt(s[k]);
			}
			arr[z] = cur;
			cur = new int[s.length];
			answer[z] = cur;
		}
		
		answer[0][0]=arr[0][0];
		int max = Integer.MIN_VALUE;
		for(int z=0;z<T-1;z++) {
			for(int x=0;x<arr[z].length;x++) {
				int left = arr[z+1][x];
				int right = arr[z+1][x+1];
				int sum1 = answer[z][x]+left;
				int sum2 = answer[z][x]+right;
				if(answer[z+1][x] < sum1) answer[z+1][x]=sum1;
				if(answer[z+1][x+1] < sum2) answer[z+1][x+1]=sum2;
				max = Math.max(max, sum1);
				max = Math.max(max, sum2);
			}
		}

		System.out.println(max);
	}

}
