package algoProblems;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main_백준_2251_물통 {
	public static HashSet<Integer> set;
	public static int A,B,C;
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		A = Integer.parseInt(s[0]);
		B = Integer.parseInt(s[1]);
		C = Integer.parseInt(s[2]);
		
		set = new HashSet<>();
		v = new boolean[A+1][B+1];
		dfs(0,0,C);
		
		LinkedList<Integer> list = new LinkedList<>(set);
		Collections.sort(list);
		
		for(int i : list) bw.write(i+" ");
		bw.flush();
	}

	private static void dfs(int curA, int curB, int curC) {
		if(v[curA][curB]) return;
		
		v[curA][curB]=true;
		if(curA==0) set.add(curC);
		
		//A를 B로
		if(curA>0) {
			int canput = B-curB;
			if(canput < curA) dfs(curA-canput,curB+canput,curC);
			else dfs(0,curB+curA,curC);
		}
		//B를 A로
		if(curB>0) {
			int canput = A-curA;
			if(canput < curB) dfs(curA+canput, curB-canput, curC);
			else dfs(curA+curB, 0, curC);
		}
		//A를 C로
		if(curA>0) {
			int canput = C-curC;
			if(canput < curA) dfs(curA-canput, curB, curC+canput);
			else dfs(0, curB, curC+curA);
		}
		//C를 A로
		if(curC>0) {
			int canput = A-curA;
			if(canput < curC) dfs(curA+canput, curB, curC-canput);
			else dfs(curA+curC,curB,0);
		}
		//B를 C로
		if(curB>0) {
			int canput = C-curC;
			if(canput < curB) dfs(curA, curB-canput, curC+canput);
			else dfs(curA, 0, curB+curC);
		}
		//C를 B로
		if(curC>0) {
			int canput = B-curB;
			if(canput < curC) dfs(curA, curB+canput, curC-canput);
			else dfs(curA, curB+curC,0);
		}
	}

}
