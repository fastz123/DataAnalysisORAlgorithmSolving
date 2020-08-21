package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_3986_좋은단어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int z=0;z<T;z++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			for(int k=0;k<s.length();k++) {
				if(stack.isEmpty()) {
					stack.push(s.charAt(k));
				}
				else {
					if(stack.peek() == s.charAt(k)) {
						stack.pop();
					}
					else {
						stack.push(s.charAt(k));
					}
				}
			}
			
			if(stack.isEmpty()) cnt++;
		}
		System.out.println(cnt);
		

	}

}
