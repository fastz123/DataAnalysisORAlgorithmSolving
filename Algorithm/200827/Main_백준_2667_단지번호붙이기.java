package algoProblems;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main_백준_2667_단지번호붙이기 {

	public static boolean v[][];
	public static int map[][],size;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		
		for(int z=0;z<size;z++) {
			String s = br.readLine();
			for(int x=0;x<size;x++) {
				map[z][x] = s.charAt(x)-'0';
			}
		}
		
		v = new boolean[size][size];
		
		ArrayList<Integer> list = new ArrayList();
		
		int ccc=0;
		for(int z=0;z<size;z++) {
			for(int x=0;x<size;x++) {
				if(map[z][x]==1 && !v[z][x]) {
					cnt=1;
					v[z][x]=true;
					ccc++;
					dfs(z,x);
//					System.out.println(cnt);
					list.add(cnt);
				}
			}
		}
		System.out.println(ccc);
		
		Collections.sort(list);
		for(int cur : list) System.out.println(cur);

	}
	public static int di[]= {0,-1,0,1}, dj[]= {-1,0,1,0},cnt;
	private static void dfs(int i, int j) {
		for(int z=0;z<4;z++) {
			int newx = i+di[z];
			int newy = j+dj[z];
			if(newx>=0 && newx<size && newy>=0 && newy<size && map[newx][newy]==1 && !v[newx][newy]) {
				cnt++;
				v[newx][newy]=true;
				dfs(newx,newy);
				
			}
		}
		
	}

}
