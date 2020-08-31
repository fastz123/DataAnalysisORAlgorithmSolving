package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_백준_14496_그대그머가되어 {
	public static LinkedList<Integer> list[];
	public static int v[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0])-1;
		int b = Integer.parseInt(s[1])-1;
		
		s= br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		list = new LinkedList[N];
		for(int z=0;z<N;z++) list[z] = new LinkedList<Integer>();
		
		for(int z=0;z<M;z++) {
			s = br.readLine().split(" ");
			int st = Integer.parseInt(s[0])-1;
			int end = Integer.parseInt(s[1])-1;
			
			list[st].add(end);
			list[end].add(st);
		}
		
		v = new int[N];
		Arrays.fill(v, Integer.MAX_VALUE);
		v[a]=0;
		dfs(a);
//		System.out.println(Arrays.toString(v));
		
		bw.write((v[b]==Integer.MAX_VALUE? -1:v[b])+"\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int i) {
		for(int z=0;z<list[i].size();z++) {
			int cur = list[i].get(z);
			if(v[cur] > v[i]+1) {
				v[cur] = v[i]+1;
				dfs(cur);
			}
		}
	}
}
