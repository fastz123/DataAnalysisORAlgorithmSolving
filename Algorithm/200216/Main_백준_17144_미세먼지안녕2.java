import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_17144_미세먼지안녕2 {
	public static int map[][],N,M,hx,bx;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_미먼안.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int time = Integer.parseInt(s[2]);
		
		map = new int[N][M];
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<M;x++) {
				map[z][x] = Integer.parseInt(s[x]);
				if(map[z][x] == -1) bx = z;
			}
		}
		hx = bx-1;
		int ans = 0;
		int t = 0;
		while(true) {
			int[][] aftermap = new int[N][M];
			aftermap[hx][0]=-1;
			aftermap[bx][0]=-1;
			//분열
			popping(aftermap);
			System.out.println("확산후");
			printmap(aftermap);
			copying(aftermap,map);
			//이동
			moving(aftermap);
			System.out.println("이동후");
			printmap(map);
			
			t++;
			if(t==time) {
				break;
			}
		}
		System.out.println(check(map));
	}
	
	private static void printmap(int[][] map) {
		for(int[] a:map) System.out.println(Arrays.toString(a));
	}
	
	private static int check(int[][] aftermap) {
		int res = 0;
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(aftermap[z][x]!=0 && aftermap[z][x]!=-1) {
					res+=aftermap[z][x];
				}
			}
		}
		return res;
	}

	private static void moving(int[][] aftermap) {
		//상단
		
		//우
		map[hx][1]=0;
		for(int z=1;z<M-1;z++) map[hx][z+1] = aftermap[hx][z];
		//상
		for(int z=hx;z>=1;z--) map[z-1][M-1] = aftermap[z][M-1];
		//좌
		for(int z=M-1;z>=1;z--) map[0][z-1] = aftermap[0][z];
		//하
		for(int z=0;z<hx-1;z++) map[z+1][0] = aftermap[z][0];
			
		
		//하단
		//우
		map[bx][1]=0;
		for(int z=1;z<M-1;z++) map[bx][z+1] = aftermap[bx][z];
		//하
		for(int z=bx;z<N-1;z++) map[z+1][M-1] = aftermap[z][M-1];
		//좌
		for(int z=M-1;z>=1;z--) map[N-1][z-1] = aftermap[N-1][z];
		//상
		for(int z=N-1;z>bx+1;z--) map[z-1][0] = aftermap[z][0];
	}

	private static void copying(int[][] aftermap, int[][] copymap) {
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				copymap[z][x] = aftermap[z][x];
			}
		}
	}

	public static int di[]= {0,-1,0,1},dj[]= {-1,0,1,0};
	private static void popping(int[][] aftermap) {
		
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(map[z][x]!=-1 && map[z][x]!=0) {
					int c=0;
					for(int k=0;k<4;k++) {
						int newx = z+di[k];
						int newy = x+dj[k];
						if(newx>=0 && newx<N && newy>=0 && newy<M && map[newx][newy]!=-1) c++;
					}
					
					int edge = map[z][x]/5;
					int center = map[z][x] - (edge * c);
					
					aftermap[z][x] += center;
					for(int k=0;k<4;k++) {
						int newx = z+di[k];
						int newy = x+dj[k];
						if(newx>=0 && newx<N && newy>=0 && newy<M && map[newx][newy]!=-1) {
							aftermap[newx][newy]+=edge;
						}
					}
				}
			}
		}
	}
}
