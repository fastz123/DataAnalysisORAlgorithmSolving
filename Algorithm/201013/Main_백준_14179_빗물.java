package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_14179_빗물 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_빗물.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int H = Integer.parseInt(s[0]);
		int W = Integer.parseInt(s[1]);
		
		int[] arr = new int[W];
		s = br.readLine().split(" ");
		int max = Integer.MIN_VALUE;
		int maxidx = -1;
		for(int z=0;z<W;z++) {
			arr[z] = Integer.parseInt(s[z]);
			if(arr[z] > max) {
				max = arr[z];
				maxidx = z;
			}
		}
		
		int sum = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(arr[0]);
		for(int left=1;left<=maxidx;left++) {
			if(q.peek() > arr[left]) q.offer(arr[left]);
			else {
				int maxh = q.poll();
				while(!q.isEmpty()) sum += maxh-q.poll();
				q.offer(arr[left]);
			}
		}
		
		q = new LinkedList<Integer>();
		q.offer(arr[W-1]);
		for(int right=W-2;right>=maxidx;right--) {
			if(q.peek() > arr[right]) q.offer(arr[right]);
			else {
				int maxh = q.poll();
				while(!q.isEmpty()) sum += maxh - q.poll();
				q.offer(arr[right]);
			}
		}
		
		System.out.println(sum);
		
		
		

	}

}
