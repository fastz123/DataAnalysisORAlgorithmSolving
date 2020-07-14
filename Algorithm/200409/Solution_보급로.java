package practice;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_보급로 {

	public static int size,arr[][],v[][],visit[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_보급로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			size = Integer.parseInt(br.readLine());
			arr = new int[size][size];
			v = new int[size][size];
			for(int z=0;z<size;z++) {
				String s = br.readLine();
				for(int x=0;x<size;x++) {
					arr[z][x] = s.charAt(x)-'0';
					v[z][x] = Integer.MAX_VALUE;
				}
			}
			
			visit = new int[size][size];
			min = Integer.MAX_VALUE;
			bfs(0,0);
			System.out.println("#"+(i+1)+" "+v[size-1][size-1]);
			
		}

	}
	public static Queue<int[]> q = new LinkedList<>();
	public static int di[]= {0,1,0,-1}, dj[]= {1,0,-1,0},min;
	private static void bfs(int i, int j) {
		v[i][j]=0;
		q.offer(new int[] {i,j,v[i][j]});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
//			if(min<v[cur[0]][cur[1]]) continue;
//			if(cur[0]==size-1 && size-1==cur[1]) {
//				if(min>v[cur[0]][cur[1]]) min = v[cur[0]][cur[1]];
//			}
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<size && newy>=0 && newy<size ) {
					if(v[newx][newy] > v[cur[0]][cur[1]]+arr[newx][newy]) {
						//visit[newx][newy]=1;
						v[newx][newy] = v[cur[0]][cur[1]]+arr[newx][newy];
						q.offer(new int[] {newx,newy});
					}
				}
			}
		}
	}
}
