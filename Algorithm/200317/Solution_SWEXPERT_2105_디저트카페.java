import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_2105_디저트카페 {
	public static int max,size,map[][];
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_디저트카페.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			for(int z=0;z<size;z++) {
				String[] s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					map[z][x] = Integer.parseInt(s[x]);
				}
			}
//			System.out.println(Arrays.deepToString(map));
			
			max = -1;
			for(int z=0;z<size;z++) {
				for(int x=0;x<size;x++) {
					if((z==0 && x==0) || (z==size-1 && x==0) || (z==0&&x==size-1) || (z==size-1 && x==size-1)) {
						continue;
					}
					else {
//						z=5;
//						x=5;
//						System.out.println("----------------"+z+"----"+x+"------------------");
						
						ArrayList<Integer> list = new ArrayList<>();
						v  = new boolean[size][size];
						list.add(map[z][x]);
						v[z][x]=true;
						dfs(z,x,z,x,3,list,0);
					}
				}
			}
			System.out.println("#"+(i+1)+" "+max);
			
		}

	}
	private static void dfs(int stx,int sty,int i, int j, int see, ArrayList<Integer> list,int turncnt) {
		if(turncnt>3) return;
		if((i==0 && j==0) || (i==size-1 && j==0) || (i==0&&j==size-1) || (i==size-1 && j==size-1)) return;
		if(i==stx && j==sty && list.size()>=4) {
//			for(int c : list) System.out.print(c+" ");
//			System.out.println();
			if(max<list.size()) max = list.size();
			return;
		}
		
		if(see==3) {
			//우하
			if(i+1<size && j+1<size && see!=1 && !v[i+1][j+1]) {
				if(!list.contains(map[i+1][j+1])) {
					list.add(map[i+1][j+1]);
					v[i+1][j+1]=true;
					dfs(stx,sty,i+1,j+1,3,list,turncnt);
					v[i+1][j+1]=false;
					list.remove(list.size()-1);
				}
			}
			else if(i+1<size && j+1<size && v[i+1][j+1] && list.get(0)==map[i+1][j+1]) dfs(stx,sty,i+1,j+1,3,list,turncnt);
			//좌하
			if(i+1<size && j-1>=0 && see!=2 && !v[i+1][j-1]) {
				if(!list.contains(map[i+1][j-1])) {
					list.add(map[i+1][j-1]);
					v[i+1][j-1]=true;
					dfs(stx,sty,i+1,j-1,4,list,turncnt+1);
					v[i+1][j-1]=false;
					list.remove(list.size()-1);
				}
			}
			else if(i+1<size && j-1>=0 && v[i+1][j-1] && list.get(0)==map[i+1][j-1]) dfs(stx,sty,i+1,j-1,4,list,turncnt+1);
		}
		else if(see==4) {
			//좌하
			if(i+1<size && j-1>=0 && see!=2 && !v[i+1][j-1]) {
				if(!list.contains(map[i+1][j-1])) {
					list.add(map[i+1][j-1]);
					v[i+1][j-1]=true;
					dfs(stx,sty,i+1,j-1,4,list,turncnt);
					v[i+1][j-1]=false;
					list.remove(list.size()-1);
				}
			}
			else if(i+1<size && j-1>=0 && v[i+1][j-1] && list.get(0)==map[i+1][j-1]) dfs(stx,sty,i+1,j-1,4,list,turncnt);
			//좌상
			if(i-1>=0 && j-1>=0 && see!=3 && !v[i-1][j-1]) {
				if(!list.contains(map[i-1][j-1])) {
					v[i-1][j-1]=true;
					list.add(map[i-1][j-1]);
					dfs(stx,sty,i-1,j-1,1,list,turncnt+1);
					v[i-1][j-1]=false;
					list.remove(list.size()-1);
				}
			}
			else if(i-1>=0 && j-1>=0 && v[i-1][j-1] && list.get(0)==map[i-1][j-1]) dfs(stx,sty,i-1,j-1,1,list,turncnt+1);
		}
		else if(see==1) {
			//우상
			if(i-1>=0 && j+1<size && see!=4 &&  !v[i-1][j+1]) {
				if(!list.contains(map[i-1][j+1])) {
					list.add(map[i-1][j+1]);
					v[i-1][j+1]=true;
					dfs(stx,sty,i-1,j+1,2,list,turncnt+1);
					v[i-1][j+1]=false;
					list.remove(list.size()-1);
				}
			}
			else if(i-1>=0  && j+1<size && v[i-1][j+1] && list.get(0)==map[i-1][j+1]) dfs(stx,sty,i-1,j+1,2,list,turncnt+1);
			//좌상
			if(i-1>=0 && j-1>=0 && see!=3 && !v[i-1][j-1]) {
				if(!list.contains(map[i-1][j-1])) {
					v[i-1][j-1]=true;
					list.add(map[i-1][j-1]);
					dfs(stx,sty,i-1,j-1,1,list,turncnt);
					v[i-1][j-1]=false;
					list.remove(list.size()-1);
				}
			}
			else if(i-1>=0 && j-1>=0 && v[i-1][j-1] && list.get(0)==map[i-1][j-1]) dfs(stx,sty,i-1,j-1,1,list,turncnt);
		}
		else {
			//우상
			if(i-1>=0 && j+1<size && see!=4 &&  !v[i-1][j+1]) {
				if(!list.contains(map[i-1][j+1])) {
					list.add(map[i-1][j+1]);
					v[i-1][j+1]=true;
					dfs(stx,sty,i-1,j+1,2,list,turncnt);
					v[i-1][j+1]=false;
					list.remove(list.size()-1);
				}
			}
			else if(i-1>=0 && j+1<size && v[i-1][j+1] && list.get(0)==map[i-1][j+1]) dfs(stx,sty,i-1,j+1,2,list,turncnt);
			//우하
			if(i+1<size && j+1<size && see!=1 && !v[i+1][j+1]) {
				if(!list.contains(map[i+1][j+1])) {
					list.add(map[i+1][j+1]);
					v[i+1][j+1]=true;
					dfs(stx,sty,i+1,j+1,3,list,turncnt+1);
					v[i+1][j+1]=false;
					list.remove(list.size()-1);
				}
			}
			else if(i+1<size && j+1<size && v[i+1][j+1] && list.get(0)==map[i+1][j+1]) dfs(stx,sty,i+1,j+1,3,list,turncnt+1);
		}
		
	}

}
