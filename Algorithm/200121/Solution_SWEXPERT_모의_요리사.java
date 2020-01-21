package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_모의_요리사 {
	public static int arr[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_요리사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int size = Integer.parseInt(br.readLine());
			arr = new int[size][size];
			
			for(int z=0;z<size;z++) {
				String[] s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(long z=0;z<(1<<size);z++) {
				ArrayList<Integer> list1 = new ArrayList<>();
				ArrayList<Integer> list2 = new ArrayList<>();
				for(int k=0;k<size;k++) {
					if((z&(1<<k))>0) list1.add(k);
					else list2.add(k);
				}
				
				if(list1.size()==list2.size()) {
					int sum1 = check(list1);
					int sum2 = check(list2);
					int abs = Math.abs(sum1-sum2);
					if(abs<min) min = abs;
				}
			}
			
			System.out.println("#"+(i+1)+" "+min);
			
		}

	}

	private static int check(ArrayList<Integer> list) {
		int sum = 0;
		for(int z=0;z<list.size();z++) {
			for(int x=0;x<list.size();x++) {
				if(z!=x) {
					sum+=arr[list.get(z)][list.get(x)];
				}
			}
		}
		return sum;
	}
}
