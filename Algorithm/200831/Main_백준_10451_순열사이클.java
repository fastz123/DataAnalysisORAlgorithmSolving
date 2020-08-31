package algoProblems;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main_백준_10451_순열사이클 {
	public static boolean v[];
	public static int arr[],len;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			
			len = Integer.parseInt(br.readLine());
			arr = new int[len];
			String[] s = br.readLine().split(" ");
			for(int z=0;z<len;z++) {
				arr[z] = Integer.parseInt(s[z])-1;
			}
			
			v = new boolean[len];
			int cnt = 0;
			for(int z=0;z<len;z++) {
				if(!v[z]) {
					cnt++;
					dfs(z);
				}
			}
			
			System.out.println(cnt);
			T--;
		}

	}
	private static void dfs(int i) {
		int cur = arr[i];
		if(!v[cur]) {
			v[cur]=true;
			dfs(cur);
		}
	}

}
