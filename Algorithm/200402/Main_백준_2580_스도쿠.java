package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2580_스도쿠 {
	public static int map[][];
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_스도쿠.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		for(int z=0;z<9;z++) {
			String[] s = br.readLine().split(" ");
			for(int x=0;x<9;x++) {
				map[z][x] = Integer.parseInt(s[x]);
			}
		}

		dfs(0,0);
	}

	public static boolean f;
	private static void dfs(int i, int j) {
		if(f) return;
		if(i==9) {
			printmap();
			f=true;
			return;
		}
		if(j>=9) {
			dfs(i+1,0);
			return;
		}	
		if(map[i][j]!=0) {
			dfs(i,j+1); 
			return;
		}
		
		//1~9까지 넣어봄
		for(int k=1;k<=9;k++) {
			if(check(map,i,j,k)) {
				dfs(i,j+1);
//				map[i][j]=0;
			}
			else {
				continue;
			}
		}
		map[i][j]=0;
		return;
	}

	private static void printmap() {
		for(int[] a:map) {
			for(int b:a) System.out.print(b+" ");
			System.out.println();
		}
	}

	private static boolean check(int[][] map, int i, int j, int k) {
		map[i][j]=k;
		//가로 체크
		boolean f1[] = new boolean[9];
		for(int z=0;z<9;z++) {
			if(map[i][z]==0) continue;
			if(map[i][z]!=0 && !f1[map[i][z]-1]) {
				f1[map[i][z]-1]=true;
			}
			else if(f1[map[i][z]-1]) return false;
		}
		//세로 체크
		boolean f2[] = new boolean[9];
		for(int z=0;z<9;z++) {
			if(map[z][j]==0) continue;
			if(map[z][j]!=0 && !f2[map[z][j]-1]) f2[map[z][j]-1]=true;
			else if(f2[map[z][j]-1]) return false;
		}
		//인접 9체크
		int areax = i/3;
		int areay = j/3;
		boolean f3[] = new boolean[9];
		for(int z=areax*3;z<areax*3+3;z++) {
			for(int x=areay*3;x<areay*3+3;x++) {
				if(map[z][x]==0) continue;
				if(map[z][x]!=0 && !f3[map[z][x]-1]) f3[map[z][x]-1]=true;
				else if(f3[map[z][x]-1]) return false;
			}
		}
		return true;
	}

}
