package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_SWEXPERT_모의_디저트카페 {
	public static int arr[][], size,stx,sty;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_디저트카페.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			size = Integer.parseInt(br.readLine());
			arr = new int[size][size];

			for (int z = 0; z < size; z++) {
				String s[] = br.readLine().split(" ");
				for (int x = 0; x < size; x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			max=-1;
			for (int z = 0; z < size; z++) {
				for (int x = 0; x < size; x++) {
					//z=6;
					//x=6;
					if ((z == 0 && x == 0) || (z == 0 && x == size - 1) || (z == size - 1 && x == 0) || (z == size - 1 && x == size - 1)) {
						continue;
					} 
					else {
						v = new int[size][size];
						list = new ArrayList<>();
						v[z][x]=1;
						list.add(arr[z][x]);
						dfs(z, x,3,0);
					}
				}
			}
			System.out.println("#"+(i+1)+" "+max);
		}
	}

	public static ArrayList<String> log;
	public static ArrayList<Integer> list;
	public static int di[] = { -1, -1, 1, 1 }, dj[] = { -1, 1, 1, -1 }, v[][],max;

	private static void dfs(int i, int j, int see, int cnt) {
		if(cnt>3) return;
		for(int k = 0;k<=1;k++) {
			int seek=see-k;
			
			if(seek<0) seek=3;
			int newx = i + di[seek];
			int newy = j + dj[seek];
			if (newx >= 0 && newx < size && newy >= 0 && newy < size) {
				if ((newx == 0 && newy == 0) || (newx == size - 1 && newy == 0) || (newx == 0 && newy == size - 1) || (newx == size - 1 && newy == size - 1)) {

				} 
				else {
					if(v[newx][newy]==0 && !list.contains(arr[newx][newy])) {
						v[newx][newy]=1;
						list.add(arr[newx][newy]);
						if(k==1) dfs(newx,newy,seek,cnt+1);
						else dfs(newx,newy,seek,cnt);
						list.remove(list.size()-1);
						v[newx][newy]=0;
					}
					else if(v[newx][newy]==1 && list.get(0)==arr[newx][newy] && list.size()>=4) {
						int siz = list.size();
						if(max<siz) max = siz;
						return;
					}
				}
			}
		}
	}

}
