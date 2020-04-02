package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_18238_ZOAC2 {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_zoac2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s=br.readLine();
		int curidx=0;
		int time = 0;
		for(int z=0;z<s.length();z++) {
			int lcuridx = curidx;
			int rcuridx = curidx;
			char cur = s.charAt(z);
			int idx = cur-'A';
			int r = check(rcuridx,'r',idx);
			int l = check(lcuridx,'l',idx);
			int small = l<r? l:r;
			time += small;
			curidx = idx;
		}
		System.out.println(time);
	}

	private static int check(int curidx, char c, int idx) {
		int time = 0;
		if(c=='r') {
			while(true) {
				if(curidx!=idx) {
					curidx++;
					time++;
					if(curidx>25) curidx=0;
				}
				else break;
			}
		}
		else {
			while(true) {
				if(curidx!=idx) {
					curidx--;
					time++;
					if(curidx<0) curidx=25;
				}
				else break;
			}
		}
		return time;
	}

}
