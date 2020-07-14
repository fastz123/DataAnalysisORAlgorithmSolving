package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_18245_이상한나라의암호 {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_이상한나라의암호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int z=1;
		while(true) {
			String res="";
			String s = br.readLine();
			if(s.equals("Was it a cat I saw?")) break;
			for(int k=0;k<s.length();k+=(z+1)) {
				res+=s.charAt(k);
			}
			System.out.println(res);
			z++;
		}

	}

}
