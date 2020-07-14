package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_1938_통나무옮기기 {
	public static class cell{
		int x;
		int y;
		public cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public cell() {}
	}
	public static class Tree{
		cell c1;
		cell c2;
		cell c3;
		int cnt;
		public Tree() {
		}
		public boolean check() {
			if(this.c1.x-this.c2.x==0) {
				return true; //가로
			}
			else return false; //세로
		}
	}
	public static boolean ec,vv[][];
	public static int v[][][],size;
	public static char map[][];
	public static Tree tree,endtree;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_통나무옮기기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		
		map = new char[size][size];
		
		cell[] carr = new cell[3];
		cell[] endarr = new cell[3];
		int idx = 0;
		int eidx = 0;
		for(int z=0;z<size;z++) {
			String s = br.readLine();
			for(int x=0;x<size;x++) {
				map[z][x] = s.charAt(x);
				if(map[z][x]=='B') {
					cell c = new cell(z,x);
					carr[idx]=c;
					idx++;
				}
				else if(map[z][x]=='E') {
					cell c = new cell(z,x);
					endarr[eidx] = c;
					eidx++;
				}
			}
		}
		tree = new Tree();
		tree.c1 = carr[0];
		tree.c2 = carr[1];
		tree.c3 = carr[2];
		tree.cnt = 0;
		
		endtree = new Tree();
		endtree.c1 = endarr[0];
		endtree.c2 = endarr[1];
		endtree.c3 = endarr[2];
		ec = tree.check();
		vv = new boolean[size][size];
		v = new int[2][size][size];
		for(int[][] a : v) {
			for(int[] aa:a) Arrays.fill(aa, Integer.MAX_VALUE);
		}
		if(ec) v[0][tree.c2.x][tree.c2.y]=0;
		else v[1][tree.c2.x][tree.c2.y]=0;
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min==Integer.MAX_VALUE? 0:min);
	}
	public static int min;
	public static int di[]= {0,-1,0,1,-1,-1,1,1},dj[]= {-1,0,1,0,-1,1,1,-1};
	public static Queue<Tree> q = new LinkedList<>();
	private static void bfs() {
		q.offer(tree);
		while(!q.isEmpty()) {
			Tree cur = q.poll();
			boolean f = cur.check();
			int d = (f? 0:1);
//				System.out.println("9");
			if(finishcheck(cur)) {
				min = Math.min(min, v[d][cur.c2.x][cur.c2.y]);
			}
			for(int z=0;z<4;z++) {
				int newx1 = cur.c1.x+di[z];
				int newy1 = cur.c1.y+dj[z];
				int newx2 = cur.c2.x+di[z];
				int newy2 = cur.c2.y+dj[z];
				int newx3 = cur.c3.x+di[z];
				int newy3 = cur.c3.y+dj[z];
				int temp = cur.cnt;
				if(newx1>=0 && newx2>=0 && newx3>=0 && newy1>=0 && newy2>=0 && newy3>=0 
						&& newx1<size && newx2<size && newx3<size && newy1<size && newy2<size && newy3<size 
						&& (map[newx1][newy1]!='1' && map[newx2][newy2]!='1' && map[newx3][newy3]!='1') && v[d][newx2][newy2] > temp+1) {
					Tree curtree = new Tree();
					curtree.c1=new cell();
					curtree.c2=new cell();
					curtree.c3=new cell();
					curtree.c1.x = newx1;
					curtree.c1.y = newy1;
					curtree.c2.x = newx2;
					curtree.c2.y = newy2;
					curtree.c3.x = newx3;
					curtree.c3.y = newy3;
					curtree.cnt=temp+1;
					if(f) v[0][newx2][newy2]=curtree.cnt;
					else v[1][newx2][newy2]=curtree.cnt;
					q.offer(curtree);
				}
			}
			if(check(cur.c2.x,cur.c2.y)) {
				boolean isgaro = cur.check();
				if(isgaro) {
					int newx1 = cur.c2.x-1;
					int newy1 = cur.c2.y;
					int newx2 = cur.c2.x;
					int newy2 = cur.c2.y;
					int newx3 = cur.c2.x+1;
					int newy3 = cur.c2.y;
					int temp = cur.cnt;
					if(vv[newx2][newy2]==false) {
						vv[newx2][newy2]=true;
						Tree curtree = new Tree();
						curtree.c1=new cell();
						curtree.c2=new cell();
						curtree.c3=new cell();
						curtree.c1.x = newx1;
						curtree.c1.y = newy1;
						curtree.c2.x = newx2;
						curtree.c2.y = newy2;
						curtree.c3.x = newx3;
						curtree.c3.y = newy3;
						curtree.cnt=temp+1;
						v[1][cur.c2.x][cur.c2.y]=curtree.cnt;
						q.offer(curtree);
					}
				}
				else {
					int newx1 = cur.c2.x;
					int newy1 = cur.c2.y-1;
					int newx2 = cur.c2.x;
					int newy2 = cur.c2.y;
					int newx3 = cur.c2.x;
					int newy3 = cur.c2.y+1;
					int temp = cur.cnt;
					if(!vv[newx2][newy2] ) {
						vv[newx2][newy2]=true;
						Tree curtree = new Tree();
						curtree.c1=new cell();
						curtree.c2=new cell();
						curtree.c3=new cell();
						curtree.c1.x = newx1;
						curtree.c1.y = newy1;
						curtree.c2.x = newx2;
						curtree.c2.y = newy2;
						curtree.c3.x = newx3;
						curtree.c3.y = newy3;
						curtree.cnt=temp+1;
						v[0][cur.c2.x][cur.c2.y]=curtree.cnt;
						q.offer(curtree);
					}
				}
			}
		}
	}
	private static boolean finishcheck(Tree tree) {
		if(map[tree.c1.x][tree.c1.y]=='E' && map[tree.c2.x][tree.c2.y]=='E' &&map[tree.c3.x][tree.c3.y]=='E') return true;
		else return false;
	}
	private static boolean check(int x, int y) {
		for(int z=0;z<8;z++) {
			int newx = x+di[z];
			int newy = y+dj[z];
			if(newx>=0 && newy>=0 && newx<size && newy<size && map[newx][newy]!='1') {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}

}
