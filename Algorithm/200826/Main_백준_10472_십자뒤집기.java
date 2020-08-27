package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_10472_십자뒤집기 {
	public static class C{
		int cur;
		int[][] map;
		public C(int cur, int[][] map) {
			this.cur = cur;
			this.map = map;
		}
	}
	public static int[][] target;
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int z=0;z<T;z++) {
			target = new int[3][3];
			for(int p=0;p<3;p++) {
				String s = br.readLine();
				for(int q=0;q<3;q++) {
					if(s.charAt(q)=='.') target[p][q] = 0;
					else target[p][q] = 1;
				}
			}
			min = Integer.MAX_VALUE;
			v = new boolean[3][3];
			int[][] map = new int[3][3];
			bfs(0,map);
			
			bw.write(min+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	public static int min,di[]= {0,-1,0,1}, dj[]= {-1,0,1,0};
	
//	private static void dfs(int cnt) {
//		if(min < cnt) return;
//		if(check()) {
//			min = Math.min(min, cnt);
//			return;
//		}
//		else {
//			for(int z=0;z<3;z++) {
//				for(int x=0;x<3;x++) {
//					if(!v[z][x]) {
//						v[z][x] = true;
//						click(z,x);
//						dfs(cnt+1);
//						click(z,x);
//						v[z][x]=false;
//					}
//				}
//			}
//		}
//	}
	
	private static void bfs(int cnt, int[][] map) {
		Queue<C> q = new LinkedList<>();
		q.offer(new C(cnt,map));
		while(!q.isEmpty()) {
			C c = q.poll();
			if(c.cur>min) break;
			if(check(c.map)) {
				min = Math.min(min, c.cur);
				return;
			}else {
				for(int z=0;z<3;z++) {
					for(int x=0;x<3;x++) {
						if(!v[z][x]) {
							v[z][x] = true;
							int[][] copy = new int[3][3];
							copying(copy,map);
							C nc = new C(c.cur+1,copy);
							click(z,x,nc);
							q.offer(nc);
//							click(z,x,nc);
//							v[z][x]=false;
						}
					}
				}
			}
		}
	}

	private static void copying(int[][] copy, int[][] map) {
		for(int z=0;z<3;z++) {
			for(int x=0;x<3;x++) {
				copy[z][x] = map[z][x];
			}
		}
	}

	private static void click(int i, int j, C nc) {
		if(nc.map[i][j]==0) nc.map[i][j]=1;
		else nc.map[i][j] = 0;
		for(int z=0;z<4;z++) {
			int newx = i+di[z];
			int newy = j+dj[z];
			if(newx>=0 && newx<3 && newy>=0 && newy<3) {
				if(nc.map[newx][newy]==0) nc.map[newx][newy]=1;
				else nc.map[newx][newy] = 0;
			}
		}
	}

	private static boolean check(int[][] map) {
		for(int z=0;z<3;z++) {
			for(int x=0;x<3;x++) {
				if(map[z][x] != target[z][x]) return false;
			}
		}
		return true;
	}

}
