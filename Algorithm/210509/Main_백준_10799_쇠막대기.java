package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_10799_쇠막대기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		Stack<Boolean> stk = new Stack<>();
		
		int sum = 0;
		for(int z=0;z<s.length();z++) {
			char cur = s.charAt(z);
			if(cur==')' && z>0 && s.charAt(z-1)=='(') sum += stk.size();
			else if(cur=='(' && z>0 && s.charAt(z-1)=='(') stk.push(true);
			else if(cur==')' && z>0 && s.charAt(z-1)==')') {
				stk.pop();
				sum++;
			}
		}
		System.out.println(sum);
	}

}
