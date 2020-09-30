package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_11508_2plus1세일 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N  = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int z=0;z<N;z++) {
			arr[z] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);

		int cur = 0;
		int sum = 0;
		int cnt = 1;
		for(cur=N-1;cur>=0;cur-=1) {
			if(cnt%3==0) {
				cnt=1;
				continue;
			}
			sum += arr[cur];
			cnt++;
		}
		System.out.println(sum);
		
	}

}
