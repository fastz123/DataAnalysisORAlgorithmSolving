package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_17836_공주님을구해라 {
	public static int di[]= {0,-1,0,1}, dj[]= {-1,0,1,0},v[][][],R,C,T,map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_공주님을구해라.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" " );
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		T = Integer.parseInt(s[2]);
		
		map = new int[R][C];
		
		for(int z=0;z<R;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<C;x++) {
				map[z][x] = Integer.parseInt(s[x]);
			}
		}
		q = new LinkedList<>();
		v = new int[2][R][C];
		for(int k=0;k<2;k++) {
			for(int z=0;z<R;z++) Arrays.fill(v[k][z], Integer.MAX_VALUE);
		}
		v[0][0][0]=0;
		min = Integer.MAX_VALUE;
		bfs(0,0);
		min = Math.min(v[0][R-1][C-1], v[1][R-1][C-1]);
		System.out.println(min==Integer.MAX_VALUE? "Fail":min);
	}
	public static int min;
	public static Queue<int[]> q;
	private static void bfs(int i, int j) {
		q.offer(new int[] {i,j,0,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[2]>=T) continue;
			
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(cur[3]==1 && newx>=0 && newx<R && newy>=0 && newy<C && v[1][newx][newy]>cur[2]+1) {
					v[1][newx][newy]=cur[2]+1;
					q.offer(new int[] {newx,newy,cur[2]+1,1});
				}
				else if(cur[3]==0 && newx>=0 && newx<R && newy>=0 && newy<C && v[0][newx][newy] > cur[2]+1 && map[newx][newy]!=1) {
					v[0][newx][newy]=cur[2]+1;
					if(map[newx][newy]==0) q.offer(new int[] {newx,newy,cur[2]+1,0});
					else {
						v[1][newx][newy]=cur[2]+1;
						q.offer(new int[] {newx,newy,cur[2]+1,1});
						q.offer(new int[] {newx,newy,cur[2]+1,0});
					}
				}
				
			}
		}
	}

}
