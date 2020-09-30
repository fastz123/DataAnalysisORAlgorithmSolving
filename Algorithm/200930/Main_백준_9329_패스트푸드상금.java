package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_9329_패스트푸드상금 {
	public static int n,M,arr[][], score[], having[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_패스트푸드상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			
			arr = new int[n][];
			score = new int[n];
			
			for(int z=0;z<n;z++) {
				s = br.readLine().split(" ");
				int k = Integer.parseInt(s[0]);
				int[] cur = new int[k];
				for(int p=1;p<=k;p++) {
					cur[p-1] = Integer.parseInt(s[p])-1;
				}
				arr[z] = cur;
				score[z] = Integer.parseInt(s[k+1]);
			}
			
			having = new int[M];
			s = br.readLine().split(" ");
			for(int z=0;z<M;z++) {
				having[z] = Integer.parseInt(s[z]);
			}
			
			int sum = 0;
			for(int i=0;i<n;i++) {
				int min = Integer.MAX_VALUE;
				for(int cur : arr[i]) {
					min = Math.min(having[cur], min);
				}
				sum += min*score[i];
			}
			System.out.println(sum);
			
			T--;
		}

	}

}
