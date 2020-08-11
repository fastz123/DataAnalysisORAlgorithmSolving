package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;

public class Solution_SWEXPERT_5432_쇠막대기자르기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_쇠막대기자르기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			String s = br.readLine();
			
			Stack<Boolean> stack = new Stack<Boolean>();
			
			int ans = 0;
			
			for(int z=0;z<s.length()-1;z++) {
				char c = s.charAt(z);
				char next = s.charAt(z+1);
				
				if(c == '(' && next == ')') {//레이저
					ans += stack.size();
				}else if(c=='(' && next == '('){ //막대
					stack.add(true);
				}else if(c==')' && next == ')') { //막대 끝
					stack.pop();
					ans++;
				}
			}
			
			System.out.println(ans);

	}

}
