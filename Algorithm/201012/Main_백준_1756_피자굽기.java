package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_백준_1756_피자굽기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_피자굽기.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int depth = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		int[] arr = new int[depth];
		s = br.readLine().split(" ");
		int min = Integer.MAX_VALUE;
		for(int z=0;z<depth;z++) {
			int cur = Integer.parseInt(s[z]);
			min = Math.min(cur, min);
			arr[z]=min;
		}

		
		s = br.readLine().split(" ");
		int last = depth;
		int idx = 0;
		boolean f = false;
		for(int i=depth-1;i>=0;i--) {
			if(Integer.parseInt(s[idx]) > arr[i]) continue;
			else idx++;
			if(idx==N) {
				if(!f) f=true;
				last=i;
				break;
			}
		}
		
		System.out.println(f? last+1:0);
		
	}
}
