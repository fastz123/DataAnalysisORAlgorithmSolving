package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_5650_핀볼게임 {
	public static class Ball{
		int x;
		int y;
		int see;
		int score;
		public Ball(int x, int y, int see) {
			this.x = x;
			this.y = y;
			this.see = see;
			this.score = 0;
		}
	}
	
	public static class Hole{
		int x;
		int y;
		public Hole(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static ArrayList<Hole> hlist[];
	public static Ball cur;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_핀볼게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N+2][N+2];
			
			for(int z=0;z<N+2;z++) {
				map[N+1][z] = 5;
				map[0][z] = 5;
			}
			for(int z=1;z<N+1;z++) {
				map[z][N+1] = 5;
				map[z][0] = 5;
			}
			
			hlist = new ArrayList[5];
			for(int z=0;z<5;z++) hlist[z] = new ArrayList<>();
			for(int z=1;z<=N;z++) {
				String[] s = br.readLine().split(" ");
				for(int x=1;x<=N;x++) {
					int cur = Integer.parseInt(s[x-1]);
					if(cur>=6 && cur<=10) {
						hlist[cur-6].add(new Hole(z,x));
					}
					map[z][x] = cur;
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			for(int z=1;z<=N;z++) {
				for(int x=1;x<=N;x++) {
					if(map[z][x]!=0) continue;
					for(int see=0;see<4;see++) {
						cur = new Ball(z,x,see);
						stx = z;
						sty = x;
						go(cur);
						while(true) {
							if(map[cur.x][cur.y]==-1 ||(stx == cur.x && sty == cur.y)) break;
							
							go(cur);
						}
						
						max = Math.max(max, cur.score);
					}
				}
			}
			
			System.out.println("#"+i+" "+max);
			
		}

	}
	
	public static int N, di[]= {0,-1,0,1}, dj[]= {-1,0,1,0}, stx, sty, map[][];
	private static void go(Ball cur) {
		//이동
		int newx = cur.x+di[cur.see];
		int newy = cur.y+dj[cur.see];
		
		if(map[newx][newy]==5) {
			if(cur.see == 0) cur.see = 2;
			else if(cur.see == 1) cur.see=3;
			else if(cur.see == 2) cur.see=0;
			else cur.see=1;
			cur.score++;
			
			cur.x = newx;
			cur.y = newy;
		}
		else if(map[newx][newy]==0 || map[newx][newy]==-1) {
			cur.x = newx;
			cur.y = newy;
		}
		else if(map[newx][newy]>=1 && map[newx][newy]<=4) {
			block(newx,newy,cur);
			cur.score++;
		}
		else if(map[newx][newy]>5) {
			warm(map[newx][newy],cur,newx,newy);
		}
	}
	
	private static void warm(int num, Ball cur, int newx, int newy) {
		ArrayList<Hole> curlist = hlist[num-6];
		if(curlist.get(0).x == newx && curlist.get(0).y==newy) {
			cur.x = curlist.get(1).x;
			cur.y = curlist.get(1).y;
		}
		else {
			cur.x = curlist.get(0).x;
			cur.y = curlist.get(0).y;
		}
	}
	
	private static void block(int newx, int newy, Ball cur) {
		if(map[newx][newy]==1) {
			if(cur.see==0) {
				cur.see = 1;
			}
			else if(cur.see==1) {
				cur.see = 3;
			}
			else if(cur.see==2) {
				cur.see = 0;
			}
			else if(cur.see==3) {
				cur.see = 2;
			}
		}
		else if(map[newx][newy]==2) {
			if(cur.see==0) {
				cur.see = 3;
			}
			else if(cur.see==1) {
				cur.see = 2;
			}
			else if(cur.see==2) {
				cur.see = 0;
			}
			else if(cur.see==3) {
				cur.see = 1;
			}
		}
		else if(map[newx][newy]==3) {
			if(cur.see==0) {
				cur.see = 2;
			}
			else if(cur.see==1) {
				cur.see = 0;
			}
			else if(cur.see==2) {
				cur.see = 3;
			}
			else if(cur.see==3) {
				cur.see = 1;
			}
		}
		else if(map[newx][newy]==4) {
			if(cur.see==0) {
				cur.see = 2;
			}
			else if(cur.see==1) {
				cur.see = 3;
			}
			else if(cur.see==2) {
				cur.see = 1;
			}
			else if(cur.see==3) {
				cur.see = 0;
			}
		}
		cur.x = newx;
		cur.y = newy;
	}

}
