import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_17836_공주구출 {
	public static int v[][][],R,C,t,map[][],di[]= {0,-1,0,1},dj[]= {-1,0,1,0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_공주구출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		t = Integer.parseInt(s[2]);
		map = new int[R][C];
		int sx=-1;
		int sy=-1;
		for(int z=0;z<R;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<C;x++) {
				map[z][x] = Integer.parseInt(s[x]);
				if(map[z][x]==2) {
					sx=z;
					sy=x;
				}
			}
		}
		v = new int[2][R][C];
		fillmax();
		bfs2(0,0,0);
		if(v[0][R-1][C-1]<=t || v[1][R-1][C-1]<=t) System.out.println(v[1][R-1][C-1]>v[0][R-1][C-1]? v[0][R-1][C-1]:v[1][R-1][C-1]);
		else System.out.println("Fail");
	}
	private static void bfs2(int i, int j, int k) {
		q.offer(new int[] {i,j,k,0});
		v[0][i][j] = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
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
					}
				}
				
			}
		}
		
	}
	public static Queue<int[]> q = new LinkedList<>();
	
	private static void fillmax() {
		for(int k=0;k<2;k++) {
			for(int z=0;z<R;z++) {
				for(int x=0;x<C;x++) {
					v[k][z][x] = Integer.MAX_VALUE;
				}
			}
		}
	}
}
