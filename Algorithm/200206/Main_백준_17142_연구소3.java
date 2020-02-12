import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_17142_연구소3_2 {
	
	public static class virus{
		int x;
		int y;
		
		public virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	
	public static int size,arr[][],N,v[][],area;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_연구소3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		size = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		
		ArrayList<virus> viruslist = new ArrayList<>();
		arr = new int[size][size];
		area = size*size;
		for(int z=0;z<size;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<size;x++) {
				arr[z][x] = Integer.parseInt(s[x]);
				if(arr[z][x]==2) {
					viruslist.add(new virus (z,x));
					area--;
				}
				else if(arr[z][x]==1) area--;
			}
		}
		if(area==0) {
			System.out.println(0);
			return;
		}
		
		visit = new boolean [viruslist.size()];
		min = Integer.MAX_VALUE;
		b = new virus[N];
		comb(0,0,viruslist);
		
		
//		if(area==0) System.out.println(0);
		System.out.println(min==Integer.MAX_VALUE? -1:min);
		
		
	}
	
	public static ArrayList<int[]> selectlist = new ArrayList<>();
	public static boolean visit[],vst[][];
	public static virus b[];
	private static void comb(int start,int count,ArrayList<virus> viruslist) {
		if(count==N) {
			v = new int[size][size];
			for(int[] a : v) Arrays.fill(a, Integer.MAX_VALUE);
			
			for(virus vi : viruslist) {
				int x = vi.x;
				int y = vi.y;
				v[x][y]=-1;
			}
			c=0;
			for(virus vi : b) {
				vst = new boolean[size][size];
				bfs(vi.x,vi.y);
			}
			
			if(area==c) {
				int res = check(v);
				if(res < min) {
					min = res;
				}
			}
			
		}
		else {
			for(int i=start;i<viruslist.size();i++) {
				if(!visit[i]) {
					visit[i]=true;
					b[count] = viruslist.get(i);
					comb(i,count+1,viruslist);
					visit[i]=false;
				}
			}
		}
	}

	public static int min;
	private static int check(int[][] v) {
		int max = -1;
		for(int z=0;z<size;z++) {
			for(int x=0;x<size;x++) {
				if(v[z][x]!=-1 && v[z][x]!=Integer.MAX_VALUE && max<v[z][x]) max = v[z][x];
			}
		}
		return max;
	}
	public static int di[]= {0,-1,0,1}, dj[]= {-1,0,1,0},c;
	public static Queue<int[]> q = new LinkedList<>();
	private static void bfs(int i, int j) {
		q.offer(new int[] {i,j,1});
		v[i][j]=0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<size && newy>=0 && newy<size&&!vst[newx][newy] && arr[newx][newy]!=1 && (v[newx][newy]==-1 || v[newx][newy]>cur[2])) {
					if(v[newx][newy]==Integer.MAX_VALUE && arr[newx][newy]==0) c++;
					if(v[newx][newy]!=-1) v[newx][newy] = cur[2];
					vst[newx][newy]=true;
					q.offer(new int[] {newx,newy,cur[2]+1});
				}
			}
		}
	}

}
