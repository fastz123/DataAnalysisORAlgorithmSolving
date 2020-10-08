package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_백준_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_잃어버린괄호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		LinkedList<Character> buho = new LinkedList();
		LinkedList<Integer> nlist = new LinkedList<Integer>();
		
		StringBuffer sb = new StringBuffer();
		for(int z=0;z<s.length();z++) {
			char cur = s.charAt(z);
			if(cur!='+' && cur!='-') {
				sb.append(cur);
			}
			else {
				nlist.add(Integer.parseInt(sb.toString()));
				sb = new StringBuffer();
				buho.add(cur);
			}
		}
		
		nlist.add(Integer.parseInt(sb.toString()));
		
		
		for(int z=buho.size()-1;z>=0;z--) {
			if(buho.get(z)=='+') {
				int n1 = nlist.get(z);
				int n2 = nlist.get(z+1);
				int sum = n1+n2;
				
				for(int i=0;i<2;i++) nlist.remove(z);
				nlist.add(z, sum);
				
				buho.remove(z);
			}
		}
		
		int sum = nlist.get(0);
		
		for(int z=1;z<nlist.size();z++) {
			sum -= nlist.get(z);
		}
		
		System.out.println(sum);
		
		

	}

}
