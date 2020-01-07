package algo804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_1941_소문난칠공주_김민호 {
	public static class pp{
		int x;
		int y;
		char c;
		public pp(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
		
	}
	public static boolean v[];
	public static pp res[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_소문난칠공주.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pp[] list = new pp[25];
		int idx=0;
		char[][] arr = new char[5][5];
		for(int z=0;z<5;z++) {
			String s = br.readLine();
			for(int x=0;x<5;x++) {
				arr[z][x] = s.charAt(x);
				list[idx]=new pp(z,x,arr[z][x]);
				idx++;
			}
		}
		
		v = new boolean[25];
		res = new pp[7];
		comb(0,0,list);
		System.out.println(ans);
	}
	public static int ans;
	private static void comb(int start, int count,pp list[]) {
		if(count==7) {
			//res = new pp[] {list[5],list[6],list[7],list[8],list[9],list[11],list[16]};
			if(check(res)) {
//				int[][] ccc = new int[5][5];
//				for(pp cur:res) {
//					ccc[cur.x][cur.y]=1;
//				}
//				for(int[] c:ccc) {
//					for(int cc:c) {
//						System.out.print(cc+" ");
//					}
//					System.out.println();
//				}
//				System.out.println("----------------");
				ans++;
			}
		}
		else {
			for(int i=start;i<25;i++) {
				if(!v[i]) {
					v[i]=true;
					res[count]=list[i];
					comb(i,count+1,list);
					v[i]=false;
				}
			}
		}
	}
	public static int di[] = {0,-1,0,1}, dj[] = {-1,0,1,0},visit[][];
	private static boolean check(pp[] res) {
		int[][] checkarr = new int[5][5];
		int scnt=0;
		for(pp cur:res) {
			int x = cur.x;
			int y = cur.y;
			checkarr[x][y]=1;
			char c = cur.c;
			if(c=='S') scnt++; 
		}
		if(scnt<4) return false;
		else {
			visit=new int[5][5];
			f=false;
			cnt=0;
			dfs(checkarr,res[0].x,res[0].y);
			if(f) {
				return true;
			}
		}
		return false;
	}
	public static boolean f;
	public static int cnt;
	private static void dfs(int[][] checkarr,int i,int j ) {
		visit[i][j]=1;
		cnt++;
		if(cnt==7) {
			f=true; 
			return;
		}
		for(int z=0;z<4;z++) {
			int newx=i+di[z];
			int newy=j+dj[z];
			if(newx>=0 && newx<5 && newy>=0 && newy<5 && visit[newx][newy]==0 && checkarr[newx][newy]==1) {
				dfs(checkarr,newx,newy);
			}
		}
	}

}
