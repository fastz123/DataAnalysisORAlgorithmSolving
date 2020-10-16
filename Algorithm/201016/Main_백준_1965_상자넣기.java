package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_1965_상자넣기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_상자넣기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] s = br.readLine().split(" ");
		for(int z=0;z<n;z++) {
			arr[z] = Integer.parseInt(s[z]);
		}
		
		int[] res = new int[1001];//
		int max = Integer.MIN_VALUE;
		
		for(int z=0;z<n;z++) {
			int cur = arr[z];
			if(z==0) {
				res[cur]=1;
			}
			else {
				boolean f = false;
				int m = Integer.MIN_VALUE;
				for(int i=cur-1;i>=1;i--) { 
					if(res[i]!=0) {
//						res[cur] = res[i]+1;
						m = Math.max(m, res[i]);
						f=true;
//						break;
					}
				}
				if(!f) res[cur] = 1;
				else res[cur]=m+1;
				
			}
			max = Math.max(res[cur], max);
		}
		
		
		System.out.println(max);
	}

}
