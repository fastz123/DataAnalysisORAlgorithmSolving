package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Solution_프로그래머스_여행경로 {
	public static boolean v[];
	public static LinkedList<String> list;
	public static String route;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_여행경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String[][] tickets = new String[T][2];
		for(int z=0;z<T;z++) {
			String[] cur = br.readLine().split(",");
			tickets[z][0] = cur[0];
			tickets[z][1] = cur[1];
		}
		
		list = new LinkedList<String>();
		v = new boolean[tickets.length];
		route = "";
		int i = 0;
		for(String[] s : tickets) {
			String st = s[0];
			String end = s[1];
			
			if(st.equals("ICN")) {
				v[i]=true;
				dfs(tickets, end, 1,st+">"+end);
				v[i]=false;
			}
			i++;
		}
        
		Collections.sort(list);
		String[] subs = list.get(0).split(">");
		System.out.println(Arrays.toString(subs));
	}
	
	private static void dfs(String[][] tickets, String end, int count, String cur) {
		
		
		if(count==tickets.length) {
			list.add(cur);
			return;
		}
		else {
			for(int i=0;i<tickets.length;i++) {
				String st = tickets[i][0];
				String destination = tickets[i][1];
				
				if(!v[i] && st.equals(end)) {
					v[i]=true;
					dfs(tickets,destination, count+1,cur+">"+destination);
					v[i]=false;
				}
			}
		}
	}

}
