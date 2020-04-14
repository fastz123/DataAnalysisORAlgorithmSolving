package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_백준_17837_새로운게임 {
	public static class mal{
		int num;
		int di;
		int x;
		int y;
		int floor;
		public mal(int num, int di,int x,int y) {
			this.num = num;
			this.di = di;
			this.x = x;
			this.y = y;
			this.floor = 0;
		}
	}
	public static char arr[][];
	public static ArrayList<mal>[][] map;
	public static int N;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_새로운게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		arr = new char[N+2][N+2];
		for(int z=1;z<N+1;z++) {
			s = br.readLine().split(" ");
			for(int x=1;x<N+1;x++) {
				if(s[x-1].charAt(0)=='0') arr[z][x] = 'W';
				else if(s[x-1].charAt(0)=='1') arr[z][x] = 'R';
				else arr[z][x] = 'B';
			}
		}
		
		for(int z=0;z<N+2;z++) {
			arr[0][z] = 'B';
			arr[z][0] = 'B';
			arr[N+1][z] = 'B';
			arr[z][N+1] = 'B';
		}
		
		map = new ArrayList[N+2][N+2];
		for(int z=0;z<N+2;z++) {
			for(int x=0;x<N+2;x++) {
					map[z][x] = new ArrayList<>();
			}
		}
		
		mal[] mallist = new mal[K];
		for(int z=0;z<K;z++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			
			map[x][y].add(new mal(z+1,d,x,y));
			mallist[z] = map[x][y].get(0);
		}
		
		int turn = 0;
case1:	while(true) {
			for(int z=0;z<K;z++) {
				mal cur = mallist[z];
				if(!move(cur)) {
					break case1;
				}
			}
//			printmap();
			turn++;
			if(turn>1000) break;
		}
		System.out.println(turn>1000? -1:turn+1);
	}

	private static void printmap() {
		for(int z=1;z<N+1;z++) {
			 for(int x=1;x<N+1;x++) {
				 System.out.print(map[z][x].size()+" ");
			 }
			 System.out.println();
		}
		System.out.println("----------------------");
	}

	private static boolean move(mal cur) {
		
		int tempx = cur.x;
		int tempy = cur.y;
		
		if(cur.di==1) { //우
			cur.y++;
		}
		else if(cur.di==2) { //좌
			cur.y--;
		}
		else if(cur.di==3) { //상
			cur.x--;
		}
		else { //하
			cur.x++;
		}
		
		char color = arr[cur.x][cur.y];
		if(color!='B') {
			if(color=='W') {
				int flo = cur.floor;
				int af = map[cur.x][cur.y].size();
				for(int f=flo;f<map[tempx][tempy].size();f++) {
					map[tempx][tempy].get(f).x=cur.x;
					map[tempx][tempy].get(f).y=cur.y;
					map[tempx][tempy].get(f).floor=af;
					af++;
					map[cur.x][cur.y].add(map[tempx][tempy].get(f));
				}
				for(int f=map[tempx][tempy].size()-1;f>=flo;f--) map[tempx][tempy].remove(f);
				
			}
			else {
				int flo = cur.floor;
				Queue<mal> q = new LinkedList<>();
				for(int f=map[tempx][tempy].size()-1;f>=flo;f--) {
					q.offer(map[tempx][tempy].get(f));
					map[tempx][tempy].remove(f);
				}
				int af = map[cur.x][cur.y].size();
				while(!q.isEmpty()) {
					mal curmal = q.poll();
					curmal.x=cur.x;
					curmal.y=cur.y;
					curmal.floor=af;
					af++;
					map[cur.x][cur.y].add(curmal);
				}
			}
		}
		else {
			if(cur.di==1) cur.di=2;
			else if(cur.di==2) cur.di=1;
			else if(cur.di==3) cur.di=4;
			else cur.di=3;
			
			cur.x=tempx;
			cur.y=tempy;
			if(cur.di==1) { //우
				cur.y++;
			}
			else if(cur.di==2) { //좌
				cur.y--;
			}
			else if(cur.di==3) { //상
				cur.x--;
			}
			else { //하
				cur.x++;
			}
			color = arr[cur.x][cur.y];
			if('W'==color) {
				int flo = cur.floor;
				int af = map[cur.x][cur.y].size();
				for(int f=flo;f<map[tempx][tempy].size();f++) {
					map[tempx][tempy].get(f).x=cur.x;
					map[tempx][tempy].get(f).y=cur.y;
					map[tempx][tempy].get(f).floor=af;
					af++;
					map[cur.x][cur.y].add(map[tempx][tempy].get(f));
				}
				for(int f=map[tempx][tempy].size()-1;f>=flo;f--) map[tempx][tempy].remove(f);
			}
			else if('B'==color) {
				cur.x=tempx;
				cur.y=tempy;
			}
			else {
				int flo = cur.floor;
				Queue<mal> q = new LinkedList<>();
				for(int f=map[tempx][tempy].size()-1;f>=flo;f--) {
					q.offer(map[tempx][tempy].get(f));
					map[tempx][tempy].remove(f);
				}
				int af = map[cur.x][cur.y].size();
				while(!q.isEmpty()) {
					mal curmal = q.poll();
					curmal.x=cur.x;
					curmal.y=cur.y;
					curmal.floor=af;
					af++;
					map[cur.x][cur.y].add(curmal);
				}
			}
			
			
		}
		if(map[tempx][tempy].size()>=4) return false;
		else if(map[cur.x][cur.y].size()>=4) return false;
		else return true;
	}
	
}
