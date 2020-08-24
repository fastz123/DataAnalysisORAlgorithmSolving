package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_11866_요세푸스문제0 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		Queue<Integer> q = new LinkedList();
		for(int z=1;z<=N;z++) q.offer(z);
		
//		System.out.print("<");
		bw.write("<");
		int cnt = 1;
		while(q.size()>1) {
			int cur = q.poll();
			if(cnt == K) {
//				System.out.print(cur+", ");
				bw.write(cur+", ");
				cnt=0;
			}
			else {
				q.offer(cur);
			}
			cnt++;
		}
		
//		System.out.println(q.poll()+">");
		bw.write(q.poll()+">");
		
		bw.flush();
		bw.close();

	}

}
