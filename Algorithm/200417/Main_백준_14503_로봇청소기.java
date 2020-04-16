package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_14503_로봇청소기 {
	public static class robot{
		int x;
		int y;
		int see;
		public robot(int x, int y, int see) {
			this.x = x;
			this.y = y;
			this.see = see;
		}
	}
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_로봇청소기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] map = new int[N][M];
		
		s = br.readLine().split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		int see = Integer.parseInt(s[2]);
		robot r = new robot(x,y,see);
		
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int a=0;a<M;a++) {
				map[z][a] = Integer.parseInt(s[a]);
			}
		}
		arrs= new int[N][M];
		while(true) {
			clean(r,map); //청소
			
			boolean f = false;
			for(int z=0;z<4;z++) {
				see = r.see;
				see--;//왼쪽
				if(see<0) see=3;
				
				int newx = r.x+di[see];
				int newy = r.y+dj[see];
				if(newx>=0 && newx<N && newy>=0 && newy<M) {
					if(map[newx][newy]==0) {
						r.x = newx;
						r.y = newy;
						r.see=see;
						f=true;
						break;
					}
					else{
						r.see = see;
					}
				}
			}
			if(!f) {
				see = (r.see+2)%4;
				int newx = r.x+di[see];
				int newy = r.y+dj[see];
				if(map[newx][newy]!=1) {
					r.x=newx;
					r.y=newy;
				}
				else if(map[newx][newy]==1){
					break;
				}
			}
		}
		System.out.println(cnt);
	}
	public static int di[]= {-1,0,1,0}, dj[]= {0,1,0,-1},cnt,arrs[][];
	private static void clean(robot r,int map[][]) {
		int curx = r.x;
		int cury = r.y;
		if(map[curx][cury]==0) {
			cnt++;
			map[curx][cury]=7;
		}
	}

}
