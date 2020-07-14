package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_샘플_프로세서연결하기 {
	public static int n,size,map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_프로세서연결하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			ArrayList<Integer> list = new ArrayList<>();
			for(int z=0;z<size;z++) {
				String[] s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					map[z][x] = Integer.parseInt(s[x]);
					if(s[x].equals("1")) {
						if((z==0 || z==size-1) || (x==0 || x==size-1)) {
							continue;
						}
						else {
							list.add(z*size+x);
						}
					}
				}
			}
			
			n = list.size();
			connmax = -1;
			linemin = new int[n];
			for(int z=0;z<n;z++) linemin[z] = Integer.MAX_VALUE;
			dfs(list,0,0,0);
			
			System.out.print("#"+(i+1)+" ");
			int max = -999;
			for(int cur = n-1;cur>=0;cur--) {
				if(linemin[cur]!=Integer.MAX_VALUE) {
					max = linemin[cur];
					break;
				}
				else continue;
			}
			if(max==-999) System.out.println(0);
			else System.out.println(max);
		}

	}
	public static int connmax,linemin[];
	private static void dfs(ArrayList<Integer> list, int idx,int conn,int line) {
		if(idx >= list.size()) {
			if(conn>0) {
				if(linemin[conn-1] > line) linemin[conn-1] = line;
			}
			return;
		}
		else {
			//선택x
			dfs(list,idx+1,conn,line);
			
			//선택
			int stx = list.get(idx)/size;
			int sty = list.get(idx)%size;
			ArrayList<Character> clist = check(stx,sty);
			//좌
			if(!clist.contains('l')) {
				int cnt = draw(5,'l',stx,sty);
				dfs(list,idx+1,conn+1,cnt+line+1);
				draw(0,'l',stx,sty);
			}
			//우
			if(!clist.contains('r')) {
				int cnt = draw(5,'r',stx,sty);
				dfs(list,idx+1,conn+1,cnt+line+1);
				draw(0,'r',stx,sty);
			}
			//상
			if(!clist.contains('u')) {
				int cnt = draw(5,'u',stx,sty);
				dfs(list,idx+1,conn+1,cnt+line+1);
				draw(0,'u',stx,sty);
			}
			//하
			if(!clist.contains('d')) {
				int cnt = draw(5,'d',stx,sty);
				dfs(list,idx+1,conn+1,cnt+line+1);
				draw(0,'d',stx,sty);
			}
		}
	}
	private static void printmap() {
		for(int[] a:map) System.out.println(Arrays.toString(a));
		System.out.println("--------------------------------");
	}
	private static int draw(int n,char c, int stx, int sty) {
		int ret = 0;
		if(c=='l') {
			for(int z=sty-1;z>=0;z--) {
				map[stx][z] = n;
			}
			ret = Math.abs((sty-1));
		}
		else if(c=='r') {
			for(int z=sty+1;z<size;z++) {
				map[stx][z] = n;
			}
			ret = Math.abs(size-1 -(sty+1));
		}
		else if(c=='u') {
			for(int z=stx-1;z>=0;z--) {
				map[z][sty]=n;
			}
			ret = stx-1;
		}
		else {
			for(int z=stx+1;z<size;z++) {
				map[z][sty]=n;
			}
			ret = Math.abs(size-1 -(stx+1));
		}
		return ret;
	}
	private static ArrayList<Character> check(int stx, int sty) {
		ArrayList<Character> list = new ArrayList<>();
		//좌
		for(int z=sty-1;z>=0 ;z--) {
			if(map[stx][z]!=0) {
				list.add('l');
				break;
			}
		}
		//우
		for(int z=sty+1;z<size;z++) {
			if(map[stx][z]!=0) {
				list.add('r');
				break;
			}
		}
		//상
		for(int z=stx-1;z>=0;z--) {
			if(map[z][sty]!=0) {
				list.add('u');
				break;
			}
		}
		//하
		for(int z=stx+1;z<size;z++) {
			if(map[z][sty]!=0) {
				list.add('d');
				break;
			}
		}
		
		return list;
	}

}
