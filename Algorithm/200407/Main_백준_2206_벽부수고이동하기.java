package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2206_벽부수고이동하기 {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_벽부이동.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];
		for(int z=0;z<N;z++) {
			String ss = br.readLine();
			for(int x=0;x<M;x++) {
				map[z][x] = ss.charAt(x)-'0';
			}
		}
		v = new int[2][N][M];
		for(int[][] c:v) {
			for(int[] cc : c) Arrays.fill(cc, Integer.MAX_VALUE);
		}
		v[0][0][0]=0;
		bfs(0,0);
		
		int res = Math.min(v[0][N-1][M-1], v[1][N-1][M-1]);
		System.out.println(res==Integer.MAX_VALUE? -1:res+1);
	}

	public static Queue<int[]> q = new LinkedList<>();
	public static int map[][],di[]= {0,-1,0,1},dj[]= {-1,0,1,0},N,M,v[][][];
	private static void bfs(int i, int j) {
		q.offer(new int[] {i,j,0,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<N && newy>=0 && newy<M && (newx+newy!=0 && v[cur[3]][newx][newy]>cur[2]+1)) {
					//뚫을수 있는경우
					if(cur[3]==0) {
						if(map[newx][newy]==1) {
							v[cur[3]+1][newx][newy] = cur[2]+1;
							q.offer(new int[] {newx,newy,cur[2]+1,cur[3]+1});
						}
						else {
							v[cur[3]][newx][newy] = cur[2]+1;
							q.offer(new int[] {newx,newy,cur[2]+1,cur[3]});
						}
					}
					//없는 경우
					else {
						if(map[newx][newy]!=1) {
							v[cur[3]][newx][newy] = cur[2]+1;
							q.offer(new int[] {newx,newy,cur[2]+1,cur[3]});
						}
					}
				}
			}
		}
	}
}
