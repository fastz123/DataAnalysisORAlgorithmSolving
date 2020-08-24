package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_백준_12789_도키도키간식드리미 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new ArrayDeque<Integer>();
		String[] s = br.readLine().split(" ");
		for(int z=0;z<T;z++) deq.offer(Integer.parseInt(s[z]));
		
		Stack<Integer> stack = new Stack();
		int cnt = 1;
		
		while(true) {

			if(deq.isEmpty() && stack.isEmpty()) {
				bw.write("Nice");
				break;
			}
			else {
				
				if(deq.contains(cnt)) {
					while(cnt != deq.peek()) {
						stack.push(deq.poll());
					}
					
					deq.poll();
					cnt++;
				}
				else if(stack.peek()==cnt){
					
					stack.pop();
					cnt++;
				}
				else if(stack.peek()!=cnt) {
					bw.write("Sad");
					break;
				}
				
			}
			
		}
		
		bw.flush();
		bw.close();

	}

}
