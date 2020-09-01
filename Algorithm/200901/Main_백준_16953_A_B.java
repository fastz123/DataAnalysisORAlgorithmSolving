package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_16953_A_B {
	public static Long A,B;
	public static Long min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		A = Long.parseLong(s[0]);
		B = Long.parseLong(s[1]);
		min = Long.MAX_VALUE;
//		dfs(A,(long)0);
		bfs(A,(long)0);
		System.out.println(min==Long.MAX_VALUE? -1:(min+1));
	}
	private static void dfs(Long cur, Long cnt) {
		if(cnt > min) return;
		if(cur>B) return;
		if((long)cur==B) {
			min = Math.min(min, cnt);
			return;
		}
		else {
			dfs(cur*2,cnt+1);
			dfs((cur*10)+1,cnt+1);
		}
	}
	
	private static void bfs(Long cu, Long cnt) {
		Queue<Long[]> q = new LinkedList();
		q.offer(new Long[] {cu,cnt});
		while(!q.isEmpty()){
			Long[] cur = q.poll();
			if(cur[1] > min) continue;
			if(cur[0]>B) continue;
			if((long)cur[0]==B) {
				min = Math.min(min, cur[1]);
				continue;
			}
			else {
				q.offer(new Long[] {cur[0]*2,cur[1]+1});
				q.offer(new Long[] {(cur[0]*10)+1,cur[1]+1});
			}
		}
	}

}
