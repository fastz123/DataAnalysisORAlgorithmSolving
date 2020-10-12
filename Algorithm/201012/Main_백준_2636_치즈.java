package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2636_치즈 {
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M= Integer.parseInt(s[1]);
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		
		
		int remain = 0;
		int time = 0;
		while(true) {
			int cur = check();
			if(cur>0) remain = cur; 
			else break;
			
			time++;
			v = new boolean[N][M];
			bfs(0,0);
		}
		
		bw.write(time+" "+remain);
		bw.flush();
	}
	private static int check() {
		int sum = 0;
		for(int[] a : map) {
			for(int c : a) if(c==1) sum++;
		}
		return sum;
	}
	public static Queue<int[]> q = new LinkedList<int[]>();
	public static int di[]= {0,-1,0,1}, dj[]= {-1,0,1,0}, N,M,map[][];
	private static void bfs(int i, int j) {
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(map[cur[0]][cur[1]]==1) {
				map[cur[0]][cur[1]]=0;
				continue;
			}
			
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				
				if(newx>=0 && newx<N && newy>=0 && newy<M && !v[newx][newy]) {
					v[newx][newy]=true;
					q.offer(new int[] {newx,newy});
				}
			}
		}
	}

}
