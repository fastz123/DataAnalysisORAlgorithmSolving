package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_10845_큐 {
	public static class Queue{
		int front;
		int back;
		int[] arr;
		public Queue(int N) {
			this.arr = new int[N];
			this.front = 0;
			this.back = 0;
		}
		public void push(int n) {
			if(front == (back+1)%this.arr.length) {
				System.out.println("q is full error!!!!");
			}
			this.back = (this.back+1) % this.arr.length;
			this.arr[this.back]=n;
		}
		
		public int pop() {
			if(this.back == this.front) {
				return -1;
			}
			else {
//				int res = this.arr[(this.front++)%this.arr.length];
				this.front = this.front+1;
				this.front %= this.arr.length;
				return this.arr[this.front];
			}
		}
		
		public int size() {
			if(front <= back) {
				return back-front;
			}
			else {
				return this.arr.length-front + back;
			}
		}
		
		public int empty() {
			if(front==back) return 1;
			else return 0;
		}
		public int front() {
			if(front==back) {
				return -1;
			}
			else {
				return this.arr[front+1];
			}
		}
		public int back() {
			if(front==back) {
				return -1;
			}
			else {
				return this.arr[back];
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		Queue q = new Queue(T);
		while(T>0) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("push")) {
				q.push(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("pop")) {
				System.out.println(q.pop());
			}
			else if(s[0].equals("size")) {
				System.out.println(q.size());
			}
			else if(s[0].equals("empty")) {
				System.out.println(q.empty());
			}
			else if(s[0].equals("front")) {
				System.out.println(q.front());
			}
			else {
				System.out.println(q.back());
			}
			T--;
		}

	}

}
