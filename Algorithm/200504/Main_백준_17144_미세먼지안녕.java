package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_17144_미세먼지안녕 {
	public static int N,M,map[][],stx1,stx2;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_미먼안.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int T = Integer.parseInt(s[2]);
		
		map = new int[N][M];
		
		stx2 = -1;
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<M;x++) {
				map[z][x] = Integer.parseInt(s[x]);
				if(map[z][x] == -1) stx2 = z;
			}
		}
		stx1 = stx2-1;
		
		int t = 0;
		while(true) {
			if(t==T) break;
			Hwacksan();
			int[][] copymap = new int[N][M];
			copying(map,copymap);
			UpsideMove(copymap);
			DownsideMove(copymap);
			t++;
		}
		
		int res = calcul();
		System.out.println(res);
	}
	private static int calcul() {
		int sum = 0;
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(map[z][x] >0) sum+=map[z][x];
			}
		}
		return sum;
	}
	public static int di[]= {0,-1,0,1} , dj[]= {-1,0,1,0};
	private static void Hwacksan() {
		int[][] newmap = new int[N][M];
		
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(map[z][x] > 0) {
					int cnt = 0;
					for(int k=0;k<4;k++) {
						int newx = z+di[k];
						int newy = x+dj[k];
						if(newx>=0 && newx<N && newy>=0 && newy<M && map[newx][newy]!=-1) cnt++;
					}
					int center = map[z][x] - ((map[z][x]/5) * cnt);
					newmap[z][x] += center;
					for(int k=0;k<4;k++) {
						int newx = z+di[k];
						int newy = x+dj[k];
						if(newx>=0 && newx<N && newy>=0 && newy<M && map[newx][newy]!=-1) {
							newmap[newx][newy] += map[z][x]/5;
						}
					}
				}
			}
		}
		
		newmap[stx1][0]=-1;
		newmap[stx2][0]=-1;
		
		copying(newmap,map);
	}

	private static void copying(int[][] newmap, int[][] map) {
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				map[z][x] = newmap[z][x];
			}
		}
	}

	private static void DownsideMove(int[][] copymap) {
		
		for(int z=1;z<M-1;z++) map[stx2][z+1] = copymap[stx2][z];
		for(int z=stx2;z<N-1;z++) map[z+1][M-1] = copymap[z][M-1];
		for(int z=M-1;z>=1;z--) map[N-1][z-1] = copymap[N-1][z];
		for(int z=stx2+2;z<N;z++) map[z-1][0] = copymap[z][0];
		map[stx2][1] = 0;
	}

	private static void UpsideMove(int[][] copymap) {
		
		
		for(int z=1;z<M-1;z++) map[stx1][z+1] = copymap[stx1][z];
		for(int z=stx1;z>=1;z--) map[z-1][M-1] = copymap[z][M-1];
		for(int z=M-1;z>=1;z--) map[0][z-1] = copymap[0][z];
		for(int z=0;z<stx1-1;z++) map[z+1][0] = copymap[z][0];
		map[stx1][1] = 0;
	}

}
