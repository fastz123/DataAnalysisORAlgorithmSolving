package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEXPERT_모의_수영장 {
	public static int Day,Month,ThreeMonth,year;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_������.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			Day = Integer.parseInt(s[0]);
			Month = Integer.parseInt(s[1]);
			ThreeMonth = Integer.parseInt(s[2]);
			year = Integer.parseInt(s[3]);
			
			int[] m = new int[12];
			s = br.readLine().split(" ");
			for(int z=0;z<12;z++) {
				m[z]=Integer.parseInt(s[z]);
			}
			min = Integer.MAX_VALUE;
			dfs(m,0,0);
			System.out.println("#"+(i+1)+" "+(min>year? year:min));
		}
	}

	public static int min;
	private static void dfs(int[] m, int curM, int billing) {
		if(curM>=12) {
			if(min>billing) min = billing;
		}
		else {
			if(m[curM]!=0) {
				dfs(m,curM+1,billing+(m[curM]*Day));
				dfs(m,curM+1,billing+Month);
				dfs(m,curM+3,billing+ThreeMonth);
			}
			else {
				dfs(m,curM+1,billing);
			}
		}
	}

}
