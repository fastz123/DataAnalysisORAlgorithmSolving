import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main_백준_17135_캐슬디펜스 {
	public static int x,y,totcnt,arr[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_캐슬디펜스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		int len = Integer.parseInt(s[2]);
		
		arr = new int[x][y];
		
		for(int z=0;z<x;z++) {
			s= br.readLine().split(" ");
			for(int a=0;a<y;a++) {
				arr[z][a]=Integer.parseInt(s[a]);
				if(arr[z][a]==1) totcnt++;
			}
		}

		ArrayList<Integer> list;
		max = Integer.MIN_VALUE;
		for(long z=0;z<(1<<y);z++) {
			int cnt=0;
			//z=14;
			list = new ArrayList<>();
			for(int k=0;k<y;k++) {
				if((z&(1<<k))>0) {
					list.add(k);
					cnt++;
				}
			}
			if(cnt==3) {
//				for(int q:list) System.out.print(q+" ");
//				System.out.println();
				check(list,len,arr);
			}
		}
		System.out.println(max);
	}

	private static void check(ArrayList<Integer> list,int len,int[][] arr) {
		
		int MoveandShot[][] = new int[x+1][y];
		copying(MoveandShot);
		int deathcnt=0;
		int huntcnt=0;
		while(true) {
			//���
			shot(MoveandShot,len,list);
			if(res.size()>0) {
				HashSet<String> set = new HashSet<>(res);
				huntcnt += set.size();
				for(String a:set) {
					String s[] = a.split(" ");
					MoveandShot[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=0;
				}
			}
			//�����δ�.
			deathcnt += move(MoveandShot,deathcnt);
			//�ݺ�
			
			if(totcnt==huntcnt+deathcnt) {
				break;
			}
		}
		if(max<huntcnt) max= huntcnt;
	}

	private static int move(int[][] MoveandShot,int deathcnt) {
		int cnt=0;
		for(int z=x-1;z>=0;z--) {
			for(int a=0;a<y;a++) {
				if(z<x-1 && MoveandShot[z][a]==1) {
					MoveandShot[z+1][a]=1;
					MoveandShot[z][a]=0;
				}
				else if(z==x-1 && MoveandShot[z][a]==1) {
					MoveandShot[z][a]=0;
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void copying(int[][] MoveandShot) {
		for(int z=0;z<x;z++) {
			for(int a=0;a<y;a++) {
				MoveandShot[z][a]=arr[z][a];
			}
		}
	}

	public static int max;
	public static ArrayList<String> res; 
	private static void shot(int[][] MoveandShot, int len,ArrayList<Integer> list) {
		for(int a:list) {
			MoveandShot[x][a]=7;
		}
		int cnt=0;
		
		res = new ArrayList<>();
		
case1:	for(int col:list) {
			ArrayList<int[]> canshotlist = new ArrayList<>();
			for(int z=x-1;z>=0;z--) {
				for(int a=0;a<y;a++) {
					if(MoveandShot[z][a]==1 && (Math.abs(z-x)+Math.abs(col-a))<=len) {
						canshotlist.add(new int[] {z,a});
					}
				}
			}
			if(canshotlist.size()>0) {
				Collections.sort(canshotlist, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						
						int len1 = (Math.abs(o1[0]-x))+(Math.abs(o1[1]-col));
						int len2 = (Math.abs(o2[0]-x))+(Math.abs(o2[1]-col));
						
						if(len1 != len2) return Integer.compare(len1, len2);
						else {
							return Integer.compare(o1[1], o2[1]);
						}
					}
				});
				int z = canshotlist.get(0)[0];
				int a = canshotlist.get(0)[1];
				
				res.add(""+z+" "+a);
			}
		}
	}

	

}
