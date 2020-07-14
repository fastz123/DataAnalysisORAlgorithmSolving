import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_1949_등산로조성 {
	public static int map[][],size,K;
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_등산로조성.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			size = Integer.parseInt(s[0]);
			K = Integer.parseInt(s[1]);
			
			map = new int[size][size];
			int top = -1;
			ArrayList<Integer> list = new ArrayList<>();
			for(int z=0;z<size;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					map[z][x] = Integer.parseInt(s[x]);
					if(top < map[z][x]) {
						top = map[z][x];
						list = new ArrayList<>();
						list.add(z*size+x);
					}
					else if(top == map[z][x]) {
						list.add(z*size+x);
					}
				}
			}
			
			max = Integer.MIN_VALUE;
			
			for(int cur : list) {
				int x = cur/size;
				int y = cur%size;
				
				cnt=1;
				v = new boolean[size][size];
				v[x][y] = true;
				dfs(x,y,1);
				v[x][y] = false;
			}
			
			System.out.println("#"+(i+1)+" "+max);
		}

	}
	public static int di[]= {0,-1,0,1}, dj[]= {-1,0,1,0},cnt,max;
	private static void dfs(int x, int y, int c) {
		
		if(max < cnt) {
			max = cnt;
//			System.out.println(cnt);
//			printmap();
//			System.out.println("----------------------");
		}
		for(int z=0;z<4;z++) {
			int newx = x+di[z];
			int newy = y+dj[z];
			if(newx>=0 && newy<size && newy>=0 && newx<size && !v[newx][newy] ) {
				if(map[x][y] > map[newx][newy]) {
					v[newx][newy] = true;
					cnt++;
					dfs(newx,newy,c);
					cnt--;
					v[newx][newy] = false;
				}
				else {
					if(c>0) {
						for(int k=1;k<=K;k++) {
							if(map[x][y] > map[newx][newy]-k) {
								v[newx][newy] = true;
								cnt++;
								map[newx][newy] -= k;
								dfs(newx,newy,c-1);
								map[newx][newy] += k;
								cnt--;
								v[newx][newy] = false;
							}
						}
					}
				}
			}
		}
	}
	private static void printmap() {
		for(boolean[] c : v) {
			System.out.println(Arrays.toString(c));
		}
		System.out.println();
	}

}
