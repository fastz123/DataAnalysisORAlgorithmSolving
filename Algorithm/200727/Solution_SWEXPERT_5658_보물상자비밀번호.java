package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_SWEXPERT_5658_보물상자비밀번호 {
	public static ArrayList<String> curlists;
	public static int slen;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			
			ArrayList<Character> list = new ArrayList<>();
			
			String cur = br.readLine();
			int len = cur.length();
			for(int z=0;z<cur.length();z++) list.add(cur.charAt(z));
			
			slen = len/4;
			curlists = new ArrayList();
			
			for(int z=0;z<slen;z++)	{
				draw(list);
				Collections.rotate(list, 1);
			}
			
			Collections.sort(curlists, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return -o1.compareTo(o2);
				}
			});
			
			String res = curlists.get(B-1);
			
//			System.out.println(res);
			
			int ans = Integer.parseInt(res, 16);
			
			System.out.println("#"+i+" "+ans);
			
		}
	}
	private static void draw(ArrayList<Character> list) {
		String c = "";
		for(int z=0;z<list.size();z++) {
			if(z!=0 && z%slen==0) {
				if(!curlists.contains(c)) curlists.add(c);
				c="";
			}
			c+=list.get(z);
		}
		if(!curlists.contains(c)) curlists.add(c);
	}

}
