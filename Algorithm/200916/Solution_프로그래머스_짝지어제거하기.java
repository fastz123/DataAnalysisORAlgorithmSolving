package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_프로그래머스_짝지어제거하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		StringBuffer sb = new StringBuffer();
		sb.append(s);
		
		while(sb.length()!=0) {
			boolean f = true;
			for(int z=0;z<sb.length()-1;z++) {
				char cur = sb.charAt(z);
				char next = sb.charAt(z+1);
				if(cur == next) {
					sb.delete(z, z+2);
					f=false;
					break;
				}
			}
			if(f==true) break;
		}
		
		System.out.println(sb.length()==0? 1:0);
		

	}

}
