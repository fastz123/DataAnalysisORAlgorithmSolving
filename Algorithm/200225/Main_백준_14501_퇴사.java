import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_14501_퇴사 {
	public static int arr[][],k;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_퇴사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		arr = new int[2][k];
		
		for(int z=0;z<k;z++) {
			String[] s = br.readLine().split(" ");
			int day = Integer.parseInt(s[0]);
			int pay = Integer.parseInt(s[1]);
			arr[0][z]=day;
			arr[1][z]=pay;
		}

		max = Integer.MIN_VALUE;
		dfs(0,0);
		System.out.println(max);
	}

	public static int max;
	private static void dfs(int day, int sum) {
		
		if(day>=k) {
			if(max<sum) max = sum;
			return;
		}
		
		//day일 날 신청
		if(day+arr[0][day]-1 < k) {
			dfs(day+arr[0][day],sum+arr[1][day]);
		}
		
		
		//안신청
		dfs(day+1,sum);
	}

}
