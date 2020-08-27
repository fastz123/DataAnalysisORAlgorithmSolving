package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_백준_14248_점프점프 {
	public static boolean v[];
	public static int size, arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		size = Integer.parseInt(br.readLine());
		arr = new int[size];
		String[] s = br.readLine().split(" ");
		for(int z=0;z<size;z++) {
			arr[z] = Integer.parseInt(s[z]);
		}
		
		v = new boolean[size];
		int start = Integer.parseInt(br.readLine())-1;
		v[start]=true;
		dfs(start);

		System.out.println(cnt+1);
	}
	public static int cnt;
	private static void dfs(int cur) {
		int num = arr[cur];
		if(cur-num>=0)
			//앞으로
			if(!v[cur-num]) {
				v[cur-num]=true;
				cnt++;
				dfs(cur-num);
			}
		if(cur+num<size) {
			//뒤로
			if(!v[cur+num]) {
				v[cur+num]=true;
				cnt++;
				dfs(cur+num);
			}
		}
	}

}
