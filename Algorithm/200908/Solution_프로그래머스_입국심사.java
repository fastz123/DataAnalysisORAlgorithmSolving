package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_프로그래머스_입국심사 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_입국심사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] times = new int[s.length];
		for(int z=0;z<times.length;z++) times[z] = Integer.parseInt(s[z]);
		
        long max = Long.MIN_VALUE;
        
        for(int z=0;z<times.length;z++){
            if(times[z] > max) max = times[z];
        }
        
        long left = 0;
        long right = max*n;
        min = Long.MAX_VALUE;
        
//        while(left<=right) {
//        	int cnt = 0;
//        	long mid = (left+right)/2;
//        	for(int time:times) {
//        		cnt+= mid/time;
//        	}
//        	
//        	if(n > cnt) {
//        		left = mid+1;
//        	}
//        	else {
//        		if(mid < answer) answer = mid;
//        		right = mid-1;
//        	}
//        }
        
        find(left,right,times,n);
        System.out.println(min);
	}
	public static long min;
	private static void find(long left, long right, int[] times, int n){
		if(left > right) return;
        long mid = (left+right)/2;
        
        int cnt = 0;
        for(int time:times){
            cnt += mid/time;
        }
        
        if(cnt < n){
            find(mid+1, right, times,n);
        }
        else{
        	if(min > mid) {
        		min = mid;
        	}
            find(left,mid-1,times,n);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -Integer.compare(o1, o2);
			}
		});
        
    }

}
