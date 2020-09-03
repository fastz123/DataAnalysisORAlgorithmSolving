package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_1325_효율적인해킹 {
	public static LinkedList<Integer> list[];
	public static boolean v[];
	public static int cnt,res[],max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		list = new LinkedList[N];
		for(int z=0;z<N;z++) list[z] = new LinkedList<Integer>();
		
		for(int z=0;z<M;z++) {
			s = br.readLine().split(" ");
			int st = Integer.parseInt(s[0])-1;
			int end = Integer.parseInt(s[1])-1;
			
			list[end].add(st);
//			list[end].add(st);
		}
		
		res = new int[N];
		max = Integer.MIN_VALUE;
		for(int z=0;z<N;z++) {
			v = new boolean[N];
			v[z] = true;
			dfs(z,z);
//			bfs(z,z);
			max = Math.max(max, cnt);
		}
//		System.out.println(Arrays.toString(res));
		for(int z=0;z<N;z++) {
			if(res[z]==max) bw.write((1+z)+" ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int i,int st) {
		for(int cur : list[i]) {
			if(!v[cur]) {
				v[cur]=true;
				res[st]++;
				max = Math.max(max, res[st]);
				dfs(cur,st);
			}
		}
	}
	private static void bfs(int i , int st) {
		Queue<Integer> q = new LinkedList();
		q.offer(i);
		while(!q.isEmpty()) {
			int cur = q.poll();

			for(int z=0;z<list[cur].size();z++) {
				int c = list[cur].get(z);
				if(!v[c]) {
					v[c]=true;
					res[st]++;
					max = Math.max(max, res[st]);
					q.offer(c);
				}
			}
		}
	}
}
