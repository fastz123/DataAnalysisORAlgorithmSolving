package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_프로그래머스_방금그곡 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_방금그곡.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String m = br.readLine();
		
		int T = Integer.parseInt(br.readLine());
		String musicinfos[] = new String[T];
		
		for(int z=0;z<T;z++) {
			musicinfos[z] = br.readLine();
		}
		
		for(String cur : musicinfos) {
			String[] s = cur.split(",");
			int sthour = Integer.parseInt(s[0].substring(0,2));
			int stmin = Integer.parseInt(s[0].substring(3));
			int endhour = Integer.parseInt(s[1].substring(0,2));
			int endmin = Integer.parseInt(s[1].substring(3));
			
			String name = s[2];
			String akbo = s[3];
			int len = akbo.length();
			
			int hourgap = endhour-sthour;
			int mingap = endmin-stmin;
			
			int gap = (hourgap*60)+mingap;
			int t = 0;
			int time = 0;
			StringBuffer sb = new StringBuffer();
			while(true) {
				if(time==gap) break;
				char c = akbo.charAt(t%len);
				sb.append(c);
				if(akbo.charAt((t+1)%len)=='#') {
					sb.append(akbo.charAt((t+1)%len));
					t++;
				}
				t++;
				time++;
			}
			
			if(check(m,sb.toString())) {
				System.out.println(name);
				break;
			}
			
		}

	}

	private static boolean check(String m, String str) {
		int len = m.length();
		int strlen = str.length();
		for(int z=0;z<=str.length()-len;z++) {
			String cur = str.substring(z,z+len);
			if(str.charAt((z+len)%strlen)=='#') cur += '#';
			if(cur.equals(m)) return true;
		}
		return false;
	}

}
