import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEXPERT_1952_수영장 {
	public static int day, month, month3, year, min;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_수영장.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			day = Integer.parseInt(s[0]);
			month = Integer.parseInt(s[1]);
			month3 = Integer.parseInt(s[2]);
			year = Integer.parseInt(s[3]);
			
			int[] plan = new int[12];
			s = br.readLine().split(" ");
			for(int z=0;z<12;z++) {
				plan[z] = Integer.parseInt(s[z]);
			}
			
			min = Integer.MAX_VALUE;
			dfs(0,0, plan);
			
			System.out.println("#"+(i+1)+" "+(min > year? year:min));
		}

	}
	private static void dfs(int cur, int money, int[] plan) {
		if(cur>=12) {
			min = Math.min(min, money);
			return;
		}
		else {
			if( plan[cur] == 0 ) dfs(cur+1,money,plan);
			else {
				//day
				int curm = day*plan[cur];
				dfs(cur+1,money+curm,plan);
				
				//month
				dfs(cur+1, money+month, plan);
				
				//month3
				dfs(cur+3, money+month3, plan);
				
			}
		}
		
	}

}
