package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution_프로그래머스_이중우선순위큐 {
	public static LinkedList<Integer> list;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_이중우선순위큐.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new LinkedList<Integer>();
		
		int T = Integer.parseInt(br.readLine());
		for(int z=0;z<T;z++) {
			String[] s = br.readLine().split(" ");
			if(s[0].charAt(0)=='I') {
				int cur = Integer.parseInt(s[1]);
				if(list.size()==0) list.offer(cur);
				else if(list.size()==1){
					if(cur < list.get(0)) list.add(0,cur);
					else list.add(1,cur);
				}
				else {
					int i = search(0,list.size()-1,cur);
					list.add(i,cur);
				}
			}
			else {
				if(list.size()>0) {
					int cur = Integer.parseInt(s[1]);
					if(cur==-1) {
						list.remove(0);
					}
					else {
						list.remove(list.size()-1);
					}
				}
			}
			System.out.println(list);
		}
		
		if(list.size()>0) System.out.println(list.get(0)+" "+list.get(list.size()-1));
		else System.out.println(0+" "+0);
		
	}

	public static int last;
	private static int search(int st, int end, int cur) {
		int first = list.get(st);
		int last = list.get(list.size()-1);
		if(cur <= first) return 0;
		if(cur >= last) return list.size();
		
		int mid = (st+end)/2;
		if(list.get(mid) == cur) return mid;
		else if(list.get(mid)<cur && cur<list.get(mid+1)) return mid+1;
		else {
			if(list.get(mid) > cur) {
				return search(st,mid,cur);
			}
			else {
				return search(mid,end,cur);
			}
		}
	}

}
