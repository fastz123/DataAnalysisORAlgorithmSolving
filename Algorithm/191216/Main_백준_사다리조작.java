import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_백준_사다리조작 {
	public static boolean v[];
	public static int row,col;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_사다리조작.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[]  = br.readLine().split(" ");
		
		col = Integer.parseInt(s[0]);
		int cnt = Integer.parseInt(s[1]);
		row = Integer.parseInt(s[2]);
		
		int[][] arr = new int[row][col*2-1];
		
		for(int z=0;z<col*2-1;z+=2) {
			int st=0;
			while(true) {
				if(st==row) break;
				arr[st][z]=1;
				st++;
			}
		}
		//System.out.println();
		int ans=0;
		for(int z=0;z<cnt;z++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0])-1;
			int y = Integer.parseInt(s[1])-1;
			arr[x][y*2+1]=1;
		}
		
		ArrayList<int[]> list = new ArrayList<>();
		
		if(col<3) {
			for(int z=0;z<row;z++) {
				for(int x=0;x<col*2-1;x++) {
					if(arr[z][x]==0) list.add(new int[] {z,x});
				}
			}
		}
		else {
			for(int z=0;z<row;z++) {
				for(int x=0;x<col*2-1;x++) {
					if(x-2>=0 && x<col*2-1-2 && arr[z][x]==0 && (arr[z][x-2]!=1 && arr[z][x+2]!=1)) {
						list.add(new int[] {z,x});
					}
					else if(col>=3 && x==1 && arr[z][x]==0 && arr[z][x+2]!=1) list.add(new int[] {z,x});
					else if(col>=3 && x==2*col-1-2 && arr[z][x]==0 && arr[z][x-2]!=1) list.add(new int[] {z,x});
				}
			}
		}
		res = new ArrayList<>();
		v = new boolean[list.size()];
		ans = comb(0,0,list,arr);
		if(ans!=5) System.out.println(ans);
		if(ans==5) System.out.println(-1);
		//System.out.println(-1);
	}

	public static ArrayList<int[]> res;
	public static boolean f;
	public static int result=5;
	private static int comb(int start, int count, ArrayList<int[]> list,int[][] arr) {
		if(count==0) {
			f = check(arr);
			if(f) {
				int cur=0; 
				if(cur<result) result=0;
				return result;
			}
		}
		if(count==1) {
			for(int[] a:res) {
				int x = a[0];
				int y = a[1];
				arr[x][y]=1;
			}
			f = check(arr);
			for(int[] a:res) {
				int x = a[0];
				int y = a[1];
				arr[x][y]=0;
			}
			if(f) {
				int cur=1; 
				if(cur<result) result=1;
				return result;
			}
		}
		if(count==2) {
			for(int[] a:res) {
				int x = a[0];
				int y = a[1];
				arr[x][y]=1;
			}
			f = check(arr);
			for(int[] a:res) {
				int x = a[0];
				int y = a[1];
				arr[x][y]=0;
			}
			if(f) {
				int cur=2; 
				if(cur<result) result=2;
				return result;
			}
		}
		if(count==3) {
			for(int[] a:res) {
				int x = a[0];
				int y = a[1];
				arr[x][y]=1;
			}
			f = check(arr);
			for(int[] a:res) {
				int x = a[0];
				int y = a[1];
				arr[x][y]=0;
			}
			if(f) {
				int cur=3; 
				if(cur<result) result=3;
				return result;
			}
		}
		if(count>=0 && count<3) {
			for(int i=0;i<list.size();i++) {
				if(!v[i]) {
					v[i]=true;
					res.add(list.get(i));
					comb(i,count+1,list,arr);
					res.remove(res.size()-1);
					v[i]=false;
				}
			}
		}
		return result;
	}
	
	
	private static boolean check(int[][] arr) {
		
		for(int z=0;z<col*2-1;z+=2) {
			int stx = row;
			int cury = z;
			while(true) {
				if(stx==0) {
					if(cury != z) {
						
						return false;
					}
					else break;
				}
				stx--;
				if(cury>0 && arr[stx][cury-1]==1) {
					cury-=2;
					if(stx==0) {
						if(cury != z) {
							
							return false;
						}
						else break;
					}
					continue;
				}
				if(cury<col*2-1-1 && arr[stx][cury+1]==1) {
					cury+=2;
					if(stx==0) {
						if(cury != z) {
							
							return false;
						}
						else break;
					}
					continue;
				}
			}
		}
		
		
		return true;
	}

}
