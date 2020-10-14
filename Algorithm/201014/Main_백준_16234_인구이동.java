package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_백준_16234_인구이동 {
	public static int di[]= {0,-2,0,2}, dj[]= {-2,0,2,0},v[][],size,N,map[][];
	public static LinkedList<Integer> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_인구이동.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s= br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int least = Integer.parseInt(s[1]);
		int maximum = Integer.parseInt(s[2]);
		
		size = N+N-1;
		map = new int[size][size];
		
		for(int z=0;z<size;z+=2) {
			s = br.readLine().split(" ");
			for(int x=0;x<size;x+=2) {
				map[z][x] = Integer.parseInt(s[x/2]);
			}
		}
		
		int time = 0;
		while(true) {
			
			int count=0;
			for(int z=0;z<size;z+=2) {
				for(int x=0;x<size;x+=2) {
					
					int cur = map[z][x];
					for(int k=2;k<4;k++) {
						if(z+di[k]>=0 && z+di[k]<size && x+dj[k]>=0 && x+dj[k]<size) {
							int newp = map[z+di[k]][x+dj[k]];
							
							int gap =Math.abs(cur-newp); 
							if(gap >= least && gap<=maximum) {
								map[z+(di[k]/2)][x+(dj[k]/2)]=1;
								count++;
							}
						}
					}
					
				}
			}
			
			if(count>0) {
				v = new int[N][N];
				
				int c=1;
				for(int z=0;z<size;z+=2) {
					for(int x=0;x<size;x+=2) {
						
						if(v[z/2][x/2]==0) {
							totnum=map[z][x];
							cnt=1;
							v[z/2][x/2]=c;
							list = new LinkedList<Integer>();
							list.add(z*size+x);
							dfs(z,x,c);
							
							int res = totnum/cnt;
							for(int cur : list) {
								int xx = cur/size;
								int yy = cur%size;
								map[xx][yy]=res;
							}
							c++;
						}
					}
				}
				
				for(int z=0;z<size;z++) {
					if(z%2==1) {
						for(int x=0;x<size;x++) map[z][x]=0;
					}
					else {
						for(int x=1;x<size;x+=2) {
							map[z][x]=0;
						}
					}
				}
			}
			else break;
			time++;
		}
		
		System.out.println(time);

	}
	
	private static void printmap() {
		for(int[] a : map) System.out.println(Arrays.toString(a));
		System.out.println();
	}

	private static void draw(int c, int res) {
		for(int z=0;z<size;z+=2) {
			for(int x=0;x<size;x+=2) {
				if(v[z/2][x/2]==c) {
					map[z][x]=res;
				}
			}
		}
	}

	public static int totnum,cnt;
	private static void dfs(int i, int j, int c) {
		for(int z=0;z<4;z++) {
			int newx = i+di[z];
			int newy = j+dj[z];
			
			int nx = i+di[z]/2;
			int ny = j+dj[z]/2;
			
			if(newx>=0 && newx<size && newy>=0 && newy<size && map[nx][ny]==1 && v[newx/2][newy/2]==0) {
				list.add(newx*size + newy);
				totnum += map[newx][newy];
				cnt++;
				v[newx/2][newy/2]=c;
				dfs(newx,newy,c);
			}
		}
	}

}
