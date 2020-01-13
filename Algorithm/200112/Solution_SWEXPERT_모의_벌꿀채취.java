import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Solution_SWEXPERT_모의_벌꿀채취 {
	public static int size,v[][],rightmax,arr[][],takeggulmax;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_벌꿀.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			size = Integer.parseInt(s[0]);
			arr = new int[size][size];
			rightmax = Integer.parseInt(s[1]);
			takeggulmax = Integer.parseInt(s[2]);
			
			for(int z=0;z<size;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			max=0;
			v = new int[size][size];
			res = new int[2][2];
			comb(0);
			System.out.println("#"+(i+1)+" "+max);
		}

	}
	public static int res[][],max;
	private static void comb(int count) {
		if(count==2) {
			HashSet<String> set = check(rightmax,res);
			if(set!=null) {
				int sum = 0;
				int[][] check = new int[size][size];
				for(String a:set) {
					int csum=0;
					String ss[] = a.split(" ");
					int curx = Integer.parseInt(ss[0]);
					int cury = Integer.parseInt(ss[1]);
					
					int[] compaArr = new int[rightmax];
					for(int z=0;z<rightmax;z++) {
						csum+=arr[curx][cury+z];
						compaArr[z] = arr[curx][cury+z];
					}
					
					if(csum<=takeggulmax) {
						for(int k=0;k<rightmax;k++) {
							sum+=Math.pow(arr[curx][cury+k], 2);
						}
					}
					else {
						int maxi=0;
						for(int z=0;z<(1<<rightmax);z++) {
							int cursum=0;
							int addsum = 0;
							for(int k=0;k<rightmax;k++) {
								if((z&(1<<k))>0) {
									cursum+=compaArr[k];
									addsum+=Math.pow(compaArr[k], 2);
								}
							}
							if(cursum<=takeggulmax) {
								if(addsum>maxi) maxi = addsum;
							}
						}
						sum+=maxi;
					}
					
				}
				
				if(sum>max) max = sum;
			}
			return ;
		}
		for(int z=0;z<size;z++) {
			for(int x=0;x<size;x++) {
				if(v[z][x] == 0) {
					v[z][x] = 1;
					res[count] = new int[] {z,x};
					comb(count+1);
					v[z][x] = 0;
				}
			}
		}
	}
	
	private static HashSet<String> check(int rightmax, int[][] res) {
		HashSet<String> set = new HashSet<>();
		for(int[] a:res) {
			boolean f=false;
			for(int k=0;k<rightmax;k++) {
				int cur = a[1]+k;
				if(cur>=0 && cur<size) {
					f=true;
				}
				else f=false;
				if(k==rightmax-1 && f) {
					set.add(""+a[0]+" "+a[1]);
				}
			}
		}
		HashSet<String> resSet = new HashSet<>();
		for(String s:set) {
			String ss[] = s.split(" ");
			int x = Integer.parseInt(ss[0]);
			int y = Integer.parseInt(ss[1]);
			for(int z=0;z<rightmax;z++) {
				resSet.add(""+x+" "+(z+y));
			}
		}
		if(resSet.size()==rightmax*2) {
			return set;
		}
		else {
			return null;
		}
	}

}
