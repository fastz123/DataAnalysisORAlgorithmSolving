package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class Main_백준_11265_끝나지않는파티 {
	public static class Node{
		int i;
		int len;
		public Node(int i, int len) {
			this.i = i;
			this.len = len;
		}
	}
	public static int v[],map[][],N;
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s= br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		map = new int[N][N];
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<N;x++) {
				map[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		int[][] res = new int[N][];
		
		
		for(int z=0;z<N;z++) {
			v = new int[N];
			Arrays.fill(v, Integer.MAX_VALUE);
			v[z]=0;
			bfs(z,0);
//			System.out.println(Arrays.toString(v));
			res[z] = v;
		}
		
//		System.out.println(Arrays.deepToString(res));
		
		for(int z=0;z<M;z++) {
			s = br.readLine().split(" ");
			int st = Integer.parseInt(s[0])-1;
			int end = Integer.parseInt(s[1])-1;
			int time = Integer.parseInt(s[2]);
			
			if(res[st][end] <= time) bw.write("Enjoy other party\n");
			else bw.write("Stay here\n");
		}
		
		bw.flush();
		bw.close();

	}
	private static void bfs(int i, int len) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(i,len));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int z=0;z<N;z++) {
				if(map[cur.i][z]!=0 && v[z] > cur.len+map[cur.i][z]) {
					v[z] = cur.len+map[cur.i][z];
					q.offer(new Node(z,v[z]));
				}
			}
			
		}
	}

}
