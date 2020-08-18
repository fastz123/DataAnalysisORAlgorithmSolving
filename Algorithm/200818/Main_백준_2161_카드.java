package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2161_카드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList();
		Queue<Integer> outq = new LinkedList();
		for(int z=1;z<=T;z++) q.offer(z);
		
		while(q.size()!=1) {
			outq.offer(q.poll());
			int cur = q.poll();
			q.offer(cur);
		}
		
		for(int c : outq) System.out.print(c+" ");
		System.out.print(q.poll());
		
	}

}
