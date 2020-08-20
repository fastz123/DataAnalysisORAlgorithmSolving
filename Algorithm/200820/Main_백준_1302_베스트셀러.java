package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main_백준_1302_베스트셀러 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int z=0;z<N;z++) {
			String s = br.readLine();
			if(map.containsKey(s)) {
				map.replace(s, map.get(s)+1);
			}
			else {
				map.put(s, 1);
			}
		}
		
		int max = 0;
		String maxP = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		for(Entry<String, Integer> set : map.entrySet()) {
			int cur = set.getValue();
			if(cur >= max) {
				if(cur==max) {
					if(maxP.compareTo(set.getKey()) > 0) {
						maxP = set.getKey();
					}
				}
				else {
					maxP = set.getKey();
				}
				max = cur;
			}
		}
		
		System.out.println(maxP);
		

	}

}
