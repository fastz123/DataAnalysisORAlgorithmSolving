package algoProblems;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_18352_특정거리의도시찾기 {
	public static int v[],N,K;
	public static ArrayList<Integer> list[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		int X = Integer.parseInt(s[3])-1;
		
		list = new ArrayList[N];
		for(int z=0;z<N;z++) list[z] = new ArrayList<Integer>();
		
		for(int z=0;z<M;z++) {
			s = br.readLine().split(" ");
			int st = Integer.parseInt(s[0])-1;
			int end = Integer.parseInt(s[1])-1;
			
			list[st].add(end);
		}
		
		v = new int[N];
		Arrays.fill(v, Integer.MAX_VALUE);
		v[X] = 0;
		dfs(X,0);

		int idx = 0;
		boolean f = false;
		for(int cur : v) {
			if(cur==K) {
				if(!f) f=true;
//				System.out.println(idx+1);
				bw.write((idx+1)+"\n");
			}
			idx++;
		}
		
		if(!f) bw.write("-1\n");//System.out.println(-1);
		
		bw.flush();
		bw.close();
	}
	private static void dfs(int x, int curlen) {
		if(curlen > K) return;
		for(int z=0;z<list[x].size();z++) {
			int cur = list[x].get(z);
			if(v[cur] > curlen+1) {
				v[cur] = curlen+1;
				dfs(cur,curlen+1);
			}
		}
	}

}
