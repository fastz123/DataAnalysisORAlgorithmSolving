package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_17471_게리맨더링 {
	public static int map[][],size,arr[],min;
	public static ArrayList<Integer> Alist,Blist;
	public static boolean v[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_게리맨더링.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		arr = new int[size];
		String[] s= br.readLine().split(" ");
		for(int z=0;z<size;z++) arr[z] = Integer.parseInt(s[z]);
		
		map = new int[size][size];
		for(int z=0;z<size;z++) {
			s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			for(int k=1;k<n+1;k++) {
				int cur = Integer.parseInt(s[k])-1;
				map[z][cur] = 1;
				map[cur][z] = 1;
			}
		}
		
		min = Integer.MAX_VALUE;
		v = new boolean[size];
		Alist = new ArrayList<>();
		Blist = new ArrayList<>();
		dfs(0);
		System.out.println(min==Integer.MAX_VALUE? -1:min);
	}
	private static void dfs(int i) {
		if(i>=size) {
			if(check()) {
				int sumA = 0;
				for(int cur : Alist) sumA += arr[cur];
				int sumB = 0;
				for(int cur : Blist) sumB += arr[cur];
				
				int gap = Math.abs(sumA-sumB);
				min = Math.min(gap, min);
			}
			return;
		}
		else {
			//A에 추가
			Alist.add(i);
			dfs(i+1);
			Alist.remove(Alist.size()-1);
			//B에 추가
			Blist.add(i);
			dfs(i+1);
			Blist.remove(Blist.size()-1);
		}
	}
	public static boolean[] Acheck,Bcheck;
	private static boolean check() {
		Acheck = new boolean[size];
		Bcheck = new boolean[size];
		if(Alist.size()>0) {
			Acheck[Alist.get(0)] = true;
			Adfs(Alist.get(0));
		}
		if(Blist.size()>0) {
			Bcheck[Blist.get(0)] = true;
			Bdfs(Blist.get(0));
		}
		
		for(int z=0;z<size;z++) {
			Acheck[z]^=Bcheck[z];
			if(!Acheck[z]) return false;
		}
		return true;
	}
	private static void Bdfs(Integer cur) {
		for(int z=0;z<size;z++) {
			if(!Bcheck[z] && map[cur][z]==1 && Blist.contains(z)) {
				Bcheck[z]=true;
				Bdfs(z);
			}
		}
		
	}
	private static void Adfs(int cur) {
		for(int z=0;z<size;z++) {
			if(!Acheck[z] && map[cur][z]==1 && Alist.contains(z)) {
				Acheck[z]=true;
				Adfs(z);
			}
		}
	}
	

}
