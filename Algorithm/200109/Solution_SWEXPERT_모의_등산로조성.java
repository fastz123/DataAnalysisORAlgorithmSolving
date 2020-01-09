import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_모의_등산로조성 {
	public static class Top {
		int x;
		int y;

		public Top(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static ArrayList<Top> Toplist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s[] = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			int digMax = Integer.parseInt(s[1]);

			arr = new int[N][N];
			int max = -1;
			for (int z = 0; z < N; z++) {
				String ss[] = br.readLine().split(" ");
				for (int x = 0; x < N; x++) {
					arr[z][x] = Integer.parseInt(ss[x]);
					if (arr[z][x] > max)
						max = arr[z][x];
				}
			}
			// System.out.println(max);

			Toplist = new ArrayList<>();
			for (int z = 0; z < N; z++) {
				for (int x = 0; x < N; x++) {
					if (arr[z][x] == max)
						Toplist.add(new Top(z, x));
				}
			}
//          System.out.println(Toplist.size());

			maximum = -1;
			for (Top t : Toplist) {
				v = new int[N][N];
				v[t.x][t.y] = 1;
				boolean f = false;
				dfs(t.x, t.y, digMax, arr, 1, f);
				v[t.x][t.y] = 0;
			}
			System.out.println("#" + (i + 1) + " " + maximum);
		}
	}

	public static int di[] = { 0, -1, 0, 1 }, dj[] = { -1, 0, 1, 0 }, v[][], N, arr[][], maximum;
	public static ArrayList<int[]> list = new ArrayList<>();

	private static void dfs(int i, int j, int digMax, int[][] arr, int cnt, boolean f) {
		if (maximum < cnt) {
			maximum = cnt;
		}
		for (int z = 0; z < 4; z++) {
			int newx = i + di[z];
			int newy = j + dj[z];
			if (newx >= 0 && newx < N && newy >= 0 && newy < N && v[newx][newy] == 0) {
				for (int k = digMax; k >= 0; k--) {
					// arr[newx][newy]-k>=1 &&
					if (k != 0 && f == false) {
						// arr[newx][newy]-k>=0 &&
						if (arr[i][j] > arr[newx][newy] - k) {
							f = true;
							v[newx][newy] = cnt + 1;
							arr[newx][newy] -= k;
							dfs(newx, newy, digMax, arr, cnt + 1, f);
							v[newx][newy] = 0;
							arr[newx][newy] += k;
							f = false;
						}
					} else if (k == 0) {
						if (arr[i][j] > arr[newx][newy]) {
							v[newx][newy] = cnt + 1;
							dfs(newx, newy, digMax, arr, cnt + 1, f);
							v[newx][newy] = 0;
						}
					}
				}
			}
		}
	}
}