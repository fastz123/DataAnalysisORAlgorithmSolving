import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_17472_다리만들기2 {

	public static class Bridge{
		int stx;
		int sty;
		int endx;
		int endy;
		int from;
		int to;
		public Bridge(int stx, int sty, int endx, int endy, int from, int to) {
			this.stx = stx;
			this.sty = sty;
			this.endx = endx;
			this.endy = endy;
			this.from = from;
			this.to = to;
		}
		public int length() {
			if(this.stx-this.endx == 0) {
				return endy-sty+1;
			}
			else {
				return this.endx-this.stx+1;
			}
		}
	}
	public static ArrayList<Bridge> blist;
	public static int v[][],arr[][],N,M,cnt;
	public static boolean visit[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_다리만들기2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[N][M];
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<M;x++) {
				arr[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		v = new int[N][M];
		cnt=1;
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(arr[z][x]!=0 && v[z][x]==0) {
					grouping(z,x,cnt);
					cnt++;
				}
			}
		}

		blist = new ArrayList<>();
		checking();
		min = Integer.MAX_VALUE;
		//makebridge
		for(int z=0;z<(1<<blist.size());z++) {
//			z= 27;
			ArrayList<Bridge> selectlist = new ArrayList<>();
			for(int k=0;k<blist.size();k++) {
				if((z&(1<<k))>0) {
					selectlist.add(blist.get(k));
				}
			}
			
			int[][] map = buildBridge(selectlist);
			visit = new boolean[cnt-1];
			c = 0;
			dfs(map,0);
			if(c==cnt-1) {
				int sum = 0;
				for(Bridge b : selectlist) {
					sum+=b.length();
				}
				if(min>sum) min = sum;
			}
		}
		System.out.println(min==Integer.MAX_VALUE? -1:min);
	}
	
	public static int c,min;
	private static void dfs(int[][] map, int i) {
		c++;
		visit[i]=true;
		for(int k=0;k<cnt-1;k++) {
			if(!visit[k] && map[i][k]==1) {
				visit[k]=true;
				dfs(map,k);
			}
		}
		
	}

	private static int[][] buildBridge(ArrayList<Bridge> selectlist) {
		int[][] map = new int[cnt-1][cnt-1];
		for(Bridge b : selectlist) {
			int from = b.from-1;
			int to = b.to-1;
			map[from][to]=1;
			map[to][from]=1;
		}
		
		return map;
	}

	private static void checking() {
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(arr[z][x]==1) {
					//오른쪽
					if(x+1<M && arr[z][x+1]==0) {
						int cury=x+1;
						while(true) {
							cury++;
							if(cury==M) break;
							if(arr[z][cury]==1) {
								if(Math.abs((cury-1)-(x+1))>=1) blist.add(new Bridge(z, x+1, z, cury-1,v[z][x],v[z][cury]));
								break;
							}
						}
					}
					//아래
					if(z+1<N && arr[z+1][x]==0) {
						int curx = z+1;
						while(true) {
							curx++;
							if(curx==N) break;
							if(arr[curx][x]==1) {
								if(Math.abs((curx -1) - (z+1))>=1) blist.add(new Bridge(z+1, x, curx-1, x,v[z][x],v[curx][x]));
								break;
							}
						}
					}
				}
			}
		}
	}

	public static int di[]= {0,-1,0,1},dj[]= {-1,0,1,0};
	private static void grouping(int i,int j,int cnt) {
		v[i][j] = cnt;
		for(int z=0;z<4;z++) {
			int newx = i+di[z];
			int newy = j+dj[z];
			if(newx>=0&& newx<N && newy>=0 && newy<M) {
				if(arr[newx][newy]==1 && v[newx][newy]==0) {
					grouping(newx,newy,cnt);
				}
			}
		}
	}

}
