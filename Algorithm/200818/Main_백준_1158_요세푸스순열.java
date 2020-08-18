package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_1158_요세푸스순열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int z=1;z<=N;z++) list.add(z);
		
		int idx = 0;
		int c = 0;
		if(K!=1) {
			c = 1;
		}
		else idx--;
		System.out.print("<");
		while(true) {
			if(list.size()==1) break;
			
			idx = (idx+1)%list.size();
			
			c++;
//			if(K!=1) {
				if(c==K) {
					int cur = list.get(idx);
					System.out.print(cur+", ");
					list.remove(idx);
					if(K!=1) c=1;
					else {
						c=0;
						idx--;
					}
				}
//			}
		}
		System.out.print(list.get(0));
		System.out.println(">");

	}

}
