package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_3061_사다리 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_사다리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] s= br.readLine().split(" ");
			for(int i=0;i<n;i++) arr[i] = Integer.parseInt(s[i]);
			
			int cnt = 0;
			for(int i=0;i<n;i++) {
				for(int j=i;j<n;j++) {
					if(arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
			T--;
		}

	}

}
