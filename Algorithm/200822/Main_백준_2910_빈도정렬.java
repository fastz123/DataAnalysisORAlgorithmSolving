package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main_백준_2910_빈도정렬 {
	public static class C{
		int N;
		int cnt;
		int when;
		public C(int N, int cnt, int when) {
			this.N = N;
			this.cnt = cnt;
			this.when = when;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		
		ArrayList<C> list = new ArrayList();
		HashMap<Integer, Integer> map = new HashMap();
		HashMap<Integer, Integer> when = new HashMap();
		for(int z=0;z<n;z++) {
			int cur = Integer.parseInt(s[z]);
			if(!map.containsKey(cur)) {
				map.put(cur, 1);
				when.put(cur, z);
			}
			else {
				map.replace(cur, map.get(cur)+1);
			}
		}
		
		for(Entry<Integer, Integer> set: map.entrySet()) {
			int N = set.getKey();
			int cnt = set.getValue();
			
			C c = new C(N,cnt, when.get(N));
			list.add(c);
		}
		
		Collections.sort(list,new Comparator<C>() {

			@Override
			public int compare(C o1, C o2) {
				if(o1.cnt != o2.cnt) return -Integer.compare(o1.cnt, o2.cnt);
				else return Integer.compare(o1.when, o2.when);
			}
		});
		
		for(C cur : list) {
			for(int z=0;z<cur.cnt;z++) {
				System.out.print(cur.N+" ");
			}
		}

	}

}
