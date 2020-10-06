package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.FileInputStream;

public class Main_백준_1753_최단경로 {
	public static class Node{
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	public static int v[],N;
	public static boolean visit[];
	public static LinkedList<Node> list[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_최단경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int stnode = Integer.parseInt(br.readLine())-1;
		
		list = new LinkedList[N];
		for(int z=0;z<N;z++) list[z] = new LinkedList<>();

		for(int z=0;z<M;z++) {
			s = br.readLine().split(" ");
			int st = Integer.parseInt(s[0])-1;
			int end = Integer.parseInt(s[1])-1;
			int weight = Integer.parseInt(s[2]);
			
			list[st].add(new Node(end,weight));
		}
		
		v = new int[N];
		visit = new boolean[N];
		Arrays.fill(v, Integer.MAX_VALUE);
		v[stnode]=0;
		dijkstra();

		for(int n : v) System.out.println(n==Integer.MAX_VALUE? "INF":n);
	}
	
	private static void dijkstra() {
		int minidx = -1;
		for(int i=0;i<N;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++) {
				if(!visit[j] && min > v[j]) {
					min = v[j];
					minidx = j;
				}
			}
			
			visit[minidx] = true;
			
			for(Node cur : list[minidx]) {
				int n = cur.to;
				int weight = cur.weight;
				if(v[n] > v[minidx]+weight) v[n] = v[minidx]+weight;
			}
		}
	}

}
