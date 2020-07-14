package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2638_치즈 {
	public static int v[][],N,M,map[][];
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_치즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s=br.readLine().split(" ");
		N =Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];
		int che=0;
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<M;x++) {
				map[z][x] = Integer.parseInt(s[x]);
				if(map[z][x]==1) che++;
			}
		}
		
		int turn=0;
		while(true) {
//			printmap();
			v = new int[N][M];
			int cnt = 1;
case1:		for(int z=0;z<N;z++) {
				for(int x=0;x<M;x++) {
					if(v[z][x]==0 && map[z][x]==0) {
						dfs(z,x,cnt);
						cnt++;
						break case1;
					}
				}
			}
//			System.out.println();
			for(int z=0;z<N;z++) {
				for(int x=0;x<M;x++) {
					if(v[z][x]==0) {
						if(check4(z,x)) {
							map[z][x]=0;
							che--;
							if(che==0) {
								System.out.println(turn+1);
								return;
							}
						}
					}
				}
			}
			turn++;
		}
	}
	private static void printmap() {
		for(int[] a : map) System.out.println(Arrays.toString(a));
		System.out.println();
	}
	private static boolean check4(int z, int x) {
		int c = 0;
		for(int k=0;k<8;k+=2) {
			int newx = z+di[k];
			int newy = x+dj[k];
			if(newx>=0 && newx<N && newy>=0 && newy<M) {
				if(v[newx][newy]==1) c++;
			}
		}
		if(c>=2) return true;
		else return false;
	}
	public static int di[]= {0,-1,-1,-1,0,1,1,1}, dj[]= {-1,-1,0,1,1,1,0,-1};
	private static void dfs(int z, int x,int cnt) {
		v[z][x] = cnt;
		for(int k=0;k<8;k+=2) {
			int newx = z+di[k];
			int newy = x+dj[k];
			if(newx>=0 && newx<N && newy>=0 && newy<M && v[newx][newy]==0 && map[newx][newy]==0) {
				dfs(newx,newy,cnt);
			}
		}
	}

}
