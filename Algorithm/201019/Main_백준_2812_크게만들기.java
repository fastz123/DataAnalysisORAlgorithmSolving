package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_2812_크게만들기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_크게만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int len = Integer.parseInt(s[0]);
		int del = Integer.parseInt(s[1]);
		int retlen = len-del;
		int Retlen = retlen;
		
		String number = br.readLine();
		StringBuffer sb = new StringBuffer();
		while(true) {
			if(sb.toString().length() == Retlen) break;
			if(retlen==0) break;
			if(len == retlen) {
				sb.append(number);
				break;
			}
			String front = number.substring(0, len-(retlen-1));
			
			int[] res = findmax(front);
			sb.append(res[0]);
			number = number.substring(res[1]+1);
			
			retlen--;
			len = number.length();
		}
		
		System.out.println(sb.toString());

	}

	private static int[] findmax(String front) {
		int idx=-1;
		int max = -1;
		for(int z=front.length()-1;z>=0;z--){
            int cur = front.charAt(z)-'0';
            if(max <= cur){
                max = cur;
                idx = z;
            }
        }
		
		return new int[] {max,idx};
	}

}
