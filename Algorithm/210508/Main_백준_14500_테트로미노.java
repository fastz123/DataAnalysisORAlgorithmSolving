package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_14500_테트로미노 {
	static int N,M, map[][], max, di[]= {0,-1,0,1}, dj[]= {-1,0,1,0};
	static boolean v[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_테트로미노.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<M;x++) {
				map[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		max = Integer.MIN_VALUE;
		v = new boolean[N][M];
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				Hcheck(z,x);
				v[z][x] = true;
				dfs(z,x,1,map[z][x]);
				v[z][x] = false;
			}
		}
		
		System.out.println(max);
	}
	private static void dfs(int z, int x, int cnt, int sum) {
		if(cnt==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int newx = z+di[i];
			int newy = x+dj[i];
			
			if(newx>=0 && newx<N && newy>=0 && newy<M && !v[newx][newy]) {
				v[newx][newy]=true;
				dfs(newx,newy,cnt+1,sum+map[newx][newy]);
				v[newx][newy]=false;
			}
		}
	}
	private static void Hcheck(int z, int x) {
		if(z-1>=0 && z+1<N && x+1<M) { //ㅏ
			int sum = map[z-1][x]+map[z+1][x]+map[z][x]+map[z][x+1];
			max = Math.max(max, sum);
		}
		if(z-1>=0 && z+1<N && x-1>=0) {//ㅓ
			int sum = map[z-1][x]+map[z+1][x]+map[z][x-1]+map[z][x];
			max = Math.max(max, sum);
		}
		if(x-1>=0 && x+1<M && z-1>=0) { //ㅗ
			int sum = map[z][x-1]+map[z][x+1]+map[z-1][x]+map[z][x];
			max = Math.max(max, sum);
		}
		if(x-1>=0 && x+1<M && z+1<N) { //ㅜ
			int sum = map[z][x-1]+map[z][x+1]+map[z+1][x]+map[z][x];
			max = Math.max(max, sum);
		}
	}

}
