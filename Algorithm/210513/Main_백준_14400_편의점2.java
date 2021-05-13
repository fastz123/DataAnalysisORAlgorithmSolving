package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_백준_14400_편의점2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_편의점.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int xa = 0;
		int ya = 0;
		
		int[][] people = new int[N][2];
		for(int z=0;z<N;z++) {
			String s[] = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			people[z][0]=x;
			people[z][1]=y;
		}
		
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		xa = people[N/2][0];
		
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		ya = people[N/2][1];
		
		long sum = 0;
		for(int[] person : people) {
			sum += Math.abs(xa-person[0]) + Math.abs(ya-person[1]);
		}
		
		System.out.println(sum);
	}

}
