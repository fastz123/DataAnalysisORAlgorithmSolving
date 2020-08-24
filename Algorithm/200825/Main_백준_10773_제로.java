package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_10773_제로 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for(int z=0;z<T;z++) {
			int cur = Integer.parseInt(br.readLine());
			if(cur==0) stack.pop();
			else stack.push(cur);
		}
		
		int sum=0;
		for(int i : stack) {
			sum+=i;
		}
		System.out.println(sum);
	}

}
