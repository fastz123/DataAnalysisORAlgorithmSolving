package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_18808_스티커붙이기 {
	public static int M,N;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_스티커붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = Integer.parseInt(br.readLine());
//		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]);
			N = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			int[][] map = new int[M][N];
			boolean[][] notebook = new boolean[M][N];
case1:		for(int z=0;z<C;z++) {
				s = br.readLine().split(" ");
				int m = Integer.parseInt(s[0]);
				int n = Integer.parseInt(s[1]);
				boolean[][] sticker = new boolean[m][n];
				for(int p=0;p<m;p++) {
					s = br.readLine().split(" ");
					for(int q=0;q<n;q++) {
						if(s[q].equals("1")) sticker[p][q] = true;
					}
				}
//				for(boolean[] a:sticker) System.out.println(Arrays.toString(a));
//				boolean[][] afterturn = turn(sticker);
//				for(boolean[] a:afterturn) System.out.println(Arrays.toString(a));
				if(!fill(notebook,sticker)) {
					boolean sticker90[][] = turn(sticker);
					if(!fill(notebook,sticker90)) {
						boolean sticker180[][] = turn(sticker90);
						if(!fill(notebook,sticker180)) {
							boolean[][] sticker270 = turn(sticker180);
							if(!fill(notebook,sticker270)) {
								continue case1;
							}
							else { //270
								continue case1;
							}
						}
						else { // 180 
							continue case1;
						}
					}
					else { //90 에서됨
						continue case1;
					}
				}
				else { //0도 에서됨
					continue case1;
				}
				
			}
			System.out.println(check(notebook));
//		}

	}

	private static int check(boolean[][] notebook) {
		int c = 0;
		for(int z=0;z<M;z++) {
			for(int x=0;x<N;x++) {
				if(notebook[z][x]) c++;
			}
		}
		return c;
	}

	private static boolean[][] turn(boolean[][] sticker) {
		int row = sticker.length;
		int col = sticker[0].length;
		boolean[][] cur = new boolean[col][row];
		for(int z=0;z<col;z++) {
			for(int x=0;x<row;x++) {
				cur[z][x] = sticker[row-1-x][z];
			}
		}
		return cur;
	}

	private static boolean fill(boolean[][] notebook, boolean[][] sticker) {
		int row = sticker.length;
		int col = sticker[0].length;
		for(int z=0;z<=M-row;z++) {
			for(int x=0;x<=N-col;x++) {
				if(isitfill(z,x,notebook,sticker,row,col)) {
					fillit(z,x,notebook,sticker,row,col);
					return true;
				}
			}
		}
		return false;
	}

	private static void fillit(int stx, int sty, boolean[][] notebook, boolean[][] sticker, int row, int col) {
		for(int z=stx;z<stx+row;z++) {
			for(int x=sty;x<sty+col;x++) {
				notebook[z][x]^=sticker[z-stx][x-sty];
			}
		}
	}

	private static boolean isitfill(int stx,int sty,boolean[][] notebook, boolean[][] sticker,int row,int col) {
		for(int z=stx;z<stx+row;z++) {
			for(int x=sty;x<sty+col;x++) {
				if(sticker[z-stx][x-sty]) {
					if(notebook[z][x]) return false;
					else continue;
				}
				else continue;
			}
		}
		return true;
	}

}
