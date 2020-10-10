package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2138_전구와스위치 {
	public static int n;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_전구와스위치.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int[] start = new int[n];
		for(int z=0;z<n;z++) start[z] = s.charAt(z)-'0';
		s = br.readLine();
		int[] target = new int[n];
		for(int z=0;z<n;z++) target[z] = s.charAt(z)-'0';
		
		min = Integer.MAX_VALUE;
		//0번 안클릭
		check(start,target,1,0);
		//클릭
		click(start,target,0);
		check(start,target,1,1);
		
		System.out.println(min==Integer.MAX_VALUE? -1:min);
	}

	public static int min;
	private static void check(int[] start, int[] target, int i, int cnt) {
		if(min < cnt) return;
		if(i==n) {
			if(start[i-1]==target[i-1])	min = Math.min(min, cnt);
			return;
		}
		
		if(target[i-1]==start[i-1]) check(start,target,i+1,cnt);
		else {
			click(start,target,i);
			check(start,target,i+1,cnt+1);
			click(start,target,i);
		}
	}

	private static void click(int[] start, int[] target, int i) {
		if(i-1>=0 && start[i-1]==0) start[i-1]=1;
		else if(i-1>=0 && start[i-1]==1) start[i-1]=0;
		
		if(start[i]==0) start[i]=1;
		else start[i]=0;
		
		if(i+1<n && start[i+1]==0) start[i+1]=1;
		else if(i+1<n && start[i+1]==1) start[i+1]=0;
	}

}
