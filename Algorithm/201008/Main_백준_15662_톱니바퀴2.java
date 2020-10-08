package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main_백준_15662_톱니바퀴2 {
	public static LinkedList<Integer> list[];
	public static boolean v[];
	public static int T;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_톱니바퀴2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		list = new LinkedList[T];
		for(int z=0;z<T;z++) {
			list[z] = new LinkedList<Integer>();
			String s = br.readLine();
			for(int x=0;x<8;x++) {
				list[z].add(s.charAt(x)-'0');
			}
		}

		int N = Integer.parseInt(br.readLine());
		for(int z=0;z<N;z++) {
			String[] s = br.readLine().split(" ");
			int where = Integer.parseInt(s[0]);
			int how = Integer.parseInt(s[1]);
			
			v = new boolean[T-1];
			check();
			turn(where-1,how,'s');
		}
		int ans = 0;
		for(LinkedList<Integer> l : list) if(l.get(0)==1) ans++;
		
		System.out.println(ans);
		
	}
	private static void turn(int where, int how, char c) {
		Collections.rotate(list[where], how);
		if(c=='s') {
			int left = where-1;
			if(left>=0 && v[left]) turn(left,-how,'l');
			
			int right = where+1;
			if(right<T && v[right-1]) turn(right,-how,'r');
		}
		else if(c=='l') {
			int left = where-1;
			if(left>=0 && v[left]) turn(left,-how,'l');
		}
		else {
			int right = where+1;
			if(right<T && v[right-1]) turn(right,-how,'r');
		}
	}
	
	private static void check() {
		for(int z=0;z<T-1;z++) {
			if(list[z].get(2) != list[z+1].get(6)) v[z]=true;
		}
	}

}
