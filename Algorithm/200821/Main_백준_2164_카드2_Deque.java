package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main_백준_2164_카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<>();
		Deque<Integer> deq = new ArrayDeque<Integer>();
		
		for(int z=1;z<=T;z++) deq.offerLast(z);
		
		while(deq.size()>1) {
			deq.pollFirst();
			int cur = deq.pollFirst();
			deq.offerLast(cur);
		}
		
		System.out.println(deq.poll());

	}

}
