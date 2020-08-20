package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_백준_2164_카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int z=1;z<=T;z++) list.offer(z);
		
		while(list.size()>1) {
			list.poll();
			int cur = list.poll();
			list.offer(cur);
		}
		
		System.out.println(list.get(0));

	}

}

