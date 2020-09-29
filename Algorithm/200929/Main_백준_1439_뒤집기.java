package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_1439_뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int mz = 0;
		int mo = 0;
		for(int z=0;z<s.length();z++) {
			if(s.charAt(z)=='0') {
				int cur = z;
				while(true) {
					cur++;
					if(cur == s.length()) break;
					if(s.charAt(cur)!='0') break;
				}
				mo += 1;
				z=cur-1;
			}
			else {
				int cur =z;
				while(true) {
					cur++;
					if(cur == s.length()) break;
					if(s.charAt(cur)!='1') break;
				}
				mz += 1;
				z=cur-1;
			}
		}
		
		System.out.println(mo>mz? mz:mo);
		
	}

}
