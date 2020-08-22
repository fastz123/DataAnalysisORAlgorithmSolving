package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.FileInputStream;

public class Main_백준_4949_균형잡힌세상 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_균형잡힌세상.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
case1:	while(true) {
			String s = br.readLine();
			if(s.length()==1 && s.charAt(0)=='.') break;
			Stack<Character> stack = new Stack<Character>();
			for(int z=0;z<s.length();z++) {
				char cur = s.charAt(z);
				if(cur=='(' || cur=='[') {
					stack.push(cur);
				}
				else if(cur==')' || cur==']') {
					if(stack.isEmpty()) {
						System.out.println("no");
						continue case1;
					}
					else{
						if(cur == ')') {
							if(stack.peek() == '(') {
								stack.pop();
							}
							else {
								System.out.println("no");
								continue case1;
							}
						}
						else {
							if(stack.peek() == '[') stack.pop();
							else {
								System.out.println("no");
								continue case1;
							}
						}
					}
				}
				else continue;
			}
			
			if(stack.isEmpty()) System.out.println("yes");
			else System.out.println("no");
			
		}

	}

}
