import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_17472_다리만들기_김민호 {

	public static class Bridge{
		int x;
		int y;
		int endx;
		int endy;
		char see;
		int st;
		int e;
		public Bridge(int x, int y,int endx,int endy, char see,int st,int e) {
			this.x = x;
			this.y = y;
			this.endx=endx;
			this.endy=endy;
			this.see = see;
			this.st = st;
			this.e = e;
		}
	}
	public static int arr[][],r,c,v[][],checkarr[][],num;
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_다리만들기2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		r = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);
		arr = new int[r][c];
		for(int z=0;z<r;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<c;x++) {
				arr[z][x]=Integer.parseInt(s[x]);
			}
		}

		int cnt=1;
		v = new int[r][c];
		for(int z=0;z<r;z++) {
			for(int x=0;x<c;x++) {
				if(arr[z][x]==1 && v[z][x]==0) {
					dfs(z,x,cnt);
					cnt++;
				}
			}
		}
		
		bridgelist = new ArrayList<>();
		for(int z=0;z<r;z++) {
			for(int x=0;x<c;x++) {
				if(x+1<c && arr[z][x]!=0 && arr[z][x+1]==0) {
					check(z,x,'r',v[z][x]-1);
				}
				if(z+1<r && arr[z][x]!=0 && arr[z+1][x]==0) {
					check(z,x,'d',v[z][x]-1);
				}
			}
		}
		min = Integer.MAX_VALUE;
		int size = bridgelist.size();
		for(long z=0;z<(1<<size);z++) {
//			z=25;
			ArrayList<Bridge> list = new ArrayList<>();
			for(int k=0;k<size;k++) {
				if((z&(1<<k))>0) {
					list.add(bridgelist.get(k));
				}
			}
			if(list.size()==cnt-1-1) {
				checkarr = new int[cnt-1][cnt-1];
				draw(list);
				visit =new boolean[cnt-1];
				num=0;
				dfs2(0,cnt-1);
				if(num==cnt-1) {
					int cursum = getsum(list);
					if(min>cursum) min=cursum;
				}
			}
		}
		System.out.println(min==Integer.MAX_VALUE? -1:min);
	}
	public static int min;
	private static int getsum(ArrayList<Bridge> list) {
		int sum=0;
		for(Bridge b:list) {
			if(b.see=='r') {
				sum+=b.endy-b.y+1;
			}
			else {
				sum+=b.endx-b.x+1;
			}
		}
		return sum;
	}

	private static void dfs2(int i, int cnt) {
		visit[i]=true;
		num++;
		for(int z=0;z<cnt;z++) {
			if(!visit[z] && checkarr[i][z]==1) {
				visit[z]=true;
				dfs2(z,cnt);
			}
		}
	}

	private static void draw(ArrayList<Bridge> list) {
		for(Bridge b:list) {
			checkarr[b.st][b.e]=1;
			checkarr[b.e][b.st]=1;
		}
	}

	public static int di[]= {0,-1,0,1},dj[]= {-1,0,1,0};
	private static void dfs(int i, int j,int color) {
		v[i][j]=color;
		for(int z=0;z<4;z++) {
			int newx=i+di[z];
			int newy=j+dj[z];
			if(newx>=0 && newx<r && newy>=0 && newy<c && arr[newx][newy]==1 && v[newx][newy]==0) {
				dfs(newx,newy,color);
			}
		}
	}

	

	public static ArrayList<Bridge> bridgelist;
	private static void check(int i, int j, char cc,int st) {
		if(cc=='r') {
			int cury = j;
			while(true) {
				cury++;
				if(cury==c) break;
				if(v[i][cury]>0) {
					if(j+1 != cury-1) bridgelist.add(new Bridge(i,j+1,i,cury-1,'r',st,v[i][cury]-1));
					break;
				}
			}
		}
		else {
			int curx = i;
			while(true) {
				curx++;
				if(curx==r) break;
				if(v[curx][j]>0) {
					if(i+1 != curx-1) bridgelist.add(new Bridge(i+1,j,curx-1,j,'d',st,v[curx][j]-1));
					break;
				}
			}
		}
	}

}
