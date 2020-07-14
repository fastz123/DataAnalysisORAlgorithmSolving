package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_10836_여왕벌 {
	public static int size,g[][],map[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_여왕벌.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		size = Integer.parseInt(s[0]);
		int day = Integer.parseInt(s[1]);
		
		map = new int[size][size];
		for(int [] a:map) Arrays.fill(a, 1);
		int[] grow = new int[(size*2)-1];
		for(int z=0;z<day;z++) {
			s = br.readLine().split(" ");
			int zero = Integer.parseInt(s[0]);
			int one = Integer.parseInt(s[1]);
			int two = Integer.parseInt(s[2]);
			int idx = 0;
			for(int a=idx;a<zero;a++) grow[a]+=0;
			idx+=zero;
			for(int a=0;a<one;a++) grow[idx+a]+=1;
			idx+=one;
			for(int a=0;a<two;a++) grow[idx+a]+=2;
		}
//		System.out.println(Arrays.deepToString(grow));
		
		g = grow1(grow);
		for(int k=1;k<size;k++)	grow2(k);
		printmap(map);
	}

	private static void printmap(int[][] map) {
		for(int[] a :map) {
			for(int cur : a) System.out.print(cur+" ");
			System.out.println();
		}
		System.out.println();
	}

	private static void grow2(int k) {
		int curx = k;
		int cury = k;
		
		while(true) {
			if(curx==size ) break;
			
			int[] bigyo = new int[3];
			bigyo[0] = g[curx-1][cury-1]; //왼위
			bigyo[1] = g[curx][cury-1]; //왼
			bigyo[2] = g[curx-1][cury]; //위
			Arrays.sort(bigyo);
			int max = bigyo[2];
			g[curx][cury]=max;
			map[curx][cury]+=max;
			curx++;
		}
		curx = k;
		cury = k+1;
		while(true) {
			if(cury==size ) break;
			
			int[] bigyo = new int[3];
			bigyo[0] = g[curx-1][cury-1]; //왼위
			bigyo[1] = g[curx][cury-1]; //왼
			bigyo[2] = g[curx-1][cury]; //위
			Arrays.sort(bigyo);
			int max = bigyo[2];
			g[curx][cury]=max;
			map[curx][cury]+=max;
			cury++;
		}
			
	}

	private static int[][] grow1(int[] grow) {
		int[][] g = new int[size][size];
		int curx = size-1;
		int cury = 0;
		
		boolean f=false;
		int idx = 0;
		while(true) {
			if(cury==size) break;
			
			g[curx][cury]+=grow[idx];
			map[curx][cury]+=grow[idx];
			
			if(!f) {
				if(curx==0) {
					f=true;
					cury++;
					idx++;
					continue;
				}
				curx--;
			}
			else {
				cury++;
			}
			idx++;
		}
		return g;
	}

}
