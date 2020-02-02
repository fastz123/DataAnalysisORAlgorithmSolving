import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_SWEXPERT_모의_핀볼게임3 {

	public static class Ball{
		int x;
		int y;
		int see;
		int score;
		public Ball(int x,int y, int see, int score) {
			this.x = x;
			this.y = y;
			this.see = see;
			this.score = score;
		}
	}
	public static int map[][],size,di[]= {-1,1,0,0},dj[]= {0,0,-1,1},max;
	public static Ball ball;
	public static ArrayList<int[]> warmlist[],blacklist;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_핀볼게임.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
//		int T = Integer.parseInt(br.readLine());
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
//			size = Integer.parseInt(br.readLine());
			size = sc.nextInt();
			map = new int[size+2][size+2];

			Queue<int[]> zeros = new LinkedList<>();
			
			for(int z=0;z<size+2;z++) map[0][z]=5;
			for(int z=0;z<size+2;z++) map[z][0]=5;
			for(int z=0;z<size+2;z++) map[size+1][z]=5;
			for(int z=0;z<size+2;z++) map[z][size+1]=5;

			warmlist = new ArrayList[5];
			for(int z=0;z<5;z++) warmlist[z] = new ArrayList<>();
			blacklist = new ArrayList<>();
			
			for(int z=1;z<=size;z++) {
//				String s[] = br.readLine().split(" ");
				for(int x=1;x<=size;x++) {
//					map[z][x] = Integer.parseInt(s[x]);
					map[z][x] = sc.nextInt();
					int val = map[z][x] ;
					if(val == 0 ) zeros.offer(new int[] {z,x});
					else if(val>5) warmlist[val-6].add(new int[] {z,x});
					
				}
			}
//			System.out.println(Arrays.deepToString(map));
//			System.out.println();
			max = 0;
			
			while(!zeros.isEmpty()) {
				int[] cur = zeros.poll();
				int stx = cur[0];
				int sty = cur[1];
//				stx=7;
//				sty=0;
				for(int z=0;z<4;z++) {
//					stx=8;
//					sty=6;
//					z=0;
//					z=3;
//					stx=5;
//					sty=9;
//					z=2;
					int newx = stx+di[z];
					int newy = sty+dj[z];
					if(newx>=1 && newx<=size && newy>=1 && newy<=size) {
						if(map[newx][newy]>=0) {
							ball = new Ball(newx,newy,z, 0);
							q = new LinkedList<>();
//							System.out.println("start "+stx+" "+sty+" "+z);
							bfs(stx,sty);
//							dfs(stx,sty);
//							f=false;
//							System.out.println("end "+zeros.size());
						}
//						else if(map[newx][newy]>=1 && map[newx][newy]<=5) {
//							if(max<0) max = 0;
//						}
						else if(map[newx][newy]==-1) {
							if(max<0) max = 0;
						}
					}
					else {
						if(max<0) max = 0;
					}
				}
			}
			System.out.println("#"+(i+1)+" "+max);
		}
	}
	
	public static boolean f;
	public static Queue<Ball> q;
	private static void bfs(int stx,int sty) {
		q.offer(ball);
		while(!q.isEmpty()) {
//			System.out.println("["+ball.x+","+ball.y+"] "+ball.score);
			int curx = ball.x;
			int cury = ball.y;
			int see = ball.see;
			int curVal = map[curx][cury];
			if((curx==stx && cury==sty) || curVal==-1) {
				if(max<ball.score) max = ball.score;
				return;
			}
			if(curVal!=0) {
				if(curVal>=1 && curVal<=5) {
					ball.score++;
					if(curVal==1) {
						if(see == 0) {// 북쪽을 보면서 들어왔다.
							ball.see = 1;
							ball.x++;
						}
						else if(see == 1) { // 아래를 보면서 들어옴
							ball.see = 3;
							ball.y++;
							
						}
						else if(see == 2) { //왼쪽을 보고 들어옴
							ball.see = 0;
							ball.x--;
							
						}
						else {
							ball.see = 2;
							ball.y--;
						}
					}
					else if(curVal==2) {
						if(see==0) {
							ball.see = 3;
							ball.y++;
							
						}
						else if(see==1) {
							ball.see = 0;
							ball.x--;
						}
						else if(see==2) {
							ball.see=1;
							ball.x++;
							
						}
						else {
							ball.see=2;
							ball.y--;
						}
					}
					else if(curVal==3) {
						if(see==0) { //위보면서 들옴
							ball.see = 2;
							ball.y--;
							
						}
						else if(see==1) { //아래보면서들옴
							ball.see = 0;
							ball.x--;
						}
						else if(see==2) { //왼쪽보면서 들옴
							ball.see=3;
							ball.y++;
						}
						else {//오른쪽보면서들옴
							ball.see = 1;
							ball.x++;
							
						}
					}
					else if(curVal==4) {
						if(see==0) { //위보면서 들옴
							ball.see = 1;
							ball.x++;
						}
						else if(see==1) { //아래보면서들옴
							ball.see = 2;
							ball.y--;
							
						}
						else if(see==2) { //왼쪽보면서 들옴
							ball.see=3;
							ball.y++;
						}
						else {//오른쪽보면서들옴
							ball.see = 0;
							ball.x--;
							
						}
					}
					else if(curVal==5) {
						if(see==0) { //위보면서 들옴
							ball.see = 1;
							ball.x++;
						}
						else if(see==1) { //아래보면서들옴
							ball.see = 0;
							ball.x--;
						}
						else if(see==2) { //왼쪽보면서 들옴
							ball.see=3;
							ball.y++;
						}
						else {//오른쪽보면서들옴
							ball.see = 2;
							ball.y--;
						}
					}
					q.offer(ball);
					continue;
				}
				else if(curVal>5) {
					int[] check1 = warmlist[curVal-6].get(0);
					int[] check2 = warmlist[curVal-6].get(1);
					int cx = check1[0];
					int cy = check1[1];
					if(cx == curx && cy==cury) {
						ball.x=check2[0];
						ball.y=check2[1];
					}
					else {
						ball.x=check1[0];
						ball.y=check1[1];
					}
				}
			}
			
			curx = ball.x;
			cury = ball.y;
			
			int newx = curx+di[see];
			int newy = cury+dj[see];
			if(newx>=1 && newx<=size && newy>=1 && newy<=size) {
				//if(map[newx][newy]==0) {
				ball.x = newx;
				ball.y = newy;
				q.offer(ball);
				//}
				
			}
			else {
				if(see==0) ball.see=1;
				else if(see==1) ball.see=0;
				else if(see==2) ball.see=3;
				else ball.see=2;
				ball.score++;
				q.offer(ball);
			}
		}
	}
	

	private static void printmap() {
		int[][] map = new int[size][size];
		map[ball.x][ball.y]=1;
		for(int[] a:map) System.out.println(Arrays.toString(a));
		System.out.println("-------------------------");
	}
	

}

