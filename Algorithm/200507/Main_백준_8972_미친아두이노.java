package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main_백준_8972_미친아두이노 {
	public static class Robot{
		int x;
		int y;
		public Robot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static char[][] map;
	public static int N,M,di[]= {1,1,1,0,0,0,-1,-1,-1}, dj[]= {-1,0,1,-1,0,1,-1,0,1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_미친아두이노.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new char[N][M];
		Robot mine = null;
		ArrayList<Robot> list = new ArrayList<>();
		for(int z=0;z<N;z++) {
			String ss= br.readLine();
			for(int x=0;x<M;x++) {
				map[z][x] = ss.charAt(x);
				if(map[z][x] == 'I') mine = new Robot(z,x);
				else if(map[z][x] == 'R') list.add(new Robot(z, x));
			}
		}
		
		String move = br.readLine();
		int[] mov = new int[move.length()];
		for(int z=0;z<move.length();z++) mov[z] = move.charAt(z)-'0';
		
		int idx = 0;
		while(true) {
			if(idx == mov.length) break;
			move(mine,idx,mov);
			if(check2(mine,list)) {
				System.out.println("kraj "+(idx+1));
				return;
			}
			move2(list,mine);
			if(check2(mine,list)) {
				System.out.println("kraj "+(idx+1));
				return;
			}
			
			check(mine,list);
			idx++;
		}
		
		printmap(mine,list);
		
	}
	
	private static void printmap(Robot mine, ArrayList<Robot> list) {
		char[][] map = new char[N][M];
		for(char[] c : map) Arrays.fill(c, '.');
		int mx = mine.x;
		int my = mine.y;
		map[mx][my] = 'I';
		for(Robot r: list) {
			map[r.x][r.y]='R';
		}
		
		for(char[] c: map) {
			for(char cc : c) {
				System.out.print(cc);
			}
			System.out.println();
		}
	}

	private static boolean check2(Robot mine, ArrayList<Robot> list) {
		int curx = mine.x;
		int cury = mine.y;
		
		for(Robot r : list) {
			if(curx == r.x && cury == r.y) return true;
		}
		
		return false;
	}

	private static void check(Robot mine, ArrayList<Robot> list) {
		ArrayList<Robot>[][] rmap = new ArrayList[N][M];
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				rmap[z][x] = new ArrayList<>();
			}
		}
		
		for(Robot r : list) {
			int curx = r.x;
			int cury = r.y;
			rmap[curx][cury].add(r);
		}
		
		HashSet<Integer> dellist = new HashSet<>();
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(rmap[z][x].size()>=2) {
					dellist.add(z*M+x);
				}
			}
		}
		
		for(int z=list.size()-1;z>=0;z--) {
			Robot r = list.get(z);
			if(dellist.contains(r.x*M+r.y)) {
				list.remove(z);
			}
		}
		
	}
	private static void move2(ArrayList<Robot> list,Robot mine) {
		for(Robot curR : list) {
			int Rcurx = curR.x;
			int Rcury = curR.y;
			int i = -1;
			int min = Integer.MAX_VALUE;
			for(int z=0;z<9;z++) {
				int Rnewx = Rcurx+di[z];
				int Rnewy = Rcury+dj[z];
				if(Rnewx>=0 && Rnewx<N && Rnewy>=0 && Rnewy<M) {
					int dis = Math.abs((mine.x-Rnewx))+Math.abs((mine.y-Rnewy));
					if(dis<min) {
						min = dis;
						i = z;
					}
				}
			}
			if(i!=-1) {
				int newx = Rcurx+di[i];
				int newy = Rcury+dj[i];
				curR.x = newx;
				curR.y = newy;
			}
		}
	}
	private static void move(Robot mine,int idx,int[] mov) {
		int curx = mine.x;
		int cury = mine.y;
		
		int newx = curx + di[mov[idx]-1];
		int newy = cury + dj[mov[idx]-1];
		if(newx>=0 && newx<N && newy>=0 && newy<M) {
			mine.x = newx;
			mine.y = newy;
		}
	}

}
