package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_백준_1343_폴리오미노 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> dotlist = new ArrayList<>();
		
		boolean f= true;
case1:	for(int z=0;z<s.length();z++) {
			char cur = s.charAt(z);
			if(cur=='X') {
				int cx = z;
				while(true) {
					cx++;
					if(cx == s.length()) break;
					if(s.charAt(cx)=='.') break;
				}
				int len = cx-z;
				if(len%2!=0) {
					f = false;
					break case1;
				}
				else {
					if(len%4==0) {
						for(int i=0;i<len/4;i++) list.add("AAAA");
					}
					else {
						for(int i=0;i<len/4;i++) list.add("AAAA");
						len%=4;
						for(int i=0;i<len/2;i++) list.add("BB");
					}
				}
				z=cx-1;
			}
			else {
				list.add(".");
			}
		}

		if(f) {
//			Collections.sort(list,new Comparator<String>() {
//				
//				@Override
//				public int compare(String o1, String o2) {
//					if(o1.equals(".") || o2.equals(".")) return 0;
//					return o1.compareTo(o2);
//				}
//			});
			
			StringBuffer sb = new StringBuffer();
			for(String cur : list) sb.append(cur);
			System.out.println(sb.toString());
		}
		else {
			System.out.println(-1);
		}
	}

}
