package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEXPERT_모의_홈방범서비스 {

	public static int size;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_홈방범서비스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			size = Integer.parseInt(s[0]);
			int cost = Integer.parseInt(s[1]);
			
			int[][] arr = new int[size][size];
			
			for(int z=0;z<size;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			max = Integer.MIN_VALUE;
			for(int k = 1;k<size*2;k++) {
				//k=3;
				for(int z=0;z<size;z++) {
					for(int x=0;x<size;x++) {
						//z=3;
						//x=3;
						int cur = check(arr,k,z,x,cost);
						if(cur>=1) {
							if(max<cur) max = cur;
						}
					}
				}
			}
			System.out.println("#"+(i+1)+" "+max);
		}

	}
	public static int max;
	private static int check(int[][] arr, int k,int i,int j,int cost) {
		int cnt=0;
		for(int p=i-(k-1);p<=i+(k-1);p++) {
			if(p<0 || p>=size) continue;
			for(int q=j-(k-1);q<=j+(k-1);q++) {
				if(q<0 || q>=size) continue;
				if(arr[p][q]==0) continue;
				else {
					if(Math.abs(i-p)+Math.abs(j-q)<=k-1) {
						cnt++;
					}
				}
			}
		}

		int area = (k*k) + ((k-1)*(k-1));
		if((cost*cnt)-area>=0) return cnt;
		else return -1;
	}

}
