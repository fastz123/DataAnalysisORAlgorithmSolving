package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_백준_17143_낚시왕 {

	public static class Shark{
		int x;
		int y;
		int speed;
		int di;
		int size;
		public Shark(int x, int y, int speed, int di, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.di = di;
			this.size = size;
		}
		
	}
	public static ArrayList<Shark>[][] map;
	public static int N,M,c,sum;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_낚시왕.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		c = Integer.parseInt(s[2]);
		NN = N*2-2;
		MM = M*2-2;
		map = new ArrayList[N][M];
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				map[z][x] = new ArrayList<>();
			}
		}
		
		for(int z=0;z<c;z++) {
			s = br.readLine().split(" ");
			Shark shark = new Shark(Integer.parseInt(s[0])-1, Integer.parseInt(s[1])-1, Integer.parseInt(s[2]), Integer.parseInt(s[3])-1, Integer.parseInt(s[4]));
			int x = shark.x;
			int y = shark.y;
			map[x][y].add(shark);
		}
		int cury=-1;
		while(true) {
			cury++;
			if(cury==M) break;
			check(cury);
			move();
		}
		
		System.out.println(sum);
	}
	public static int di[]= {-1,1,0,0},dj[]= {0,0,1,-1},NN,MM;
	private static void move() {
		ArrayList<Shark> list = new ArrayList<>();
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(map[z][x].size()>0) {
					list.add(map[z][x].get(0));
					map[z][x].remove(0);
				}
			}
		}
		for(Shark curshark : list) {
			int see = curshark.di;
			int speed = curshark.speed;
			int newx = curshark.x;
			int newy = curshark.y;
			if(see==0 || see==1) {//상하
				int Q = speed%NN;
				for(int k=0;k<Q;k++) {
					int curx = newx + di[see];
					int cury = newy + dj[see];
					if(curx>=0 && curx<N && cury>=0 && cury<M) {
						newx = curx;
						newy = cury;
					}
					else {
						if(see==0) see=1;
						else see=0;
						for(int o=0;o<2;o++) {
							curx += di[see];
							cury += dj[see];
						}
						newx = curx;
						newy = cury;
					}
				}
			}
			else { //좌우
				int Q = speed%MM;
				for(int k=0;k<Q;k++) {
					int curx = newx + di[see];
					int cury = newy + dj[see];
					if(curx>=0 && curx<N && cury>=0 && cury<M) {
						newx = curx;
						newy = cury;
					}
					else {
						if(see==2) see=3;
						else see=2;
						for(int o=0;o<2;o++) {
							curx += di[see];
							cury += dj[see];
						}
						newx = curx;
						newy = cury;
					}
				}
			}
			
			curshark.x=newx;
			curshark.y=newy;
			curshark.di=see;
			if(map[newx][newy].size()==0) map[newx][newy].add(curshark);
			else {
				int cursize = map[newx][newy].get(0).size;
				if(curshark.size>cursize) {
					map[newx][newy].remove(0);
					map[newx][newy].add(curshark);
				}
			}
		}
		
//		for(int z=0;z<N;z++) {
//			for(int x=0;x<M;x++) {
//				if(map[z][x].size()>1) {
//					
//					Collections.sort(map[z][x],new Comparator<Shark>() {
//
//						@Override
//						public int compare(Shark o1, Shark o2) {
//							return -1*Integer.compare(o1.size, o2.size);
//						}
//					});
//					while(map[z][x].size()!=1) map[z][x].remove(1);
//				}
//			}
//		}
	}
	private static void check(int cury) {
		for(int z=0;z<N;z++) {
			if(map[z][cury].size()>0) {
				Shark curshark = map[z][cury].get(0);
				sum += curshark.size;
				map[z][cury].remove(0);
				break;
			}
		}
	}

}
