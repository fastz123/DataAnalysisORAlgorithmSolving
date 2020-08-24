package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_9012_괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
case1:	for(int z=0;z<T;z++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int k=0;k<s.length();k++) {
				if(stack.isEmpty()) stack.push(s.charAt(k));
				else {
					if(s.charAt(k)==')' && stack.peek()=='(') stack.pop();
					else if(s.charAt(k)==')' && stack.isEmpty()){
						System.out.println("NO");
						continue case1;
					}
					else stack.push('(');
				}
			}
			
			if(stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
			
			
		}

	}

}
