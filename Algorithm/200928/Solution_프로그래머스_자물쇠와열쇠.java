package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_프로그래머스_자물쇠와열쇠 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_자물쇠와열쇠.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M  = Integer.parseInt(br.readLine());
		int[][] key = new int[M][M];
		for(int z=0;z<M;z++) {
			String[] s = br.readLine().split(", ");
			for(int x=0;x<M;x++) {
				key[z][x] = Integer.parseInt(s[x]);
			}
		}
		int N = Integer.parseInt(br.readLine());
		int[][] lock = new int[N][N];
		for(int z=0;z<N;z++) {
			String[] s = br.readLine().split(", ");
			for(int x=0;x<N;x++) {
				lock[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		if(isOkk(lock)) System.out.println(true);
		else {
			if(check(lock,key,N,M)) {
				System.out.println(true);
			}
			else {
				for(int z=0;z<3;z++) {
					int[][] temp = turn(key,M);
					key = temp;
					if(check(lock,key,N,M)) {
						System.out.println(true);
						return;
					}
				}
				System.out.println(false);
			}
			
		}

	}


	private static boolean isOkk(int[][] lock) {
		int len = lock.length;
		for(int z=0;z<len;z++) {
			for(int x=0;x<len;x++) {
				if(lock[z][x]!=1) return false;
			}
		}
		return true;
	}


	private static boolean check(int[][] lock, int[][] key, int n, int m) {
		
		int size = (key.length-1)*2+lock.length;
		int[][] map = new int[size][size];
		
		for(int z=key.length-1;z<key.length+lock.length-1;z++) {
			for(int x=key.length-1;x<key.length+lock.length-1;x++) {
				map[z][x] = lock[z-(key.length-1)][x-(key.length-1)];
			}
		}
//		
		for(int z=0;z<key.length+lock.length-1;z++) {
			for(int x=0;x<key.length+lock.length-1;x++) {
				
				for(int p=0;p<key.length;p++) {
					for(int q=0;q<key.length;q++) {
						map[z+p][x+q] += key[p][q];
					}
				}
				for(int[] a:map) System.out.println(Arrays.toString(a));
				System.out.println();
				if(isOk(map, key.length, lock.length)) {
					return true;
				}
				else {
					for(int p=0;p<key.length;p++) {
						for(int q=0;q<key.length;q++) {
							map[z+p][x+q] -= key[p][q];
						}
					}
				}
			}
		}
		
		return false;
	}


	private static boolean isOk(int[][] map,int klen, int len) {
		for(int i=klen-1;i<klen+len-1;i++) {
			for(int j=klen-1;j<klen+len-1;j++) {
				if(map[i][j]!=1) return false;
			}
		}
		return true;
	}

	private static int[][] turn(int[][] key, int M) {
		int temp[][] = new int[M][M];
		for(int z=0;z<M;z++) {
			for(int x=0;x<M;x++) {
				temp[z][x] = key[M-1-x][z];
			}
		}
//		for(int[] a : temp) System.out.println(Arrays.toString(a));
//		System.out.println();
		return temp;
	}

}
