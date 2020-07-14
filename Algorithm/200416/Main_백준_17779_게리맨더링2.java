package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_17779_게리맨더링2 {
	public static int d[],size,map[][],min;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_게리맨더링2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		min = Integer.MAX_VALUE;
		for(int z=0;z<size;z++) {
			String[] s = br.readLine().split(" ");
			for(int x=0;x<size;x++) {
				map[z][x] = Integer.parseInt(s[x]);
			}
		}

		for(int z=0;z<size;z++) {
			for(int x=0;x<size;x++) {
				if((z==0 && x==0) || (z==0 && x==size-1) || (z==size-1&&x==0) || (z==size-1 && x==size-1)) continue;
				else {
					d = new int[2];
					perm(0,z,x);
				}
			}
		}
		System.out.println(min);
	}
	private static void perm(int count,int x,int y) {
		if(count==2) {
			if(d[0]+d[1] <= size -1) {
				if(x+d[0]+d[1]<size && y-d[0]>=0 && y+d[1]<size) {
					int[][] arr = new int[size][size];
					draw(arr,x,y);
					int cur = check(arr);
					min = Math.min(cur, min);
				}
			}
		}
		else {
			for(int i=1;i<size-1;i++) {
				d[count]=i;
				perm(count+1,x,y);
			}
		}
	}
	private static int check(int[][] arr) {
		int p[] = new int[5];
		for(int z=0;z<size;z++) {
			for(int x=0;x<size;x++) {
				if(arr[z][x]==1) p[0]+=map[z][x];
				else if(arr[z][x]==2) p[1]+=map[z][x];
				else if(arr[z][x]==3) p[2]+=map[z][x];
				else if(arr[z][x]==4) p[3]+=map[z][x];
				else p[4]+=map[z][x];
			}
		}
		Arrays.sort(p);
		return p[4]-p[0];
	}
	public static int di[]= {-1,-1,1,1}, dj[]= {-1,1,1,-1};
	private static void draw(int[][] arr,int x,int y) {
		int d1 = d[0];
		int d2 = d[1];
		int curx = x;
		int cury = y;
		int curx2 = x+d2;
		int cury2 = y+d2;
		int curx3 = x+d1;
		int cury3 = y-d1;
		arr[curx][cury] = 5;
		arr[curx2][cury2]=5;
		arr[curx3][cury3]=5;
		//왼아래
		for(int z=0;z<d1;z++) {
			curx+=di[3];
			cury+=dj[3];
			curx2+=di[3];
			cury2+=dj[3];
			arr[curx][cury]=5;
			arr[curx2][cury2]=5;
		}
		//오아래
		curx=x;
		cury=y;
		for(int z=0;z<d2;z++) {
			curx += di[2];
			cury+=dj[2];
			curx3+=di[2];
			cury3+=dj[2];
			arr[curx][cury] = 5;
			arr[curx3][cury3] = 5;
		}
		
case1:	for(int z=0;z<=y;z++) {
			for(int a=0;a<x+d1;a++) {
				if(arr[a][z]==5) continue case1;
				arr[a][z]=1;
			}
		}
		
case2:	for(int z=y+1;z<size;z++) {
			for(int a=0;a<=x+d2;a++) {
				if(arr[a][z]==5) continue case2;
				arr[a][z] = 2;
			}
		}
		
case3:	for(int a=0;a<y-d1+d2;a++) {
			for(int z=size-1;z>=x+d1;z--) {
				if(arr[z][a]==5) continue case3;
				arr[z][a]=3;
			}
		}
case4:	for(int a=y-d1+d2;a<size;a++) {
			for(int z=size-1;z>x+d2;z--) {
				if(arr[z][a]==5) continue case4;
				arr[z][a]=4;
			}
		}
	}

}
