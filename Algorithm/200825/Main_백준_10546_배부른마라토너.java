package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main_백준_10546_배부른마라토너 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int z=0;z<(T*2)-1;z++) {
			String s = br.readLine();
			if(map.containsKey(s)) map.replace(s, map.get(s)+1);
			else map.put(s, 1);
		}
		
		for(Entry<String, Integer> set : map.entrySet()) {
			if(set.getValue()%2==1) {
				System.out.println(set.getKey());
			}
		}
	}

}

