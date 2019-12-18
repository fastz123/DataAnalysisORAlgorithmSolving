package algo804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_17136_색종이붙이기_김민호 {
	public static int v[][], arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[10][10];
		int onecnt = 0;
		for (int z = 0; z < 10; z++) {
			String s[] = br.readLine().split(" ");
			for (int x = 0; x < 10; x++) {
				arr[z][x] = Integer.parseInt(s[x]);
				if (arr[z][x] == 1)
					onecnt++;
			}
		}

		int[] sq = {5,5,5,5,5};

		v = new int[10][10];
		/*
		 * int gn=1; for(int z=0;z<10;z++) { for(int x=0;x<10;x++) { if(arr[z][x]!=0 &&
		 * v[z][x]==0) { int minsize = check(z,x); for(int k=minsize;k>=1;k++) {
		 * dfs(z,x,k); } dfs(z,x,gn); gn++; } } } System.out.println();
		 */

		min = Integer.MAX_VALUE;
		fill(0,0,v,sq,onecnt,0);
		System.out.println(min==Integer.MAX_VALUE? -1:min);
	}

	public static int min;
	private static void fill(int i, int j,int[][] v,int[] sq,int onecnt,int cnt) {
		
		if(onecnt==0) {
			if(cnt<min) min=cnt;
			return;
		}
		else if(onecnt>0) {
			for(int a:sq) {
				if(a<0) return ;
			}
		}
		else {
			return;
		}
		
		for(int z=i;z<10;z++) {
			for(int x=0;x<10;x++) {
				if(v[z][x]==0 && arr[z][x]==1) {
					boolean f = false;
					for(int size=5;size>=1;size--) {
						if(z+size<=10 && x+size<=10 && sq[size-1]>0) {
							if(!f)	f = check(z,x,size,v,arr);
							if(f) {
								for(int p=0;p<size;p++) {
									for(int q=0;q<size;q++) {
										v[z+p][x+q] = 1;
									}
								}
								sq[size-1]--;
								fill(z,j,v,sq,onecnt-(size*size),cnt+1);
								sq[size-1]++;
								for(int p=0;p<size;p++) {
									for(int q=0;q<size;q++) {
										v[z+p][x+q] = 0;
									}
								}
							}
						}
					}
					if(!f) return;
				}
				if(v[z][x]==0 && arr[z][x]==1) return;
			}
		}
	}


	private static boolean check(int i, int j,int size,int[][] v,int[][] arr) {
		for(int z=i;z<i+size;z++) {
			for(int x=j;x<j+size;x++) {
				if(v[z][x]==1 || arr[z][x]==0) return false;
			}
		}
		return true;
	}
}