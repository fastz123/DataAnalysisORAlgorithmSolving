package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_1245_농장관리 {
	static int map[][],N,M, di[]= {0,-1,0,1,-1,-1,1,1}, dj[]= {-1,0,1,0,-1,1,1,-1};
	static boolean v[][], isPeak;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_농장관리.txt"));
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
		
		v = new boolean[N][M];
		isPeak = true;
		int ans = 0;
		
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++){
				if(map[z][x]>0 && !v[z][x]) {
					v[z][x]=true;
					dfs(z,x);
					if(isPeak) ans++;
					isPeak = true;
				}
			}
		}
		
		System.out.println(ans);
	}
	private static void dfs(int z, int x) {
		for(int i=0;i<8;i++) {
			int newx = z+di[i];
			int newy = x+dj[i];
			
			if(newx>=0 && newx<N && newy>=0 && newy<M && map[newx][newy] > map[z][x]) isPeak=false;
			if(newx>=0 && newx<N && newy>=0 && newy<M && !v[newx][newy] && map[z][x] == map[newx][newy]) {
				v[newx][newy]=true;
				dfs(newx,newy);
			}
		}
	}

}
