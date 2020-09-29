package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_16435_스네이크버드 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_스네이크버드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int[] arr = new int[Integer.parseInt(s[0])];
		int len = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		
		for(int z=0;z<arr.length;z++) {
			arr[z] = Integer.parseInt(s[z]);
		}
		
		Arrays.sort(arr);
		
		for(int z=0;z<arr.length;z++) {
			if(len < arr[z]) break;
			len++;
		}
		
		System.out.println(len);
		

	}

}
