package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_9205_맥주마시면서걸어가기 {
	public static int N;
	public static boolean v[];
	public static LinkedList<Integer> list[];
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			N = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int stx = Integer.parseInt(s[0]);
			int sty = Integer.parseInt(s[1]);
			
			int map[][] = new int[N+2][2];
			
			map[0] = new int[] {stx,sty};
			
			for(int z=0;z<N;z++) {
				s = br.readLine().split(" ");
				int curx = Integer.parseInt(s[0]);
				int cury = Integer.parseInt(s[1]);
				
				map[z+1] = new int[] {curx,cury};
			}
			
			s = br.readLine().split(" ");
			map[N+1] = new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])};
			
			list = new LinkedList[N+2];
			for(int i=0;i<N+2;i++) list[i] = new LinkedList<Integer>();
			check(map,list);
			
			v = new boolean[N+2];
			v[0]=true;
//			dfs(0);
			bfs(0);
			
			bw.write(v[N+1]? "happy\n":"sad\n");
			
			T--;
		}
		
		bw.flush();
		bw.close();

	}

	private static void check(int[][] map, LinkedList<Integer>[] list) {
		for(int z=0;z<N+2;z++) {
			int[] A = map[z];
			for(int x=0;x<N+2;x++) {
				int [] B = map[x];
				if(z!=x) {
					int distance = Math.abs(A[0]-B[0]) + Math.abs(A[1]-B[1]);
					if(distance<=1000) {
						list[z].add(x);
					}
				}
			}
		}
	}
	

	private static void dfs(int i) {
		for(int z=0;z<list[i].size();z++) {
			if(!v[list[i].get(z)]) {
				v[list[i].get(z)]=true;
				dfs(list[i].get(z));
			}
		}
	}
	
	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		while(!q.isEmpty()) {
			int num = q.poll();
			
			for(int z=0;z<list[num].size();z++) {
				if(!v[list[num].get(z)]) {
					v[list[num].get(z)]=true;
					q.offer(list[num].get(z));
				}
			}
		}
	}


}
