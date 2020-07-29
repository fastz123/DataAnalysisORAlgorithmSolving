package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_SWEXPERT_5644_무선충전 {

	public static class P{
		int x;
		int y;
		int amount;
		ArrayList<Integer> list;
		public P(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
			this.list=new ArrayList<>();
		}
		public P() {}
	}
	public static class T {
		int num;
		int x;
		int y;
		int cover;
		int charge;
		public T(int num,int x, int y, int cover, int charge) {
			this.num=num;
			this.x=x;
			this.y=y;
			this.cover = cover;
			this.charge = charge;
		}
	}
	public static P p1,p2;
	public static ArrayList<T> Tlist, map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_무선충전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			
			map = new ArrayList[10][10];
			for(int z=0;z<10;z++) {
				for(int x=0;x<10;x++) {
					map[z][x] = new ArrayList<>();
				}
			}
			
			p1 = new P(0,0,0);
			p2 = new P(9,9,0);
			
			String[] s = br.readLine().split(" ");
			int t = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[1]);
			int[][] arr = new int[2][t];
			for(int z=0;z<2;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<t;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			
			Tlist = new ArrayList<>();
			for(int z=0;z<N;z++) {
				s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0])-1;
				int y = Integer.parseInt(s[1])-1;
				int cover = Integer.parseInt(s[2]);
				int charge = Integer.parseInt(s[3]);
				
				T tower = new T(z+1,y,x,cover,charge);
				Tlist.add(tower);
				for(int p=y-cover;p<=y+cover;p++) {
					for(int q=x-cover;q<=x+cover;q++) {
						if(p>=0 && p<10 && q>=0 && q<10 && (Math.abs(p-y)+Math.abs(q-x) <= cover)) {
							map[p][q].add(tower);
						}
					}
				}
			}
			
//			for(ArrayList[] a:map) {
//				for(ArrayList c:a) {
//					System.out.print(c.size()+" ");
//				}
//				System.out.println();
//			}
			int res = 0;
			res+=check();
			for(int z=0;z<t;z++) {
				move(arr[0][z],true);
				move(arr[1][z],false);
				int cur = check();
				res+=cur;
			}
			
			System.out.println("#"+i+" "+res);
		}

	}

	private static int check() {
		p1.list = new ArrayList<>();
		p2.list = new ArrayList<>();
		
		for(int z=0;z<map[p1.x][p1.y].size();z++) {
			p1.list.add(map[p1.x][p1.y].get(z).num);
		}
		
		for(int z=0;z<map[p2.x][p2.y].size();z++) {
			p2.list.add(map[p2.x][p2.y].get(z).num);
		}
		
		
		int max = 0;
		if(p1.list.size()>p2.list.size()) {
			for(int z=0;z<p1.list.size();z++) {
				int n1 = p1.list.get(z);
				if(p2.list.size()>=1) {
					for(int x=0;x<p2.list.size();x++) {
						int n2 = p2.list.get(x);
						
						if(n1!=n2) {
							int c1 = Tlist.get(n1-1).charge;
							int c2 = Tlist.get(n2-1).charge;
							max = Math.max(max, c1+c2);
						}
						else {
							int c = Tlist.get(n1-1).charge;
							max = Math.max(max, c);
						}
					}
				}
				else {
					int c1 = Tlist.get(n1-1).charge;
					max = Math.max(max, c1);
				}
			}
		}else {
			for(int z=0;z<p2.list.size();z++) {
				int n1 = p2.list.get(z);
				if(p1.list.size()>=1) {
					for(int x=0;x<p1.list.size();x++) {
						int n2 = p1.list.get(x);
						
						if(n1!=n2) {
							int c1 = Tlist.get(n1-1).charge;
							int c2 = Tlist.get(n2-1).charge;
							max = Math.max(max, c1+c2);
						}
						else {
							int c = Tlist.get(n1-1).charge;
							max = Math.max(max, c);
						}
					}
				}
				else {
					int c2 = Tlist.get(n1-1).charge;
					max = Math.max(max, c2);
				}
			}
		}
		
		return max;
	}

	private static void move(int see, boolean f) {
		if(f) {
			if(see == 1) {//상
				p1.x--;
			}else if(see==2) {//우
				p1.y++;
			}else if(see==3) {//하
				p1.x++;
			}else if(see==4) {//좌
				p1.y--;
			}
		}
		else {
			if(see == 1) {//상
				p2.x--;
			}else if(see==2) {//우
				p2.y++;
			}else if(see==3) {//하
				p2.x++;
			}else if(see==4) {//좌
				p2.y--;
			}
		}
	}

}
