import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEXPERT_5656_벽돌깨기2 {
	public static int b[],N,W,H,map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			W = Integer.parseInt(s[1]);
			H = Integer.parseInt(s[2]);
			
			map = new int[H][W];
			for(int z=0;z<H;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<W;x++) {
					int cur = Integer.parseInt(s[x]);
					map[z][x] = cur;
					if(cur!=0) c++;
				}
			}
			
			b = new int[N];
			min = Integer.MAX_VALUE;
			perm(0);
			
			System.out.println("#"+i+" "+min);
		}

	}
	public static int c;
	private static void perm(int count) {
		if(count==N) {
			int cur = go();
			min = Math.min(min, cur);
			return;
		}
		else {
			for(int i=0;i<W;i++) {
				b[count]=i;
				perm(count+1);
			}
		}
	}

	private static int go() {
		int[][] copy = new int[H][W];
		copying(copy);
		for(int z=0;z<N;z++) {
			//떨어뜨리기+터뜨리기
			drop(b[z],copy);
			
			//내려가기
			down(copy);
		}
		return check(copy);
	}

	private static int check(int[][] copy) {
		int sum=0;
		for(int z=0;z<H;z++) {
			for(int x=0;x<W;x++) {
				if(copy[z][x]>0) sum++;
			}
		}
		return sum;
	}

	private static void down(int[][] copy) {
		for(int z=0;z<W;z++) {
			int curx = H-1;
			while(true) {
				if(copy[curx][z] == 0 ) {
					int cx = curx;
					while(true) {
						cx--;
						if(cx<0) break;
						if(copy[cx][z]!=0) {
							copy[curx][z] = copy[cx][z];
							copy[cx][z] = 0;
							break;
						}
					}
				}
				curx--;
				if(curx<0) break;
			}
		}
	}

	private static void copying(int[][] copy) {
		for(int z=0;z<H;z++) {
			for(int x=0;x<W;x++) {
				copy[z][x] = map[z][x];
			}
		}
	}

	private static void drop(int i, int[][] copy) {
		int curx = 0;
		while(true) {
			if(copy[curx][i] != 0) {
				bomb(curx,i,copy,copy[curx][i]);
				break;
			}
			curx++;
			if(curx == H) break;
		}
	}
	public static int cnt,min;
	private static void bomb(int curx, int i, int[][] copy, int cur) {
		cur--;
		for(int z = curx-cur; z<=curx+cur;z++) {
			if(z>=0 && z<H) {
				if(copy[z][i]!=0) {
					int val = copy[z][i];
					copy[z][i] = 0;
					if(val>1) bomb(z,i,copy,val);
				}
			}
		}
		for(int z= i-cur;z<=i+cur;z++) {
			if(z>=0 && z<W) {
				if(copy[curx][z]!=0) {
					int val = copy[curx][z];
					copy[curx][z] = 0;
					if(val>1) bomb(curx,z,copy,val);
				}
			}
		}
	}

}
