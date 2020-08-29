package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_백준_11123_양한마리양두마리 {
	public static boolean v[][];
	public static int cnt,H,W;
	public static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			String[] s = br.readLine().split(" ");
			H = Integer.parseInt(s[0]);
			W = Integer.parseInt(s[1]);
			
			map = new char[H][W];
			
			for(int z=0;z<H;z++) {
				String ss = br.readLine();
				for(int x=0;x<W;x++) {
					map[z][x]=ss.charAt(x);
				}
			}
			
			v = new boolean[H][W];
			cnt = 0;
			for(int z=0;z<H;z++) {
				for(int x=0;x<W;x++) {
					if(map[z][x]=='#' && !v[z][x]) {
						v[z][x] = true;
						cnt++;
						dfs(z,x);
					}
				}
			}
			
			System.out.println(cnt);
			T--;
		}
		
		
	}
	
	public static int di[]= {0,-1,0,1}, dj[]= {-1,0,1,0};
	private static void dfs(int i,int j) {
		for(int z=0;z<4;z++) {
			int newx = i+di[z];
			int newy = j+dj[z];
			if(newx>=0 && newx<H && newy>=0 && newy<W && map[newx][newy]=='#' && !v[newx][newy]) {
				v[newx][newy] = true;
				dfs(newx,newy);
			}
		}
	}

}
