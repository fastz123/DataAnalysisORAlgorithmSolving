package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_백준_1303_전쟁_전투 {
	public static int N,M,v[][];
	public static char map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new char[M][N];
		for(int z=0;z<M;z++) {
			String ss = br.readLine();
			for(int x=0;x<N;x++) {
				map[z][x] = ss.charAt(x);
			}
		}
		
		int white = 1;
		int blue = -1;
		
		int ws=0;
		int bs=0;
		v = new int[M][N];
		for(int z=0;z<M;z++) {
			for(int x=0;x<N;x++) {
				if(map[z][x]=='W' && v[z][x]!=1) {
					v[z][x] = 1;
					wc=1;
					dfs(white,z,x,'W');
					ws+=Math.pow(wc, 2);
				}
				else if(map[z][x]=='B' && v[z][x]!=-1) {
					v[z][x] = -1;
					bc=1;
					dfs(blue,z,x,'B');
					bs+=Math.pow(bc, 2);
				}
			}
		}
		
		System.out.println(ws+" "+bs);
		
	}

	public static int di[]= {0,-1,0,1}, dj[]= {-1,0,1,0},wc,bc;
	private static void dfs(int color, int i, int j,char c) {
		
		for(int z=0;z<4;z++) {
			int newx = i+di[z];
			int newy = j+dj[z];
			if(newx>=0 && newx<M && newy>=0 && newy<N && map[newx][newy]==c && v[newx][newy]==0) {
				if(color==1) wc++;
				else bc++;
				v[newx][newy] = color;
				dfs(color,newx,newy,c);
			}
		}
	}

}
