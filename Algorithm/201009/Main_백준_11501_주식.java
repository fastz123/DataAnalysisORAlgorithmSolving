package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main_백준_11501_주식 {
	public static class Node{
		int num;
		int idx;
		public Node(int num, int idx) {
			this.num=num;
			this.idx=idx;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_주식.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			String[] s= br.readLine().split(" ");
//			PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

//				@Override
//				public int compare(Node o1, Node o2) {
//					if(o1.num!=o2.num) return -Integer.compare(o1.num, o2.num);
//					else return Integer.compare(o1.idx, o2.idx);
//				}
//			});
			for(int z=0;z<N;z++) {
				int num = Integer.parseInt(s[z]);
				arr[z] = num;
//				pq.add(new Node(num,z));
			}
			
			int idx = N-1;
			int max = arr[idx];
			long sum = 0;
			while(true) {
				idx--;
				if(idx<0) break;
				
				int cur = arr[idx];
				if(max < cur) {
					max = cur;
				}
				else if(max > cur) {
					sum += max-cur;
				}
				
			}
			
			System.out.println(sum);
			T--;
		}

	}

}
