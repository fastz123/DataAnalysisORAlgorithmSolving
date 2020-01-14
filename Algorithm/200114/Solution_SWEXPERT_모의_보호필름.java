import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_모의_보호필름2 {
	public static int r,c,arr[][],pass,copy[][],ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_보호필름.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			r = Integer.parseInt(s[0]);
			c = Integer.parseInt(s[1]);
			arr = new int[r][c];
			pass = Integer.parseInt(s[2]);
			for(int z=0;z<r;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<c;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			if(pass==1) {
				System.out.println("#"+(i+1)+" "+0);
				continue;
			}
			copy = new int[r][c];
			for(int z=0;z<r;z++) {
				for(int x=0;x<c;x++) {
					copy[z][x] = arr[z][x];
				}
			}
			
			ans = Integer.MAX_VALUE;
			dfs(0,0);
			System.out.println("#"+(i+1)+" "+ans);
			f=false;
		}

	}
	private static void dfs(int floor, int insertcnt) {
		if(insertcnt>=ans) return;
		if(floor>=r) {
			check();
			if(f) {
				if(ans>insertcnt) ans = insertcnt;
			}
			return;
		}
		
		dfs(floor+1,insertcnt); //주입x
		
		//A주입
		for(int z=0;z<c;z++) {
			arr[floor][z]=1;
		}
		dfs(floor+1,insertcnt+1);
		
		//B주입
		for(int z=0;z<c;z++) {
			arr[floor][z]=0;
		}
		dfs(floor+1,insertcnt+1);
		
		for(int z=0;z<c;z++) {
			arr[floor][z]=copy[floor][z];
		}
	}
	public static boolean f;
	private static void check() {
		
				int checkcnt=0;
	case2:		for(int col = 0;col<c;col++) {
					for(int q=0;q<=r-pass;q++) {
						int pop = 0 ;
						int cur = arr[q][col];
						for(int p = 1;p<pass;p++) {
							if(cur==arr[q+p][col]) pop++;
						}
						if(pop==pass-1) {
							checkcnt++;
							continue case2;
						}
						else if(q==r-pass) {
							f=false;
							return;
						}
						else continue;
					}
				}
				if(checkcnt==c) {
					f=true;
					return;
				}
			}
}
