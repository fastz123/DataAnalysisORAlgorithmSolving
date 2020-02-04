import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_12100_2048EASY2 {
	public static int size;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_2048easy.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		int[][] arr = new int[size][size];
		
		for(int z=0;z<size;z++) {
			String[] s = br.readLine().split(" ");
			for(int x=0;x<size;x++) {
				arr[z][x] = Integer.parseInt(s[x]);
			}
		}
		max = Integer.MIN_VALUE;
		dfs(arr,0);
		System.out.println(max);
	}

	public static int max;
	public static void up(int[][] arr) {
		for(int z=0;z<size;z++) {
			int curx = -1;
			while(true) {
				curx++;
				if(curx>size-1) break;
				if(arr[curx][z]!=0) {
					int cx = curx;
					int cc = arr[cx][z];
					while(true) {
						cx++;
						if(cx>size-1) break;
						if(arr[cx][z]==cc) {
							arr[curx][z] = cc*2;
							arr[cx][z] = 0;
							break;
						}
						else if(arr[cx][z]==0) continue;
						else break;
					}
					cx = curx;
					cc = arr[cx][z];
					while(true) {
						cx--;
						if(cx<0) break;
						if(arr[cx][z]==0) {
							arr[cx][z]=cc;
							arr[cx+1][z]=0;
						}
						else if(arr[cx][z]!=0) break;
					}
				}
			}
		}
	}
	public static void down(int[][] arr) {
		for(int z=0;z<size;z++) {
			int curx = size;
			while(true) {
				curx--;
				if(curx<0) break;
				if(arr[curx][z]!=0) {
					int cx = curx;
					int cc = arr[cx][z];
					while(true) {
						cx--;
						if(cx<0) break;
						if(arr[cx][z]==cc) {
							arr[curx][z] = cc*2;
							arr[cx][z] = 0;
							break;
						}
						else if(arr[cx][z]==0) continue;
						else break;
					}
					cx = curx;
					cc = arr[cx][z];
					while(true) {
						cx++;
						if(cx>size-1) break;
						if(arr[cx][z]==0) {
							arr[cx][z]=cc;
							arr[cx-1][z]=0;
						}
						else if(arr[cx][z]!=0) break;
					}
				}
			}
		}
	}
	
	public static void left(int[][] arr) {
		for(int z=0;z<size;z++) {
			int cury = -1;
			while(true) {
				cury++;
				if(cury>size-1) break;
				if(arr[z][cury]!=0) {
					int cy = cury;
					int cc = arr[z][cy];
					while(true) {
						cy++;
						if(cy>size-1) break;
						if(arr[z][cy]==cc) {
							arr[z][cury] = cc*2;
							arr[z][cy] = 0;
							break;
						}
						else if(arr[z][cy]==0) continue;
						else break;
					}
					cy = cury;
					cc = arr[z][cy];
					while(true) {
						cy--;
						if(cy<0) break;
						if(arr[z][cy]==0) {
							arr[z][cy]=cc;
							arr[z][cy+1]=0;
						}
						else if(arr[z][cy]!=0) break;
					}
				}
			}
		}
	}
	
	public static void right(int[][] arr) {
		for(int z=0;z<size;z++) {
			int cury = size;
			while(true) {
				cury--;
				if(cury<0) break;
				if(arr[z][cury]!=0) {
					int cy = cury;
					int cc = arr[z][cy];
					while(true) {
						cy--;
						if(cy<0) break;
						if(arr[z][cy]==cc) {
							arr[z][cury] = cc*2;
							arr[z][cy] = 0;
							break;
						}
						else if(arr[z][cy]==0) continue;
						else break;
					}
					cy = cury;
					cc = arr[z][cy];
					while(true) {
						cy++;
						if(cy>size-1) break;
						if(arr[z][cy]==0) {
							arr[z][cy]=cc;
							arr[z][cy-1]=0;
						}
						else if(arr[z][cy]!=0) break;
					}
				}
			}
		}
	}
	
	
	private static void dfs(int[][] arr, int cnt) {
		if(cnt==5) {
			//printmap(arr);
			int curmax = check(arr);
			if(max<curmax) max=curmax;
			//System.out.println("--------------------------//");
			return;
		}
		else {
			int[][] restorearr = new int[size][size];
			restore(arr,restorearr);
			

//			right(arr);
//			left(arr);
//			up(arr);
//			up(arr);
//			up(arr);
//			up(arr);
//			up(arr);
//			down(arr);
			//상
			up(arr);
			//System.out.println("up");
			dfs(arr,cnt+1);
			restore(restorearr,arr);
			//하
			down(arr);
			//System.out.println("down");
			dfs(arr,cnt+1);
			restore(restorearr,arr);
			//좌
			left(arr);
			//System.out.println("left");
			dfs(arr,cnt+1);
			restore(restorearr,arr);
			//우
			right(arr);
			//System.out.println("right");
			dfs(arr,cnt+1);
			restore(restorearr,arr);
		}
	}

	private static int check(int[][] arr) {
		int curmax = -1;
		for(int z=0;z<size;z++) {
			for(int x=0;x<size;x++) {
				if(curmax<arr[z][x]) curmax = arr[z][x];
			}
		}
		return curmax;
	}
	private static void restore(int[][] arr, int[][] restorearr) {
		for(int z=0;z<size;z++) {
			for(int x=0;x<size;x++) {
				restorearr[z][x] = arr[z][x];
			}
		}
	}
	
	private static void printmap(int[][] arr) {
		for(int z=0;z<size;z++) {
			for(int x=0;x<size;x++) {
				System.out.print(arr[z][x]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

}
