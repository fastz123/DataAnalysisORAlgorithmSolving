package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_18243_SmallWorldnetwork {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_스몰월드네트워크.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		
		map = new int[M][M];
		
		for(int z=0;z<L;z++) {
			s = br.readLine().split(" ");
			int from = Integer.parseInt(s[0])-1;
			int to = Integer.parseInt(s[1])-1;
			map[from][to]=1;
			map[to][from]=1;
		}

		v = new int[M];
		Arrays.fill(v, Integer.MAX_VALUE);
		v[0]=0;
		dfs(0,0);
		if(!check()) {
			System.out.println("Big World!");
			return;
		}
		System.out.println("Small World!");
	}
	private static boolean check() {
		for(int z=0;z<v.length;z++) {
			if(v[z]>=7) return false;
		}
		return true;
		
	}
	public static int v[],M,map[][];
	private static void dfs(int i, int sum) {
		for(int z=0;z<M;z++) {
			if(map[i][z]==1) {
				if(v[z] > sum) {
					v[z]=sum+1;
					dfs(z,sum+1);
				}
			}
		}
	}

}
