import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEXPERT_2112_보호필름 {
	public static int arr[][],D,W,K,min,copy[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_보호필름.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			D = Integer.parseInt(s[0]);
			W = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]);
			
			arr = new int[D][W];
			copy = new int[D][W];
			for(int z=0;z<D;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<W;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
					copy[z][x] = arr[z][x];
				}
			}
			
			min = Integer.MAX_VALUE;
			
			if(K==1 || check()) {
				System.out.println("#"+(i+1)+" "+'0'
			);
				continue;
			}
			else{
				dfs(0,0);
			}
			
			System.out.println("#"+(i+1)+" "+min);
		}

	}
	
	private static void dfs(int i, int cnt) {
		if(min < cnt) return;
		if(i==D) {
//			System.out.println(cnt);
//			printmap();
			if(check()) {
				min = Math.min(min, cnt);
				return;
			}
		}
		else {
			//안바꾼다.
			dfs(i+1,cnt);
			
			//A로바꾼다.
			for(int z=0;z<W;z++) {
				arr[i][z] = 0;
			}
			dfs(i+1,cnt+1);
			
			//B로바꾼다.
			for(int z=0;z<W;z++) {
				arr[i][z] = 1;
			}
			dfs(i+1,cnt+1);
			
			for(int z=0;z<W;z++) arr[i][z] = copy[i][z];
		}
	}

	private static void printmap() {
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		System.out.println("----------------");
	}

	private static boolean check() {
case1:	for(int z=0;z<W;z++) {
			int cnt = 1;
			int curx = 0;
			int curval = arr[curx][z];
			while(true) {
				curx++;
				if(curx==D) break;
				if(curval == arr[curx][z]) {
					cnt++;
				}
				else {
					curval = arr[curx][z];
					cnt=1;
				}
				if(cnt>=K) continue case1;
			}
			
			return false;
		}
		
		return true;
	}

}
