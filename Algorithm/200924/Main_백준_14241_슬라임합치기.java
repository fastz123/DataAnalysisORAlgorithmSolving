package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main_백준_14241_슬라임합치기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_슬라임합치기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		LinkedList<Integer> list = new LinkedList<>();
		for(int z=0;z<N;z++) list.add( Integer.parseInt(s[z]));
		Collections.sort(list);
		int score = 0;
		for(int z=list.size()-1;z>=1;z--) {
			int n1 = list.get(z);
			int n2 = list.get(z-1);
			list.remove(z);
			list.remove(z-1);
			list.add(n1+n2);
			score+=n1*n2;
		}
		
		System.out.println(score);
	}
	

}
