import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14500_테트로미노 {
	public static int v[][],arr[][],x,y;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_테트로미노.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		
		arr = new int[x][y];
		
		for(int m=0;m<x;m++) {
			s = br.readLine().split(" ");
			for(int n=0;n<y;n++) {
				arr[m][n]=Integer.parseInt(s[n]);
			}
		}
		max = Integer.MIN_VALUE;
		v = new int[x][y];
		for(int k=0;k<x;k++) {
			for(int a=0;a<y;a++) {
				//z=3;
				//a=9;
				check(k,a);
				v[k][a]=1;
				for(int z=0;z<4;z++) {
					int newx = k+di[z];
					int newy = a+dj[z];
					if(newx>=0 && newx<x && newy>=0 && newy<y ) {
						v[newx][newy]=1;
						dfs(newx,newy,2,arr[k][a]+arr[newx][newy],v);
						v[newx][newy]=0;
					}
				}
			}
		}
		System.out.println(max);
	}
	private static void check(int i, int j) {
		int sum=0;
		if(j-1>=0 && j+1<y && i+1<x ) {
			sum = arr[i][j]+arr[i][j-1]+arr[i][j+1]+arr[i+1][j];
			if(max<sum) max = sum;
		}
		if(j-1>=0 && j+1<y && i-1>=0) {
			sum = arr[i][j]+arr[i][j-1]+arr[i][j+1]+arr[i-1][j];
			if(max<sum) max = sum;
		}
		if(i-1>=0 && i+1<x && j-1>=0) {
			sum = arr[i][j]+arr[i-1][j]+arr[i+1][j]+arr[i][j-1];
			if(max<sum) max = sum;
		}
		if(i-1>=0 && i+1<x && j+1<y) {
			sum = arr[i][j]+arr[i-1][j]+arr[i+1][j]+arr[i][j+1];
			if(max<sum) max=sum;
		}
	}
	
	public static int max;
	public static int[] di = {0,-1,0,1};
	public static int[] dj = {-1,0,1,0};
	private static void dfs(int i, int j,int cnt,int sum,int v[][]) {
		if(cnt==4) {
			if(max<sum) {
				max = sum;
			}
			//v[i][j]=0;
			return;
		}
		for(int z=0;z<4;z++) {
			int newx = i+di[z];
			int newy = j+dj[z];
			if(newx>=0 && newx<x && newy>=0 && newy<y && (v[newx][newy]==0)) {
				v[newx][newy]=1;
				dfs(newx,newy,cnt+1,sum+arr[newx][newy],v);
				v[newx][newy]=0;
			}
		}
	}
}
