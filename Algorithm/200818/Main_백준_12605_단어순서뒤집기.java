package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_12605_단어순서뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int z=0;z<T;z++) {
			String[] s = br.readLine().split(" ");
			Stack<String> stack = new Stack<String>();
			for(int k=0;k<s.length;k++) stack.push(s[k]);
			
			System.out.print("Case #"+(z+1)+": ");
			while(!stack.isEmpty()) System.out.print(stack.pop()+" ");
			System.out.println();
		}

	}

}
