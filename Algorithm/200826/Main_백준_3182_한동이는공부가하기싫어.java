package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_백준_3182_한동이는공부가하기싫어 {
	public static boolean v[],map[][];
	public static int N,res[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		
		for(int z=0;z<N;z++) {
			int cur = Integer.parseInt(br.readLine())-1;
			map[z][cur]=true;
		}
		
		res = new int[N];
		
		for(int z=0;z<N;z++) {
			v = new boolean[N];
			v[z] = true;
			cnt=0;
			dfs(z);
			res[z] = cnt;
		}
		
		int max = -1;
		int maxidx = 0;
		for(int z=0;z<N;z++) {
			if(max < res[z]) {
				max = res[z];
				maxidx = z;
			}
		}
		
		System.out.println(maxidx+1);
	}

	public static int cnt;
	private static void dfs(int i) {
		for(int z=0;z<N;z++) {
			if(map[i][z] && !v[z]) {
				v[z]=true;
				cnt++;
				dfs(z);
			}
		}
	}

}
