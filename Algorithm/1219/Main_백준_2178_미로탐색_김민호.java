import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2178_미로탐색_김민호 {
	public static int v[][];
	public static char arr[][];
	public static int r,c,di[]= {0,-1,0,1},dj[]= {-1,0,1,0};
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_미로탐색.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		r = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);
		arr = new char[r][c];
		for(int z=0;z<r;z++) {
			String ss = br.readLine();
			for(int x=0;x<c;x++) {
				arr[z][x]=ss.charAt(x);
			}
		}
		v = new int[r][c];
		for(int z=0;z<r;z++) {
			for(int x=0;x<c;x++) {
				v[z][x]=Integer.MAX_VALUE;
			}
		}
		System.out.println(bfs(0,0)+1);
	}

	public static Queue<int[]> q = new LinkedList<>();
	private static int bfs(int i, int j) {
		q.offer(new int[] {i,j,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==r-1 && cur[1]==c-1) return v[cur[0]][cur[1]];
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<r && newy>=0 && newy<c && v[newx][newy]>cur[2]+1 && arr[newx][newy]=='1') {
					v[newx][newy]=cur[2]+1;
					q.offer(new int[] {newx,newy,v[newx][newy]});
				}
			}
		}
		return j;
	}

}
