import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_모의_보호필름_시간초과 {
	public static int r,c,arr[][],pass,copy[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_보호필름.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			r = Integer.parseInt(s[0]);
			c = Integer.parseInt(s[1]);
			arr = new int[r][c];
			pass = Integer.parseInt(s[2]);
			for(int z=0;z<r;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<c;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			if(pass==1) {
				System.out.println("#"+(i+1)+" "+0);
				continue;
			}
			copy = new int[r][c];
			for(int z=0;z<r;z++) {
				for(int x=0;x<c;x++) {
					copy[z][x] = arr[z][x];
				}
			}
			
			int cur = 0;
			while(true) {
				if(f) break;
				if(cur>pass) break;
				res = new int[cur];
				v = new int[r];
				comb(cur,0);
				cur++;
			}
			
			System.out.println("#"+(i+1)+" "+ans);
			f=false;
		}

	}
	public static boolean f;
	public static int res[],ans,v[];
	private static void comb(int cur, int count) {
		if(f) return;
		if(cur==count) {
			//res = new int[] {2,5};
			check(arr,res);
			if(f) {
				//System.out.println(Arrays.toString(res));
				ans=res.length;
				return;
			}
		}
		else {
			for(int i=0;i<r;i++) {
				if(v[i]==0) {
					v[i]=1;
					res[count]=i;
					comb(cur,count+1);
					v[i]=0;
				}
			}
		}
	}
	
	private static void check(int[][] arrs, int[] res) {
		
		if(res.length>=1) {
	case1:	for(int z=0;z<(1<<res.length);z++) {
				ArrayList<Integer> Alist = new ArrayList<>();
				ArrayList<Integer> Blist = new ArrayList<>();
				for(int k=0;k<res.length;k++) {
					if((z&(1<<k))>0) {
						Alist.add(res[k]);
					}
					else {
						Blist.add(res[k]);
					}
				}
				
				for(int a : Alist) {
					for(int q=0;q<c;q++) arrs[a][q]=0;
				}
				for(int b : Blist) {
					for(int q=0;q<c;q++) arrs[b][q]=1;
				}
				
				int checkcnt=0;
	case2:		for(int col = 0;col<c;col++) {
					for(int q=0;q<=r-pass;q++) {
						int pop = 0 ;
						int cur = arrs[q][col];
						for(int p = 1;p<pass;p++) {
							if(cur==arrs[q+p][col]) pop++;
						}
						if(pop==pass-1) {
							checkcnt++;
							continue case2;
						}
						else if(q==r-pass) {
							for(int a : Alist) {
								for(int w=0;w<c;w++) arrs[a][w] = copy[a][w];
							}
							for(int b : Blist) {
								for(int w=0;w<c;w++) arrs[b][w] = copy[b][w];
							}
							continue case1;
						}
						else continue;
					}
				}
				if(checkcnt==c) {
					f=true;
					return;
				}
			}
		}
		else if(res.length==0) {
			int checkcnt=0;
case3:		for(int col = 0;col<c;col++) {
				for(int q=0;q<=r-pass;q++) {
					int pop = 0 ;
					int cur = arrs[q][col];
					for(int p = 1;p<pass;p++) {
						if(cur==arrs[q+p][col]) pop++;
					}
					if(pop==pass-1) {
						checkcnt++;
						continue case3;
					}
					else if(q==r-pass) {
						continue case3;
					}
					else continue;
				}
			}
			if(checkcnt==c) {
				f=true;
				return;
			}
		}
	}

}
