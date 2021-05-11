package algo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_16500_문자열판별 {

	public static void main(String[] args) throws Exception{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String s = br.readLine();
		int[] dp = new int[s.length()+1];
		
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for(int z=0;z<N;z++) words[z] = br.readLine();
		
		dp[s.length()]=1;
		
case1:	for(int i=s.length();i>=0;i--) {
			if(dp[i]!=1) continue;
			for(String cur : words) {
				int clen = cur.length();
				if(i-clen >=0 ) {
					String tempStr = s.substring(i-clen,i);
					if(cur.equals(tempStr)) {
						if(dp[i]==1) {
							dp[i-clen]=1;
							if(i-clen==0) break case1;
						}
					}
				}
			}
		}
		
		System.out.println(dp[0]);
//		System.out.println(Arrays.toString(dp));
	}

}
