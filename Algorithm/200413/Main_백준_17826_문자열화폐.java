package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_백준_17826_문자열화폐 {
	public static int len,val;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_문자열화폐.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		len = Integer.parseInt(s[0]);
		val = Integer.parseInt(s[1]);
		ArrayList<Character> list = new ArrayList<>();
//		for(int z=0;z<len;z++) list.add('A');
		if(check(list)==val) {
			printres(list);
			return;
		}
		else {
			dfs(0,list);
			if(!f) System.out.println(-1);
		}
	}

	public static boolean f;
	private static void dfs(int i, ArrayList<Character> list) {
		if(i>=len) {
			printres(list);
			if(check(list)==val) {
				f=true;
				printres(list);
			}
			return;
		}
		
		//1~26
		for(int z=0;z<26;z++) {
			list.add(i, (char)('A'+z));
			dfs(i+1,list);
			list.remove(i);
		}
		
	}
	private static void printres(ArrayList<Character> list) {
		for(Character c:list) System.out.print(c+" ");
		System.out.println();
	}
	private static int check(ArrayList<Character> list) {
		int sum = 0;
		for(int z=0;z<list.size();z++) {
			sum+=(list.get(z)-'A'+1);
		}
		return sum;
	}

}
