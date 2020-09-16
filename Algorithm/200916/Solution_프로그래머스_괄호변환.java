package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_프로그래머스_괄호변환 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_괄호변환.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		if(s.length()==0) System.out.println(s);
		Stack<Character> stack = new Stack<>();
		
		
		boolean f= checkIsRight(s);
		if(f) System.out.println(s);
		else {
			String ans = MakeRight(s);
			System.out.println(ans);
		}
		
	}

	

	private static String MakeRight(String s) {
		String retStr = new String();
		
		int[] arr = new int[2];
		String str = s;
		StringBuffer u = new StringBuffer();
		StringBuffer v = new StringBuffer();
		for(int z=0;z<str.length();z++) {
			char cur = str.charAt(z);
			if(cur == '(') arr[0]++;
			else arr[1]++;
			
			if(arr[0] == arr[1]) {
				u.append(str.substring(0,z+1));
				v.append(str.substring(z+1));
				
				if(checkIsRight(u.toString())) {
					retStr += u;
					if(checkIsRight(v.toString())) return retStr += v;
					else {
						return retStr += MakeRight(v.toString());
					}
				}
				else {
					
					String cs = new String();
					if(checkIsRight(v.toString())) cs = v.toString();
					else cs = MakeRight(v.toString());
					String vres = "(";
					vres += cs;
					vres += ")";
					u.delete(0, 1);
					u.delete(u.length()-1, u.length());
					for(int q=0;q<u.length();q++) {
						if(u.charAt(q) == '(') u.replace(q, q+1, ")");
						else u.replace(q, q+1, "(");
					}
					
					vres += u.toString();
					
					return retStr += vres;
				}
				
			}
			else continue;
			
			
		}
		
		return retStr;
	}



	private static boolean checkIsRight(String s) {
		if(s.length()==0) return true;
		Stack<Character> stack = new Stack<Character>();
		boolean f = true;
		for(int z=0;z<s.length();z++) {
			char cur = s.charAt(z);
			if(cur == '(') stack.push(cur);
			else {
				if(stack.isEmpty()) {
					f=false;
					break;
				}
				if(stack.peek() == '(') stack.pop();
			}
		}
		
		if(stack.isEmpty() && f) return true;
		else return false;
	}

}
