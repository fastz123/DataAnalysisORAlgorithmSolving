import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_17144_미세먼지안녕 {
	public static int R,C,arr[][];
	public static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		int T = Integer.parseInt(s[2]);
		
		arr = new int[R][C];
		
		
		
		for(int z=0;z<R;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<C;x++) {
				arr[z][x]=Integer.parseInt(s[x]);
				if(arr[z][x]==-1) q.offer(new int[] {z,x});
			}
		}
		
//		System.out.println(Arrays.deepToString(arr));
		
		
		int sec=0;
		
		
		while(sec<T) {
			int[][] divide = new int[R][C];
			hs(divide);
			copying(divide);
			move(divide);
			q.offer(new int[] {ax-1,0});
			q.offer(new int[] {ax,0});
			//System.out.println();
			sec++;
		}
		
		System.out.println(checkresult());
		
	}
	private static void copying(int[][] divide) {
		for(int z=0;z<R;z++) {
			for(int x=0;x<C;x++) {
				arr[z][x]=divide[z][x];
			}
		}
		
	}
	private static int checkresult() {
		int sum=0;
		for(int z=0;z<R;z++) {
			for(int x=0;x<C;x++) {
				if(arr[z][x]>0) sum+=arr[z][x];
			}
		}
		return sum;
	}
	private static void move(int[][] divide) {
		int stx1 = ax-1;
		int sty = 0;
		int stx2 = ax;
		//위
		//우
		arr[stx1][1]=0;
		for(int z=1;z<C-1;z++) {
			arr[stx1][z+1]=divide[stx1][z];
		}
		//상
		for(int z=stx1;z>=1;z--) {
			arr[z-1][C-1]=divide[z][C-1];
		}
		//좌
		for(int z=C-1;z>0;z--) {
			arr[0][z-1]=divide[0][z];
		}
		//하
		for(int z=0;z<stx1-1;z++) {
			arr[z+1][0]=divide[z][0];
		}
		//--------------------
		//아래
		//우
		arr[stx2][1]=0;
		for(int z=1;z<C-1;z++) {
			arr[stx2][z+1]=divide[stx2][z];
		}
		//하
		for(int z=stx2;z<R-1;z++) {
			arr[z+1][C-1]=divide[z][C-1];
		}
		//좌
		for(int z=C-1;z>0;z--) {
			arr[R-1][z-1]=divide[R-1][z];
		}
		//상
		for(int z=R-1;z>stx2+1;z--) {
			arr[z-1][0]=divide[z][0];
		}
	}
	public static LinkedList<int[]> list = new LinkedList<>();
	public static int ax,ay;
	public static int[] di = {0,-1,0,1};
	public static int[] dj = {-1,0,1,0};
	private static void hs(int[][] divide) {
		for(int z=0;z<R;z++) {
			for(int x=0;x<C;x++) {
				if(arr[z][x]!=-1) {
					int cnt = check(z,x);
					int val = arr[z][x]/5;
					int centerval = arr[z][x]-(val*(cnt));
					divide[z][x]+=centerval;
					for(int k=0;k<4;k++) {
						int newx = z+di[k];
						int newy = x+dj[k];
						if(newx>=0 && newx<R && newy>=0 && newy<C && arr[newx][newy]!=-1) {
							divide[newx][newy]+=val;
						}
					}
				}
				else {
					int cur[] = q.poll();
					divide[cur[0]][cur[1]]=-1;
					ax=cur[0];
					ay=cur[1];
				}
			}
		}
	}
	private static int check(int z, int x) {
		int cnt=0;
		for(int k=0;k<4;k++) {
			int newx = z+di[k];
			int newy = x+dj[k];
			if(newx>=0 && newx<R && newy>=0 && newy<C && arr[newx][newy]!=-1) {
				cnt++; 
			}
		}
		return cnt;
	}
}
