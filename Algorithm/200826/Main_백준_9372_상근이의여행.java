package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_백준_9372_상근이의여행 {
	public static int map[][],N,min;
	public static boolean v[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			map = new int[N][N];
			
			for(int z=0;z<M;z++) {
				s = br.readLine().split(" ");
				int st = Integer.parseInt(s[0])-1;
				int end = Integer.parseInt(s[1])-1;
				map[st][end] = 1;
				map[end][st] = 1;
			}
			
			min = Integer.MAX_VALUE;
			for(int z=0;z<N;z++) {
				v = new boolean[N];
				cnt=0;
				v[z] = true;
				dfs(z);
				
				min = Math.min(min, cnt);
				if(min == N-1) break;
			}
			bw.write(min+"\n");
			T--;
		}
		
		bw.flush();
		bw.close();

	}
	public static int cnt;
	private static void dfs(int i) {
		if(cnt>=min) return;
		if(cnt == N) return;
		else {
			for(int z=0;z<N;z++) {
				if(map[i][z]==1) {
					if(!v[z]) {
						v[z]=true;
						cnt++;
						dfs(z);
					}
				}
			}
		}
	}

}
