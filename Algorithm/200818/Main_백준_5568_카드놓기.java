package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main_백준_5568_카드놓기 {
	public static int n,k,b[];
	public static boolean v[];
	public static String[] arr;
	public static HashSet<Integer> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		arr = new String[n];
		for(int z=0;z<n;z++) {
			arr[z]=br.readLine();
		}

		v = new boolean[n];
		b = new int[k];
		set = new HashSet<>();
		comb(0);
		System.out.println(set.size());
	}

	private static void comb(int count) {
		if(count==k) {
//			System.out.println(Arrays.toString(b));
			String s = "";
			for(int p:b) s+=arr[p];
//			System.out.println(s);
			set.add(Integer.parseInt(s));
		}else {
			for(int i=0;i<n;i++) {
				if(!v[i]) {
					v[i]=true;
					b[count] = i;
					comb(count+1);
					v[i]=false;
				}
			}
		}
	}

}
