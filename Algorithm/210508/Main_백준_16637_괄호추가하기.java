package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_백준_16637_괄호추가하기 {
	static ArrayList<Character> blist;
	static ArrayList<Integer> nlist;
	static int max;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_괄호추가하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		String s = br.readLine();
		nlist = new ArrayList<>();
		blist = new ArrayList<>();
		for(int z=0;z<len;z++) {
			if(z%2==1) blist.add(s.charAt(z));
			else nlist.add(s.charAt(z)-'0');
		}
		
		max = Integer.MIN_VALUE;
		
case1:	for(long z=0;z<(1<<blist.size());z++) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int k=0;k<blist.size();k++) {
				if((z&(1<<k))>0) {
					if(list.size()>0) {
						if(!list.contains(k-1)) list.add(k);
						else continue case1;
					}
					else list.add(k);
				}
			}
			
			check(list);
		}
		
		System.out.println(max);
	}

	private static void check(ArrayList<Integer> list) {
		
		ArrayList<Character> templist = new ArrayList<>();
		ArrayList<Integer> tempNumList = new ArrayList<>();
		for(char c : blist) templist.add(c);
		for(int n : nlist) tempNumList.add(n);
		
		if(list.size()>0) {
			for(int z=list.size()-1;z>=0;z--) {
				int f = nlist.get(list.get(z));
				int e = nlist.get(list.get(z)+1);
				int idx = list.get(z);
				tempNumList.remove(idx);
				tempNumList.remove(idx);
				char buho = templist.get(list.get(z));
				int res = 0;
				if(buho == '+') {
					res = f+e;
				}
				else if(buho == '-') {
					res = f-e;
				}
				else if(buho == '*') {
					res = f*e;
				}
				else if(buho == '/') {
					if(e!=0) {
						res = f/e;
					}
					else return;
				}
				templist.remove(idx);
				tempNumList.add(list.get(z),res);
			}
		}
		
		while(tempNumList.size()>1) {
			char buho = templist.get(0);
			int f = tempNumList.get(0);
			int e = tempNumList.get(1);
			tempNumList.remove(0);
			tempNumList.remove(0);
			
			int res = 0;
			if(buho == '+') {
				res = f+e;
			}
			else if(buho == '-') {
				res = f-e;
			}
			else if(buho == '*') {
				res = f*e;
			}
			else if(buho == '/') {
				if(e!=0) {
					res = f/e;
				}
				else return;
			}
			templist.remove(0);
			tempNumList.add(0,res);
		}
		max = Math.max(max, tempNumList.get(0));
	}
}
