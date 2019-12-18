package algo804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_11559_PuyoPuyo_김민호 {
	public static int v[][];
	public static char arr[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_뿌요.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new char[12][6];
		
		for(int z=0;z<12;z++) {
			String s = br.readLine();
			for(int x=0;x<6;x++) {
				arr[z][x]=s.charAt(x);
			}
		}

		int ans=0;
		boolean f=false;
		
		while(true) {
			int gn=1;
			v = new int[12][6];
			ArrayList<int[]> crashlist = new ArrayList<>();
			for(int z=11;z>=0;z--) {
				for(int x=5;x>=0;x--) {
					if(arr[z][x]!='.' && v[z][x]==0) {
						ArrayList<int[]> cur = bfs(z,x,gn,arr[z][x]);
						if(cur.size()>=4) for(int[] a:cur) crashlist.add(a);
						gn++;
					}
				}
			}
			
			if(crashlist.size()>0) {
				for(int[] a:crashlist) arr[a[0]][a[1]]='.'; //crash
				if(f==true) ans++;
				f=true;
			}
			else {
				f=false;
				break;
			}
			
			down();
		}
		System.out.println(ans==0? 0:ans+1);
	}
	private static void down() {
		for(int z=0;z<6;z++) {//down
			int h = 11;
			while(true) {
				if(h<0) break;
				if(arr[h][z]!='.') {
					int cur = h;
					while(true) {
						if(cur==11) break;
						if(arr[cur+1][z]=='.') {
							arr[cur+1][z]=arr[cur][z];
							arr[cur][z]='.';
						}
						cur++;
					}
				}
				h--;
			}
		}
	}
	public static Queue<int[]> q = new LinkedList<>();
	public static int di[]= {0,-1,0,1},dj[]= {-1,0,1,0},cnt;
	private static ArrayList<int[]> bfs(int i, int j,int gn,char c) {
		cnt=0;
		ArrayList<int[]> list = new ArrayList<>();
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			v[cur[0]][cur[1]]=gn;
			cnt++;
			list.add(new int[] {cur[0],cur[1]});
			for(int z=0;z<4;z++) {
				int newx = cur[0]+di[z];
				int newy = cur[1]+dj[z];
				if(newx>=0 && newx<12 && newy>=0 && newy<6 && arr[newx][newy]==c && v[newx][newy]==0) {
					q.offer(new int[] {newx,newy});
					
				}
			}
		}
		return list;
		
	}

}
