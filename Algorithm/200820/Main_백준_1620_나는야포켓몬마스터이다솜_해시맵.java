package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main_백준_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		

		HashMap<String, String> map = new HashMap<>();
		for(int z=0;z<N;z++) {
			String cur = br.readLine();
			map.put(Integer.toString(z+1), cur);
			map.put(cur,Integer.toString(z+1));
		}
		
		for(int z=0;z<M;z++) {
			String res = map.get(br.readLine());
			System.out.println(res);
		}
		
	}

}
