package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_18809_Gaaaaaaaaaarden {
	public static class cell{
		int x;
		int y;
		public cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static int M,N,R,G,map[][],v[][];
	public static boolean vR[][],vG[][];
	public static ArrayList<cell> Rlist,Glist;
	public static ArrayList<Integer> crlist,cglist;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_Gaaaaaaaaaarden.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = Integer.parseInt(br.readLine());
//		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]);
			N = Integer.parseInt(s[1]);
			G = Integer.parseInt(s[2]);
			R = Integer.parseInt(s[3]);
			
			map = new int[M][N];
			ArrayList<cell> list = new ArrayList<>();
			for(int z=0;z<M;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<N;x++) {
					map[z][x] = Integer.parseInt(s[x]);
					if(map[z][x]==2) list.add(new cell(z,x));
				}
			}
			
			Rlist = new ArrayList<>();
			Glist = new ArrayList<>();
			max = Integer.MIN_VALUE;
			dfs(list,0);
			System.out.println(max);
//		}
	}
	public static int max;
	private static void dfs(ArrayList<cell> list, int idx) {
		if(R==Rlist.size() && G==Glist.size()) {
//			if(Rlist.get(0).x==2 && Rlist.get(0).y==0 && Rlist.get(1).x==4 && Rlist.get(1).y==1 
//					&& Glist.get(0).x==0 && Glist.get(0).y==3 && Glist.get(1).x==0 && Glist.get(1).y==5
//					&& Glist.get(2).x==1 && Glist.get(2).y==6) {
				
			
//			System.out.print("red");
//			for(cell c : Rlist) System.out.print("["+c.x+" "+c.y+"]");
//			System.out.println();
//			System.out.print("green");
//			for(cell c : Glist) System.out.print("["+c.x+" "+c.y+"]");
//			System.out.println();
//			System.out.println("---------------------------------");
			int fcnt=0;
			vR = new boolean[M][N];
			vG = new boolean[M][N];
			v = new int[M][N];
			for(cell c : Rlist) v[c.x][c.y]=5;
			for(cell c : Glist) v[c.x][c.y]=7;
			crlist = new ArrayList<>();
			cglist = new ArrayList<>();
			for(cell c:Rlist) crlist.add(c.x*N+c.y);
			for(cell c:Glist) cglist.add(c.x*N+c.y);
			while(true) {
				int hR = hwacksan(crlist,'R');
				int hG = hwacksan(cglist,'G');
//				System.out.println(hR+" "+hG);
				
				if(0==hR+hG) break;
				else {
					for(int c:crlist) v[c/N][c%N]=5;
					for(int c:cglist) v[c/N][c%N]=7;
					fcnt+=check();
//					printv(v);
//					System.out.println("---------------------");
				}
			}
//			System.out.println(fcnt);
//			System.out.println("--------------------");
			max = Math.max(fcnt, max);
			return;
		}
//		}
		if(idx>=list.size()) return;
		else {
			//R포함
			Rlist.add(list.get(idx));
			dfs(list,idx+1);
			Rlist.remove(Rlist.size()-1);
			
			//G포함
			Glist.add(list.get(idx));
			dfs(list,idx+1);
			Glist.remove(Glist.size()-1);
			
			//포함x
			dfs(list,idx+1);
		}
	}
	private static int check() {
		int c=0;
		for(int rc: crlist) {
			for(int gc:cglist) {
				if(rc==gc) {
					v[rc/N][rc%N]=3;
					c++;
				}
			}
		}
		return c;
	}
	private static void printv(int[][] v) {
		for(int[] a:v) {
			System.out.println(Arrays.toString(a));
		}
	}
	public static int[] di = {0,-1,0,1}, dj= {-1,0,1,0};
	private static int hwacksan(ArrayList<Integer> list, char c) {
		if(c=='R') crlist = new ArrayList<>();
		else cglist = new ArrayList<>();
		int cnt = 0;
		for(int z=0;z<list.size();z++) {
			int cur = list.get(z);
			int curx = cur/N;
			int cury = cur%N;
			if(v[curx][cury]==3) continue;
			for(int k=0;k<4;k++) {
				int newx = curx+di[k];
				int newy = cury+dj[k];
				if(newx>=0 && newx<M && newy>=0 && newy<N && map[newx][newy]!=0 && v[newx][newy]!=3 && v[newx][newy]!=5 && v[newx][newy]!=7) {
					if(c=='R') {
						if(!crlist.contains(newx*N+newy)) crlist.add(newx*N+newy);
					}
					else {
						if(!cglist.contains(newx*N+newy)) cglist.add(newx*N+newy);
					}
					cnt++;
				}
			}
		}
		return cnt;
	}

}
