package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main_백준_15809_전국시대2 {
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
				a[Q]=P;
				people[P]+=people[Q];
				people[Q]=0;
			}
			else {
				int P_people = people[P];
				int Q_people = people[Q];
				if(P_people > Q_people) {
					int gap = P_people-Q_people;
					people[P] = gap;
					people[Q] = 0;
					a[Q] = P; 
				}
				else if(P_people < Q_people) {
					int gap = Q_people-P_people;
					people[Q]=gap;
					people[P]=0;
					a[P] = Q; 
				}
				else {
					people[Q]=0;
					people[P]=0;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(people));
		
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

	private static int find(int x) {
		if(a[x]==x) return x;
		else return a[x] = find(a[x]);
	}

}
