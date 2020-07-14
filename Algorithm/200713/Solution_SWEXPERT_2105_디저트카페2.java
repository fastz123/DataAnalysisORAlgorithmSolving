import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_2105_디저트카페2 {
	public static class Bus{
		int stx;
		int sty;
		int x;
		int y;
		int cnt;
		int see;
		ArrayList<Integer> list;
		public Bus(int stx, int sty,int x, int y, int cnt,int see) {
			this.stx = stx;
			this.sty = sty;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.see = see;
		}
	}
	public static boolean v[][];
	public static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn( new FileInputStream( "res/input_디저트카페.txt" ));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int z=0;z<N;z++) {
				String[] s = br.readLine().split(" ");
				for(int x=0;x<N;x++) {
					map[z][x] = Integer.parseInt(s[x]);
				}
			}
			
			max = Integer.MIN_VALUE;
			for(int z=0;z<N;z++) {
				for(int x=0;x<N;x++) {
					if((z==0 && x==0) || (z==0&&x==N-1) || (z==N-1 && x==0) || (z==N-1 && x==N-1) ) continue;
					Bus bus = new Bus(z, x, z, x, 0,2);
					ArrayList<Integer> list = new ArrayList<>();
					list.add(map[z][x]);
					bus.list = list;
					v = new boolean[N][N];
					v[z][x]=true;
					dfs(bus);
				}
			}
			System.out.println("#"+(i+1)+" "+(max==Integer.MIN_VALUE? -1:max));
		}
	}
	public static int di[]= {-1,-1,1,1}, dj[]= {-1,1,1,-1},N,max;
	private static void dfs(Bus bus) {
//		if(bus.cnt>0 && bus.x==bus.stx && bus.y==bus.sty) {
//			System.out.println(bus.list);
		int curx = bus.x;
		int cury = bus.y;
		int csee = bus.see;
		for(int z=0;z<=1;z++) {
			int newx = curx+di[(csee+z)%4];
			int newy = cury+dj[(csee+z)%4];
			if(newx>=0 && newx<N && newy>=0 && newy<N && !v[newx][newy] && !bus.list.contains(map[newx][newy]) ) {
				if((newx==0 && newy==0) || (newx==N-1&&newy==0) || (newx==0&&newy==N-1) || (newx==N-1&&newy==N-1)) continue;
				if(bus.cnt<4) {
					v[newx][newy]=true;
					bus.x = newx;
					bus.y = newy;
					if(z==1) bus.cnt += 1;
					bus.see = (csee+z)%4;
					bus.list.add(map[newx][newy]);
					dfs(bus);
					bus.list.remove(bus.list.size()-1);
					bus.see = csee;
					if(z==1) bus.cnt -= 1;
					bus.x = curx;
					bus.y = cury;
					v[newx][newy]=false;
				}
			}
			if(bus.cnt==3 && (newx>=0 && newx<N && newy>=0 && newy<N) && 
					newx==bus.stx && newy==bus.sty) {
//				System.out.println(bus.list);
//				printmap();
//				System.out.println("------------------------------");
				max = Math.max(max, bus.list.size());
				return;
			}
		}
	}
	private static void printmap() {
		for(boolean a[]:v) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}
}
