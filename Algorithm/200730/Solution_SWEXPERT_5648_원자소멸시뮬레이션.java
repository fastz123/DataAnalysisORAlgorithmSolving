package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class Solution_SWEXPERT_5648_원자소멸시뮬레이션2 {
	public static class Cell{
		int x;
		int y;
		int see;
		int energy;
		
		public Cell(int x, int y, int see, int energy) {
			this.x = x;
			this.y = y;
			this.see = see;
			this.energy = energy;
		}
	}
	public static int N;
	public static boolean v[][];
	public static ArrayList<Cell> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_원소시.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			
			HashMap<Integer, Cell> hmap = new HashMap<>();
			list = new ArrayList<>();
			v = new boolean[4001][4001];
			for(int z=0;z<N;z++) {
				String[] s = br.readLine().split(" ");
				int x = (Integer.parseInt(s[0])+1000) * 2;
				int y = (Integer.parseInt(s[1])+1000) * 2;
				int see = Integer.parseInt(s[2]);
				int energy = Integer.parseInt(s[3]);
				
				v[x][y] = true;
				Cell cur = new Cell(x,y,see,energy);
				list.add(cur);
			}
			
			int score = 0;
			while(true) {
				if(list.size()<=1) break;
				Queue<Cell> q = move();
				
				score += crash(q);
				
				
			}
			System.out.println("#"+i+" "+score);
		}
		
		
		

	}
	
	private static int crash(Queue<Cell> q) {
		int sum=0;
		while(!q.isEmpty()) {
			Cell cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			for(int z=list.size()-1;z>=0;z--) {
				Cell c = list.get(z);
				if(c.x==cx && c.y==cy) {
					sum+=c.energy;
					list.remove(z);
					if(list.size()==0) return sum;
				}
			}
		}
		return sum;
	}

	private static int checklen(HashMap<Integer, Cell> hmap) {
		int max = 0;
		for(Entry<Integer, Cell> set1 : hmap.entrySet()) {
			for(Entry<Integer, Cell> set2 : hmap.entrySet()) {
				if(set1!=set2) {
					int cur = Math.abs(set1.getValue().x - set2.getValue().x)+Math.abs(set1.getValue().y-set2.getValue().y);
					max = Math.max(max, cur);
				}
			}
		}
		return max;
	}

	private static HashSet<Integer> check2(HashMap<Integer, Cell> hmap) {
		HashSet<Integer> outCells = new HashSet<Integer>();
		for(Entry<Integer, Cell> set : hmap.entrySet()) {
			Cell cur = set.getValue();
			if(cur.x <0 || cur.y<0 || cur.y>4000 || cur.x>4000) {
				outCells.add(set.getKey());
			}
		}
		return outCells;
	}

	private static HashSet<Integer> check(HashMap<Integer, Cell> hmap) {
		HashSet<Integer> res = new HashSet<>();
		for(Entry<Integer, Cell> set1 : hmap.entrySet()) {
			for(Entry<Integer, Cell> set2 : hmap.entrySet()) {
				if(set1.getKey() != set2.getKey()) {
					if((set1.getValue().x == set2.getValue().x) &&( set1.getValue().y == set2.getValue().y)) {
						res.add(set1.getKey());
						res.add(set2.getKey());
					}
				}
			}
		}
		
		return res;
	}

	public static int di[]= {0,0,-1,1}, dj[]= {1,-1,0,0};
	private static Queue<Cell> move() {
//		HashSet<Integer> hset = new HashSet();
		Queue<Cell> q = new LinkedList<>();
		for(int z = list.size()-1;z>=0;z--) {
			Cell cur = list.get(z);
			v[cur.x][cur.y]=false;
			int newx = cur.x+di[cur.see];
			int newy = cur.y+dj[cur.see];
			cur.x = newx;
			cur.y = newy;
			if(newx>=0 && newx<=4000 && newy>=0 && newy<=4000) {
				if(v[newx][newy]) {
					v[cur.x][cur.y]=false;
					q.offer(cur);
				}
				else {
					v[newx][newy]=true;
				}
			}
			else {
				list.remove(cur);
				if(list.size()==0) return q;
			}

		}
		
		return q;

	}

}
