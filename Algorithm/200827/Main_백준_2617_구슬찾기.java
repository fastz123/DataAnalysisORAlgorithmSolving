package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_백준_2617_구슬찾기 {
	public static boolean bv[],v[];
	public static LinkedList<Integer>[] list;
	public static int size;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		size = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		list = new LinkedList[size];
		for(int z=0;z<size;z++) list[z] = new LinkedList<Integer>();
		
		for(int z=0;z<M;z++) {
			s = br.readLine().split(" ");
			int end = Integer.parseInt(s[0])-1;
			int st = Integer.parseInt(s[1])-1;
		
			list[st].add(end);
//			list[end].add(st);
		}
		
		int res[] = new int[size];
		int bres[] = new int[size];
		for(int z=0;z<size;z++) {
			v = new boolean[size];
			v[z] = true;
			bv = new boolean[size];
			bv[z] = true;
			cnt=0;
			dfs(z);
			bcnt=0;
			bdfs(z);
			res[z] = cnt;
			bres[z] = bcnt;
		}

		
		int ar = 0;
		int bar = 0;
		for(int z=0;z<size;z++) {
			if(res[z] >= (size/2)+1) ar++;
			else if(bres[z] >= (size/2)+1) bar++;
		}
		
		System.out.println(ar+bar);
	}
	private static void bdfs(int i) {
		for(int z=0;z<list.length;z++) {
			if(list[z].contains(i)) {
				if(!bv[z]) {
					bv[z]=true;
					bcnt++;
					bdfs(z);
				}
			}
		}
	}
	
	public static int bcnt,cnt;
	private static void dfs(int i) {
		for(int z=0;z<list[i].size();z++) {
			int cur = list[i].get(z);
			if(!v[cur]) {
				v[cur]=true;
				cnt++;
				dfs(cur);
			}
		}
	}

}
