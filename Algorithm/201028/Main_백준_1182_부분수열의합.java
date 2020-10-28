package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_1182_부분수열의합 {
	public static int N,S,cnt,arr[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_부분수열의합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		
		arr = new int[N];
		s = br.readLine().split(" ");
		for(int z=0;z<N;z++) arr[z] = Integer.parseInt(s[z]);
		
		cnt = 0;
		dfs(0,0);
		System.out.println(cnt);
	}

	private static void dfs(int i, int sum) {
		
		if(i==N) return;
		
		sum += arr[i];
		if(sum==S) {
			cnt++;
		}
		
		//더하기
		dfs(i+1,sum);
		//안더하기
		dfs(i+1,sum-arr[i]);
	}

}
