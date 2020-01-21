package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEXPERT_모의_숫자만들기 {
	public static int size,arr[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_숫자만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			size = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int plus = Integer.parseInt(s[0]);
			int minus = Integer.parseInt(s[1]);
			int multi = Integer.parseInt(s[2]);
			int divide = Integer.parseInt(s[3]);
			
			arr = new int[size];
			s = br.readLine().split(" ");
			for(int z=0;z<size;z++)arr[z] = Integer.parseInt(s[z]);
			b = new int[size-1];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			perm(0,plus,minus,multi,divide);
			
			System.out.println("#"+(i+1)+" "+(max-min));
		}
	}
	public static int b[],max,min;
	private static void perm(int count,int plus,int minus,int mul,int div) {
		if(plus<0 || minus<0||mul<0||div<0) return;
		if(count==size-1) {
			int cur = check(arr,b);
			if(cur>max) max = cur;
			if(cur<min) min = cur;
		}
		else {
			for(int i=0;i<4;i++) {
				b[count]=i;
				if(i==0) perm(count+1,plus-1,minus,mul,div);
				else if(i==1) perm(count+1,plus,minus-1,mul,div);
				else if(i==2) perm(count+1,plus,minus,mul-1,div);
				else perm(count+1,plus,minus,mul,div-1);
			}
		}
	}
	private static int check(int[] arr, int[] b) {
		int res=0;
		for(int z=0;z<size-1;z++) {
			if(b[z]==0) {//더하기
				if(z==0) res+=(arr[z]+arr[z+1]);
				else res+=arr[z+1];
			}
			else if(b[z]==1) {//빼기
				if(z==0) res+=(arr[z]-arr[z+1]);
				else res-=arr[z+1];
			}
			else if(b[z]==2) {//곱
				if(z==0) res+=(arr[z]*arr[z+1]);
				else res*=arr[z+1];
			}
			else {//나누
				if(z==0) res+=(arr[z]/arr[z+1]);
				else res/=arr[z+1];
			}
		}
		return res;
	}
}
