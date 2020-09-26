package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_프로그래머스_N으로표현 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_N으로표현.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s= br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int number = Integer.parseInt(s[1]);
		ArrayList<Integer> list[] = new ArrayList[8];
		int min = Integer.MAX_VALUE;
		for(int z=0;z<8;z++) list[z] = new ArrayList<Integer>();
		for(int i=1;i<=8;i++) {
			int curnum = 0;
			for(int k=0;k<i;k++) {
				curnum = curnum*10 + N;
			}
			if(curnum==number) min=i;
			list[i-1].add(curnum);
		}
		
		
case1:	for(int z=1;z<8;z++) {
			ArrayList<Integer> l = list[z-1];
			for(int cur : l) {
				int cn = cur+N;
				if(cn==number) {
					min = Math.min(min, z+1);
					list[z].add(cn);
					break case1;
				}
				list[z].add(cn);
				cn = cur-N;
				if(cn==number) {
					min = Math.min(min, z+1);
					list[z].add(cn);
					break case1;
				}
				list[z].add(cn);
				cn = cur*N;
				if(cn==number) {
					min = Math.min(min, z+1);
					list[z].add(cn);
					break case1;
				}
				list[z].add(cn);
				cn = cur/N;
				if(cn==number) {
					min = Math.min(min, z+1);
					list[z].add(cn);
					break case1;
				}
				list[z].add(cn);
			}
		}
		
case2:	for(int z=0;z<8;z++) {
			ArrayList<Integer> l1 = list[z];
			for(int k=0;k<8;k++) {
				ArrayList<Integer> l2 = list[k];
				int size = z+1+k+1;
				if(size<=8 && size < min) {
					int l1size = l1.size();
					int l2size = l2.size();
					for(int p=0;p<l1size;p++) {
						for(int q = 0 ;q<l2size;q++) {
							int cn = l1.get(p)+l2.get(q);
							if(cn==number) {
								if(min > size) {
									min=size;
								}
							}
							if(!list[size-1].contains(cn)) list[size-1].add(cn);
							cn = l1.get(p)-l2.get(q);
							if(cn==number) {
								if(min > size) {
									min=size;
								}
							}
							if(!list[size-1].contains(cn)) list[size-1].add(cn);
							cn = l1.get(p)*l2.get(q);
							if(cn==number) {
								if(min > size) {
									min=size;
								}
							}
							if(!list[size-1].contains(cn)) list[size-1].add(cn);
							if(l2.get(q)!=0) {
								cn = l1.get(p)/l2.get(q);
								if(cn==number) {
									if(min > size) {
										min=size;
									}
								}
								if(!list[size-1].contains(cn)) list[size-1].add(cn);
							}
						}
					}
				}
				
			}
		}
		
//		for(ArrayList<Integer> l : list) System.out.println(l);
		System.out.println(min);
	}
	
	
}
