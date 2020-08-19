package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_1021_회전하는큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		int[] arr = new int[M];
		for(int z=0;z<M;z++) arr[z] = Integer.parseInt(s[z]);
		
		LinkedList<Integer> list = new LinkedList();
		
		for(int z=1;z<=N;z++) list.offer(z);
		
		int cnt = 0;
		int idx = 0;
		while(true) {
			
			if(idx == M) break;
			
			if(list.peek() == arr[idx]) {
				list.poll();
				idx++;
			}
			
			else {
				int i = list.indexOf(arr[idx]);
				int left = Math.abs(0-i);
				int right = i-list.size();
				int r = Math.abs(i-list.size());
				if(left >= r) {
					Collections.rotate(list, -right);
					cnt+=r;
				}
				else {
					Collections.rotate(list, -left);
					cnt+=left;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
