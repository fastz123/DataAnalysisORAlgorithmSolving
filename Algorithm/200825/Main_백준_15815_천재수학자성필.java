package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_백준_15815_천재수학자성필 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		Stack<Integer> stack = new Stack<>();
		for(int z=0;z<s.length();z++) {
			int c = s.charAt(z)-'0';
			if(c>=0 && c<=9) {
				stack.push(c);
			}
			else {
				int b = stack.pop();
				int a = stack.pop();
				if(s.charAt(z) == '+') {
					stack.push(a+b);
				}
				else if(s.charAt(z) == '-') {
					stack.push(a-b);
				}
				else if(s.charAt(z) == '*') {
					stack.push(a*b);
				}
				else if(s.charAt(z) == '/') {
					stack.push(a/b);
				}
				
			}
		}
		
		bw.write(stack.peek()+"\n");

		bw.flush();
		bw.close();
	}

}
