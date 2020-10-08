package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_13305_주유소 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_주유소.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		long[] dist = new long[T-1];
		long[] cost = new long[T];
		
		long totlen = 0;
		String[] s = br.readLine().split(" ");
		for(int z=0;z<T-1;z++) {
			dist[z] = Long.parseLong(s[z]);
			totlen += dist[z];
		}
		s = br.readLine().split(" ");
		for(int z=0;z<T;z++) cost[z] = Long.parseLong(s[z]);
		
		long ans = 0;
		int cur = 0;
		long curlen = 0;
		while(true) {
			long len = dist[cur];
			long curcost = cost[cur];
			int cnt = 1;
			for(int i=cur+1;i<T-1;i++) {
				if(curcost > cost[i]) {
					break;
				}
				len += dist[i];
				cnt++;
			}
			
			ans += curcost * len;
			curlen += len;
			cur+=cnt;
			if(curlen==totlen) break;
		}

		System.out.println(ans);
	}

}