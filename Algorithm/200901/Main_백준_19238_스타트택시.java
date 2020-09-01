package algoProblems;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;

public class Main_백준_19238_스타트택시 {
	public static class Customer{
		int stx;
		int sty;
		int endx;
		int endy;
		int distance;
		int des;
		public Customer(int stx,int sty,int endx, int endy) {
			this.stx=stx;
			this.sty=sty;
			this.endx=endx;
			this.endy=endy;
			this.distance=Integer.MAX_VALUE;
			this.des = Integer.MAX_VALUE;
		}
	}
	public static int v[][],size,map[][],vv[][];
	public static LinkedList<Customer> pq;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_스타트택시.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		size = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		int fuel = Integer.parseInt(s[2]);
		
		map = new int[size][size];
		for(int z=0;z<size;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<size;x++) {
				map[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		pq = new LinkedList<Customer>();
		
		s = br.readLine().split(" ");
		int sx = Integer.parseInt(s[0])-1;
		int sy = Integer.parseInt(s[1])-1;
		
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			int stx = Integer.parseInt(s[0])-1;
			int sty = Integer.parseInt(s[1])-1;
			int endx = Integer.parseInt(s[2])-1;
			int endy = Integer.parseInt(s[3])-1;
			pq.offer(new Customer(stx,sty,endx,endy));
		}
		
		boolean f = false;
		while(!pq.isEmpty()) {
			v = new int[size][size];
			for(int[] ar:v) Arrays.fill(ar, Integer.MAX_VALUE);
			v[sx][sy]=0;
			bfs(sx,sy);
			
			Collections.sort(pq, new Comparator<Customer>() {
				@Override
				public int compare(Customer o1, Customer o2) {
					if(o1.distance!=o2.distance) return Integer.compare(o1.distance, o2.distance);
					else {
						if(o1.stx!=o2.stx) return Integer.compare(o1.stx, o2.stx);
						else return Integer.compare(o1.sty, o2.sty);
					}
				}
			});
			
			Customer cus = pq.poll();
			fuel -= cus.distance;
			if(fuel<=0 || cus.distance==Integer.MAX_VALUE) {
				f=true;
				break;
			}
			vv = new int[size][size];
			for(int[] ar:vv) Arrays.fill(ar, Integer.MAX_VALUE);
			gohome(cus);
			int BF = cus.des;
			if(BF==Integer.MAX_VALUE) {
				f=true;
				break;
			}
			if(BF<=fuel) {
				sx = cus.endx;
				sy = cus.endy;
				fuel+=BF;
			}
			else {
				f=true;
				break;
			}
		}
		
//		System.out.println(f? -1:fuel);
		bw.write((f? -1:fuel) +"\n");
		bw.flush();
		bw.close();

	}
	private static void gohome(Customer cus) {
		Queue<int[]> q = new LinkedList();
		q.offer(new int[] {cus.stx, cus.sty,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0]==cus.endx && cur[1]==cus.endy) {
				cus.des = cur[2];
				return;
			}
			
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<size && newy>=0 && newy<size && map[newx][newy]==0 && vv[newx][newy] > cur[2]+1) {
					vv[newx][newy]=cur[2]+1;
					q.offer(new int[] {newx,newy,cur[2]+1});
				}
			}
		}
	}
	public static int di[]= {0,-1,0,1}, dj[]= {-1,0,1,0},cnt;
	private static void bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {sx,sy,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(Customer c : pq) {
				if(cur[0]==c.stx && cur[1]==c.sty) {
					c.distance = cur[2];
					cnt++;
				}
			}
			
			if(cnt == pq.size()) return;
			
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<size && newy>=0 && newy<size && map[newx][newy]!=1 && v[newx][newy] > cur[2]+1) {
					v[newx][newy] = cur[2]+1;
					q.offer(new int[] {newx,newy,cur[2]+1});
				}
			}
		}
	}

}
