import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_4008_숫자만들기 {
	public static ArrayList<Integer> list;
	public static int len,arr[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_숫자만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			len = Integer.parseInt(br.readLine());
			int[] buho = new int[4];
			String[] s = br.readLine().split(" ");
			for(int z=0;z<4;z++) buho[z] = Integer.parseInt(s[z]);
			
			s = br.readLine().split(" ");
			arr = new int[len];
			for(int z=0;z<len;z++) arr[z] = Integer.parseInt(s[z]);
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(0,arr[0],buho);
			
			System.out.println("#"+i+" "+(max-min));
		}

	}
	
	public static int min,max;
	private static void dfs(int i, int res, int[] buho) {
		if(i>=len-1) {
			min = Math.min(min, res);
			max = Math.max(max, res);
			return;
		}
		else {
			if(buho[0]>0) {
				buho[0]--;
				dfs(i+1,res+arr[i+1],buho);
				buho[0]++;
			}
			if(buho[1]>0) {
				buho[1]--;
				dfs(i+1,res-arr[i+1],buho);
				buho[1]++;
			}
			if(buho[2]>0) {
				buho[2]--;
				dfs(i+1,res*arr[i+1],buho);
				buho[2]++;
			}
			if(buho[3]>0) {
				buho[3]--;
				dfs(i+1,res/arr[i+1],buho);
				buho[3]++;
			}
			
		}
	}

}
