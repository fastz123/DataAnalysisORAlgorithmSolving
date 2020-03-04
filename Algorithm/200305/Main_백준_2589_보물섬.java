import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2589_보물섬 {
	public static int v[][];
	public static char map[][];
	public static int h,w,di[]= {0,-1,0,1},dj[]= {-1,0,1,0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_보물섬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		h = Integer.parseInt(s[0]);
		w = Integer.parseInt(s[1]);
		map = new char[h][w];
		for(int z=0;z<h;z++) {
			String ss = br.readLine();
			for(int x=0;x<w;x++) {
				map[z][x] = ss.charAt(x);
			}
		}
		
		int max = -1;
		for(int z=0;z<h;z++) {
			for(int x=0;x<w;x++) {
				if(map[z][x] == 'L') {
					v = new int[h][w];
					fillmax();
					int curmax = bfs(z,x);
					max = Math.max(curmax, max);
				}
			}
		}
		System.out.println(max);

	}
	private static void printmap(int[][] v) {
		for(int[] a : v) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("------------------------------------");
	}
	private static void fillmax() {
		for(int z=0;z<h;z++) {
			for(int x=0;x<w;x++) {
				v[z][x] = Integer.MAX_VALUE;
			}
		}
	}
	public static Queue<int[]> q = new LinkedList<>();
	private static int bfs(int i, int j) {
		int max = -1;
		v[i][j]=0;
		q.offer(new int[] {i,j,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<h && newy>=0 && newy<w && map[newx][newy]=='L' && v[newx][newy]>cur[2]+1 && v[newx][newy]!=0) {
					v[newx][newy] = cur[2]+1;
					if(cur[2]+1 > max) max = cur[2]+1;
					q.offer(new int[] {newx,newy,cur[2]+1});
				}
			}
		}
		return max;
	}

}
