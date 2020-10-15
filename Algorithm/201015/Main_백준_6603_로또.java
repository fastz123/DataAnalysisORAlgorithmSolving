package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main_백준_6603_로또 {
	public static int n, arr[],res[];
	public static boolean v[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_로또.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("0")) break;
			
			n = Integer.parseInt(s[0]);
			arr = new int[n];
			for(int z=0;z<n;z++) arr[z] = Integer.parseInt(s[z+1]);
			
			res = new int[6];
			v = new boolean[n];
			comb(0,0);
			System.out.println();
		}
	}

	private static void comb(int count, int start) {
		if(count==6) {
			for(int i : res) System.out.print(i+" ");
			System.out.println();
		}
		else {
			for(int i=start;i<n;i++) {
				if(!v[i]) {
					v[i]=true;
					res[count]=arr[i];
					comb(count+1,i);
					v[i]=false;
				}
			}
		}
	}

}
