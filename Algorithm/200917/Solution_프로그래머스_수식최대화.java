package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Solution_프로그래머스_수식최대화 {
	public static boolean v[];
	public static char b[];
	public static int len;
	public static ArrayList<Character> clist, buho;
	public static ArrayList<Integer> nlist;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_수식최대화.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		nlist = new ArrayList();
		buho = new ArrayList<Character>();
		StringBuffer sb = new StringBuffer();
		for(int z=0;z<s.length();z++) {
			char cur = s.charAt(z);
			if(cur == '-' || cur=='+' || cur=='*') {
				buho.add(cur);
				nlist.add(Integer.parseInt(sb.toString()));
				sb = new StringBuffer();
			}
			else {
				sb.append(cur);
			}
		}
		nlist.add(Integer.parseInt(sb.toString()));
		
		HashSet<Character> buhoset = new HashSet<>(buho);
		clist = new ArrayList<>(buhoset);
		len = clist.size();
		v = new boolean[len];
		b = new char[len];
		max = Long.MIN_VALUE;
		perm(0);
		
		System.out.println(max);
	}
	
	public static Long max;
	private static void perm(int count) {
		if(count==len) {
			ArrayList<Long> templist = new ArrayList<>();
			ArrayList<Character> tempbuholist = new ArrayList<>();
			for(int n : nlist) templist.add((long)n);
			for(char c : buho) tempbuholist.add(c);
			
			for(char c : b) {
				calculate(c, templist, tempbuholist);
			}
			
			long res = Math.abs(templist.get(0));
			
			max = Math.max(max, res);
			
			return;
		}
		else {
			for(int i=0;i<len;i++) {
				if(!v[i]) {
					v[i]=true;
					b[count] = clist.get(i);
					perm(count+1);
					v[i]=false;
				}
			}
		}
	}
	private static void calculate(char c, ArrayList<Long> templist, ArrayList<Character> tempbuholist) {
		for(int z=0;z<tempbuholist.size();z++) {
			if(tempbuholist.get(z) == c) {
				int idx = z;
				long front = templist.get(idx);
				long back = templist.get(idx+1);
				long aftnum = 0;
				if(c == '+') {
					aftnum = front+back;
				}
				else if(c == '-') {
					aftnum = front-back;
				}
				else {
					aftnum = front*back;
				}
				
				templist.add(idx,aftnum);
				for(int p=0;p<2;p++) templist.remove(idx+1);
				tempbuholist.remove(idx);
				z=z-1;
			}
		}
	}
	

}
