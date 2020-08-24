package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_10828_스택 {

	public static class Stack{
		int[] arr;
		int top;
		public Stack(int size) {
			this.arr = new int[size];
			this.top = -1;
		}
		
		public void push(int n) {
			this.arr[++top] = n; 
		}
		
		public int pop() {
			int topnum = -1;
			if(top!=-1) topnum = this.arr[top--];
			return topnum;
		}
		
		public int size() {
			return top+1;
		}
		
		public int empty() {
			if(top==-1) return 1;
			else return 0;
		}
		
		public int top() {
			if(top!=-1) return this.arr[top];
			else return -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Stack stack = new Stack(T);
		
		while(T>0) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("push")) {
				stack.push(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("pop")) {
				System.out.println(stack.pop());
			}
			else if(s[0].equals("top")) {
				System.out.println(stack.top());
			}
			else if(s[0].equals("empty")) {
				System.out.println(stack.empty());
			}
			else {
				System.out.println(stack.size());
			}
			T--;
		}
		
		//Stack<Integer> stack = new Stack<Integer>();
//		while(T>0) {
//			String[] s = br.readLine().split(" ");
//			if(s[0].equals("push")) {
//				stack.push(Integer.parseInt(s[1]));
//			}
//			else if(s[0].equals("top")) {
//				if(!stack.isEmpty()) System.out.println(stack.peek());
//				else System.out.println(-1);
//			}
//			else if(s[0].equals("empty")) {
//				System.out.println(stack.isEmpty()? 1:0);
//			}
//			else if(s[0].equals("size")) {
//				System.out.println(stack.size());
//			}
//			else {
//				if(stack.size()==0) System.out.println(-1);
//				else System.out.println(stack.pop());
//			}
//			T--;
//		}

	}

}
