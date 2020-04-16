package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_백준_16637_괄호추가하기 {
	public static int max;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_괄추.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		String s = br.readLine();
		char[] arr = new char[len/2];
		int[] num = new int[(len/2)+1];
		for(int z=0;z<len;z++) {
			if(z%2==0) num[z/2]=s.charAt(z)-'0';
			else arr[z/2] = s.charAt(z);
		}

		max = Integer.MIN_VALUE;
		for(int z=0;z<(1<<len/2);z++) {
//			z=10;
			ArrayList<Integer> list = new ArrayList<>();
			for(int x=0;x<len/2;x++) {
				if((z&(1<<x))>0) {
					if(list.size()>0 && x-list.get(list.size()-1)!=1) {
						list.add(x);
					}
					else if(list.size()==0) list.add(x);
				}
			}
			
			ArrayList<Integer> slist = new ArrayList<>();
			int index=0;
			for(int idx=0;idx<list.size();idx++) {
				int i = list.get(idx);
				for(int n=index;n<i;n++) {
					slist.add(num[n]);
					slist.add((int)arr[n]);
					index++;
				}
				//
				slist.add(-6); //여는괄호
				slist.add(num[i]);
				slist.add((int)arr[i]);
				slist.add(num[i+1]);
				slist.add(-9); //닫는괄호
				if(i+1<len/2) slist.add((int)arr[i+1]);
				index+=2;
			}
			
			for(int n=index;n<len/2+1;n++) {
				slist.add(num[n]);
				if(n<len/2) slist.add((int)arr[n]);
				index++;
			}
//			System.out.println(); //43 + 42 * 45 - 47 /
			int cur = calculate(slist);
			max = Math.max(max, cur);
		}
		System.out.println(max);
		
	}

	private static int calculate(ArrayList<Integer> list) {
//		while(list.size()!=1)
		for(int z=0;z<list.size();z+=2) {
			int cur = list.get(z);
			if(cur==-6) {
				int buho = list.get(z+2);
				int n = list.get(z+1);
				int nn = list.get(z+3);
				if(buho==43) list.add(z, n+nn);
				else if(buho==42) list.add(z,n*nn);
				else if(buho==45) list.add(z,n-nn);
				else list.add(z,n/nn);
				
				for(int p=0;p<5;p++) list.remove(z+1);
			}
		}
		
		while(list.size()!=1) {
			int buho = list.get(1);
			int n = list.get(0);
			int nn = list.get(2);
			
			if(buho==43) list.add(0, n+nn);
			else if(buho==42) list.add(0,n*nn);
			else if(buho==45) list.add(0,n-nn);
			else list.add(0,n/nn);
			
			for(int p=0;p<3;p++) list.remove(1);
		}
		return list.get(0);
	}

}
