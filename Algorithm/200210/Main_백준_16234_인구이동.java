import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_16234_인구이동 {
	public static int arr[][],size,di[]= {0,-2,0,2},dj[]= {-2,0,2,0},v[][],SIZE;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_인구이동.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		size = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		
		arr = new int[2*size-1][2*size-1];
		SIZE = 2*size-1;
		for(int z=0;z<SIZE;z+=2) {
			String ss[] = br.readLine().split(" ");
			for(int a=0;a<SIZE;a+=2) {
				arr[z][a] = Integer.parseInt(ss[(a/2)]);
			}
		}
		
		int c=0;
case1:	while(true) {
			clear();
			int cc=0;
			for(int z=0;z<SIZE;z+=2) {
				for(int x=0;x<SIZE;x+=2) {
					for(int k=0;k<4;k++) {
						int newx = z+di[k];
						int newy = x+dj[k];
						if(newx>=0 && newx<SIZE && newy>=0 && newy<SIZE) {
							if(Math.abs(arr[z][x] - arr[newx][newy])>=L && Math.abs(arr[z][x] - arr[newx][newy])<=R){
								if(arr[(z+newx)/2][(x+newy)/2]==0) {
									arr[(z+newx)/2][(x+newy)/2]=-1;
									cc++;
								}
								
							}
						}
					}
				}
			}
			if(cc==0) break;
			v = new int[SIZE][SIZE];
			int num = 1;
			for(int z=0;z<SIZE;z+=2) {
				for(int x=0;x<SIZE;x+=2) {
					if(v[z][x]==0) {
						cnt=0;
						sum=0;
						list = new ArrayList<>();
						dfs(z,x,num);
						num++;
						for(int k=0;k<list.size();k++) {
							int[] cur = list.get(k);
							arr[cur[0]][cur[1]]=sum/cnt;
						}
					}
				}
			}
			c++;
		}
		System.out.println(c);
		//arr[SIZE/2][SIZE/2]=-1;
		
	}
	private static void clear() {
		for(int z=1;z<SIZE;z+=2) {
			for(int x=0;x<SIZE;x++) {
				arr[z][x]=0;
			}
		}
		for(int z=1;z<SIZE;z+=2) {
			for(int x=0;x<SIZE;x++) {
				arr[x][z]=0;
			}
		}
	}
	public static ArrayList<int[]> list;
	public static int ddi[]= {0,-1,0,1},ddj[]= {-1,0,1,0},cnt,sum;
	private static void dfs(int i, int j,int num) {
		list.add(new int[] {i,j});
		v[i][j]=num;
		sum+=arr[i][j];
		cnt++;
		for(int z=0;z<4;z++) {
			int newx = i+ddi[z];
			int newy = j+ddj[z];
			int NEWX = i+di[z];
			int NEWY = j+dj[z];
			if(newx>=0 && newy<SIZE && newy>=0 && newx<SIZE && arr[newx][newy]==-1) {
				if(v[NEWX][NEWY]==0) {
					dfs(NEWX,NEWY,num);
				}
			}
		}
	}
}
