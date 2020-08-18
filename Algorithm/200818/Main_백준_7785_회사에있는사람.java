package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main_백준_7785_회사에있는사람 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String,String> map = new HashMap<>();
		for(int z=0;z<T;z++) {
			String[] s = br.readLine().split(" ");
			String name = s[0];
			String doing = s[1];
			
			if(!map.containsKey(name)) {
				map.put(name, doing);
			}
			else if(map.get(name).equals("leave")) {
				map.replace(name, "enter");
			}
			else if(map.get(name).equals("enter")){
				map.replace(name, "leave");
			}
			
//			if(!list.contains(name) && doing.equals("enter")) {
//				list.add(name);
//			}
//			else if(list.contains(name) && doing.equals("leave")) {
//				for(int idx=0;idx<list.size();idx++) {
//					if(list.get(idx).equals(name)) {
//						list.remove(idx);
//					}
//				}
//			}
		}
		
		for(Entry<String, String> set : map.entrySet()) {
			if(set.getValue().equals("enter")){
				list.add(set.getKey());
			}
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		});
		
		for(String name:list) System.out.println(name);
	}

}
