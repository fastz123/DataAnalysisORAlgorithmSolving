package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileInputStream;

public class Main_백준_1890_점프 {
	public static int map[][],N;
	public static long v[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_점프.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int z=0;z<N;z++) {
			String[] s = br.readLine().split(" ");
			for(int x=0;x<N;x++) {
				map[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		v = new long[N][N];
		for(long a[]:v)  Arrays.fill(a, -1);
		long cur = dfs(0,0);
		
		System.out.println(cur);
	}
	public static int di[]= {0,1}, dj[]= {1,0};
	private static long dfs(int i, int j) {
		if((i<0 || i>=N) || (j<0 || j>=N)) return 0;
		if(i==N-1 && j==N-1) return 1;
		if(map[i][j]==0) return 0;
		
		long ret = v[i][j];
		if(ret!=-1) return ret;
		else {
			long cur = 0;
			for(int z=0;z<2;z++) {
				
				int newx = i+di[z]*map[i][j];
				int newy = j+dj[z]*map[i][j];
				
				cur += dfs(newx, newy);
				
			}
			
			return v[i][j] = cur;
		}
	}

}
