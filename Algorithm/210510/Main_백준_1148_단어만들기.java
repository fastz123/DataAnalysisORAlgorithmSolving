package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_1148_단어만들기 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_단어만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] TotChar = new int[200000][26];
		int idx=0;
		while(true) {
			String s = br.readLine();
			if(s.equals("-")) break;
			for(int z=0;z<s.length();z++) {
				TotChar[idx][s.charAt(z)-'A']++;
			}
			idx++;
		}
		
		while(true) {
			String s = br.readLine();
			int[] ans = new int[26];
			if(s.equals("#")) break;
			
			int[] map = new int[26];
			for(int z=0;z<9;z++) map[s.charAt(z)-'A']++;
			
case1:		for(int k=0;k<idx;k++) {
				for(int z=0;z<26;z++) {
					if(map[z] < TotChar[k][z]) continue case1;
				}
				for(int z=0;z<26;z++) {
					if(TotChar[k][z]>0) ans[z]++;
				}
				
			}
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i = 0 ; i<26;i++) {
				if(ans[i]!=0) min = Math.min(min, ans[i]);
				if(ans[i]==0 && map[i]>0) min = 0;
				max = Math.max(max, ans[i]);
			}
			
			StringBuffer minsb = new StringBuffer();
			StringBuffer maxsb = new StringBuffer();
			
			for(int i=0;i<26;i++) {
				if(min!=0 && min==ans[i]) {
					minsb.append((char) ('A'+i)  );
				}
				else if(min==0 && map[i]>0 && ans[i]==0) minsb.append((char)(i+'A'));
				
				if(max==ans[i] && map[i]>0) {
					maxsb.append( (char) ('A'+i) );
				}
			}
			
			System.out.println(minsb+" "+min+" "+maxsb+" "+max);
		}
	}

}
