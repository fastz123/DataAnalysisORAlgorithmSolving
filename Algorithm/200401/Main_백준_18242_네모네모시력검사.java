package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_18242_네모네모시력검사 {
	public static boolean v[][];
	public static char map[][];
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_네모네모시력검사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		map = new char[M][N];
		boolean f=false;
		int stx=0,sty=0;
		for(int z=0;z<M;z++) {
			String ss = br.readLine();
			for(int x=0;x<N;x++) {
				map[z][x] = ss.charAt(x);
				if(!f && map[z][x]!='.') {
					f=true;
					stx=z; 
					sty=x;
				}
			}
		}
		
		v = new boolean[M][N];
		list = new ArrayList<>();
		bfs(stx,sty);
		int x1 = list.get(0)/N;
		int x2 = list.get(1)/N;
		int y1 = list.get(0)%N;
		int y2 = list.get(1)%N;
		if(x1==x2) {
			int curx = (x1+x2)/2;
			while(true) {
				curx++;
				if(curx>=M) {
					System.out.println("DOWN");
					break;
				}
				else if(map[curx][y1]=='#') {
					System.out.println("UP");
					break;
				}
			}
		}
		else if(y1==y2) {
			int cury = (y1+y2)/2;
			while(true) {
				cury++;
				if(cury>=N) {
					System.out.println("RIGHT");
					break;
				}
				else if(map[x1][cury]=='#') {
					System.out.println("LEFT");
					break;
				}
			}
		}
		System.out.println();
	}
	public static Queue<int[]> q = new LinkedList<>();
	public static ArrayList<Integer> list;
	public static int di[]= {0,-1,0,1},dj[]= {-1,0,1,0},M,N;
	private static void bfs(int stx, int sty) {
		v[stx][sty]=true;
		q.offer(new int[] {stx,sty});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cnt = 0;
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<M && newy>=0 && newy<N && map[newx][newy]=='#' && !v[newx][newy]) {
					cnt++;
					v[newx][newy]=true;
					q.offer(new int[] {newx,newy});
				}
			}
			if(cnt==0) list.add(cur[0]*N+cur[1]);
		}
	}

}
