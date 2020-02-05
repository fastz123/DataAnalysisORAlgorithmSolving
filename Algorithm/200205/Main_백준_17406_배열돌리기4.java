package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_17406_배열돌리기4 {
	public static class xyz{
		int x;
		int y;
		int z;
		public xyz(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static ArrayList<xyz> list;
	public static boolean v[];
	public static int arr[][],listsize,res[],copy[][],x,y;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_배열돌리기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s= br.readLine().split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		int time = Integer.parseInt(s[2]);
		
		arr = new int[x][y];
		copy = new int[x][y];
		for(int z=0;z<x;z++) {
			s = br.readLine().split(" ");
			for(int a=0;a<y;a++) {
				arr[z][a] = Integer.parseInt(s[a]);
				copy[z][a] = arr[z][a];
			}
		}
		
		list = new ArrayList<>();
		for(int z=0;z<time;z++) {
			s = br.readLine().split(" ");
			list.add(new xyz(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2])));
		}
		
		listsize = list.size();
		
		min = Integer.MAX_VALUE;
		res = new int[listsize];
		v = new boolean[list.size()];
		perm(0,res);
		System.out.println(min);
	}

	private static void perm(int count,int[] res) {
		if(count==listsize) {
			f=false;
			turn(res,0,arr);
			copy(copy, arr);
		}
		else {
			for(int i=0;i<listsize;i++) {
				if(!v[i]) {
					v[i]=true;
					res[count]=i;
					perm(count+1,res);
					v[i]=false;
				}
			}
		}
	}
	public static int min;
	public static boolean f;
	private static void turn(int[] res, int idx, int[][] arr) {
		if(res.length<=idx) {
			int curmin = check(arr);
			if(min > curmin) min = curmin;
			f=true;
			return;
		}
		
		int r = list.get(res[idx]).x-1;
		int c = list.get(res[idx]).y-1;
		int s = list.get(res[idx]).z;
		
		
		int[][] restore = new int[x][y];
		copy(arr,restore);
		
		int cc=0;
		while(true) {
			if(s-cc==0) break;

			int stx = r-s+cc;
			int sty = c-s+cc;
			int endx = r+s-cc;
			int endy = c+s-cc;
			
			int size = ((s-cc) *2) +1;
			for(int k=0;k<size-1;k++) {
				for(int z=0;z<4;z++) {
				//우로
					arr[stx][sty+1+k] = restore[stx][sty+k]; 
				//하로
					arr[stx+1+k][sty+size-1] = restore[stx+k][sty+size-1];
				//좌로
					arr[endx][endy-1-k] = restore[endx][endy-k];
				//상으로
					arr[endx-1-k][endy-size+1] = restore[endx-k][endy-size+1];
				}
			}
			
			cc++;
		}
		
		turn(res,idx+1,arr);
		if(f) return;
	}

	private static void copy(int[][] arr, int[][] restore) {
		for(int z=0;z<x;z++) {
			for(int a=0;a<y;a++) {
				restore[z][a]=arr[z][a];
			}
		}
	}

	private static int check(int[][] arr2) {
		int min = Integer.MAX_VALUE;
		for(int z=0;z<x;z++) {
			int sum=0;
			for(int a=0;a<y;a++) {
				sum+=arr2[z][a];
				if(sum>min) break;
			}
			if(min>sum) min = sum;
		}
		return min;
	}

}
