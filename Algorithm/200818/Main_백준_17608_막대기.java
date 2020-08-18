package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_17608_막대기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T-1];
		for(int z=0;z<T-1;z++) arr[z] = Integer.parseInt(br.readLine());
		
		int cur = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int z=T-2;z>=0;z--) {
			if(cur < arr[z]) {
				cnt++;
				cur=arr[z];
//				System.out.println(cur);
			}
		}
		
		System.out.println(cnt+1);

	}

}
