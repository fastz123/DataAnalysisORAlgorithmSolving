package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_17086_아기상어2 {

	static int map[][], di[]= {0,-1,0,1,-1,-1,1,1}, dj[]= {-1,0,1,0,-1,1,1,-1}, v[][],N,M;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_아기상어2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		Queue<Integer> q = new LinkedList<>();
		v = new int[N][M];
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<M;x++) {
				map[z][x] = Integer.parseInt(s[x]);
				if(map[z][x]==1) q.offer(z*M+x);
				v[z][x] = Integer.MAX_VALUE;
			}
		}
		
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int stx = cur/M;
			int sty = cur%M;
			v[stx][sty]=0;
			bfs(stx,sty);
		}
		
		System.out.println(checkmap());
	}
	private static int checkmap() {
		int max = Integer.MIN_VALUE;
		for(int[] m : v) {
			for(int c : m) max = Math.max(c, max);
		}
		return max;
	}
	
	static Queue<int[]> qq;
	private static void bfs(int stx, int sty) {
		qq = new LinkedList<>();
		qq.offer(new int[] {stx,sty,0});
		while(!qq.isEmpty()) {
			int[] cur = qq.poll();
			
			for(int z=0;z<8;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				
				if(newx>=0 && newx<N && newy>=0 && newy<M && cur[2]+1 < v[newx][newy]) {
					v[newx][newy]=cur[2]+1;
					qq.offer(new int[] {newx,newy,v[newx][newy]});
				}
			}
		}
	}

}
