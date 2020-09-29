package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2891_카약과강풍 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_카약과강풍.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int S = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		
		int[] arr = new int[N];
		for(int z=0;z<N;z++) arr[z]=1;
		
		s = br.readLine().split(" ");
		for(int z=0;z<S;z++) {
			arr[Integer.parseInt(s[z])-1]--;
		}
		
		s = br.readLine().split(" ");
		for(int z=0;z<R;z++) {
			arr[Integer.parseInt(s[z])-1]++;
		}
		
		for(int z=0;z<N;z++) {
			if(arr[z]==0) {
				if(z-1>0 && arr[z-1]==2) {
					arr[z]++;
					arr[z-1]--;
				}
				else if(z+1<N && arr[z+1]==2) {
					arr[z]++;
					arr[z+1]--;
				}
			}
		}
		
		int cnt = 0;
		for(int z=0;z<N;z++) {
			if(arr[z]==0) cnt++;
		}
		System.out.println(cnt);
		
	}

}
