package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_백준_10866_덱 {

	public static class Deque{
		int[] arr;
		int front;
		int back;
		int size;
		public Deque(int size) {
			this.arr = new int[size];
			this.front=0;
			this.back=0;
			this.size=0;
		}
		public void push_front(int n) {
			for(int z = back;z>=front;z--) {
				this.arr[z+1] = this.arr[z];
			}
			this.arr[front+1]=n;
			this.back++;
		}
		public void push_back(int n) {
			this.arr[++back]=n;
		}
		public int pop_front() {
			if(front==back) {
				return -1;
			}
			else {
				front++;
				return this.arr[front];
			}
		}
		public int pop_back() {
			if(front==back) {
				return -1;
			}
			else {
				return this.arr[back--];
			}
		}
		public int size() {
			return back-front;
		}
		public int empty() {
			return front==back? 1:0;
		}
		public int front() {
			return front==back? -1:this.arr[1+front];
		}
		public int back() {
			return front==back? -1:this.arr[back];
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		Deque deq = new Deque(T);
		while(T>0) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("push_front")) {
				deq.push_front(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("push_back")) {
				deq.push_back(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("pop_front")) {
//				System.out.println(deq.pop_front());
				bw.write(deq.pop_front()+"\n");
			}
			else if(s[0].equals("pop_back")) {
//				System.out.println(deq.pop_back());
				bw.write(deq.pop_back()+"\n");
			}else if(s[0].equals("size")) {
//				System.out.println(deq.size());
				bw.write(deq.size()+"\n");
			}
			else if(s[0].equals("empty")) {
//				System.out.println(deq.empty());
				bw.write(deq.empty()+"\n");
			}
			else if(s[0].equals("front")) {
//				System.out.println(deq.front());
				bw.write(deq.front()+"\n");
			}
			else {
//				System.out.println(deq.back());
				bw.write(deq.back()+"\n");
			}
			T--;
		}
		
		bw.flush();
		bw.close();

	}

}
