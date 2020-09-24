package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main_백준_15809_전국시대3 {
	public static int[] a,people;
	public static int N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_전국시대.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		a = new int[N];
		people = new int[N];
		for(int z=0;z<N;z++) {
			a[z]=z;
			people[z] = Integer.parseInt(br.readLine());
		}
		
		for(int z=0;z<M;z++) {
			String[] ss = br.readLine().split(" ");
			int O = Integer.parseInt(ss[0]);
			int P = find(Integer.parseInt(ss[1])-1);
			int Q = find(Integer.parseInt(ss[2])-1);
			if(O==1) {
				union(P,Q);
			}
			else {
				int P_people = people[P];
				int Q_people = people[Q];
				if(P_people > Q_people) {
					int gap = P_people-Q_people;
					union(P,Q);
					people[P]=gap;
				}
				else if(P_people < Q_people) {
					int gap = Q_people-P_people;
					union(P,Q);
					people[Q]=gap;
				}
				else {
					setZero(P);
					setZero(Q);
				}
			}
		}
		LinkedList<Integer> list = new LinkedList<>();
		int cnt = 0;
		for(int z=0;z<N;z++) {
			if(people[z]>0) {
				cnt++;
				list.add(people[z]);
			}
		}
		
		System.out.println(cnt);
		Collections.sort(list);
		for(int c:list) System.out.print(c+" ");
	}
	private static void setZero(int q) {
		for(int z=0;z<N;z++) {
			if(a[z]==q) people[z]=0;
		}
	}
	
	private static void union(int p, int q) {
		if(people[p]>people[q]) {
			people[p]+=people[q];
			people[q]=0;
			a[q]=a[p];
		}
		else {
			people[q]+=people[p];
			people[p]=0;
			a[p]=a[q];
		}
	}
	private static int find(int x) {
		if(a[x]==x) return x;
		else return a[x] = find(a[x]);
	}

}
