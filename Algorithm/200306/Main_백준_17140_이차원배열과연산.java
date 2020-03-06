import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main_백준_17140_이차원배열과연산 {
	public static class sett{
		int key;
		int val;
		public sett(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	
	public static int x,y,val;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_이차원배열과연산.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[3][3];
		String[] s= br.readLine().split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		val = Integer.parseInt(s[2]);
		
		for(int z=0;z<3;z++) {
			s = br.readLine().split(" ");
			for(int a=0;a<3;a++) {
				arr[z][a] = Integer.parseInt(s[a]);
			}
		}

		check(arr,0);
		System.out.println(f? res:-1);
	}

	public static boolean f;
	public static int res;
	private static void check(int[][] arr, int i) {
//		printmap(arr);
		if(f) return;
		if(i>100) return;
		int R = arr.length;
		int C = arr[0].length;
		if(x-1<R && y-1<C && arr[x-1][y-1]==val) {
			f = true;
			res = i;
			return;
		}
		
		if(R>=C) {
			ArrayList<sett> list[] = new ArrayList[R];
			for(int z=0;z<R;z++) list[z] = new ArrayList<>();
			for(int z=0;z<R;z++) {
				HashMap<Integer, Integer> map = new HashMap<>();
				for(int k=0;k<C;k++) {
					if(arr[z][k]!=0) {
						if(map.get(arr[z][k]) == null) map.put(arr[z][k], 1);
						else map.put(arr[z][k], map.get(arr[z][k])+1);
					}
				}
				for(Entry<Integer, Integer> cur : map.entrySet()) {
					list[z].add(new sett(cur.getKey(),cur.getValue()));
				}
				Collections.sort(list[z],new Comparator<sett>() {
					@Override
					public int compare(sett o1, sett o2) {
						if(o1.val!=o2.val) {
							return Integer.compare(o1.val, o2.val);
						}
						else {
							return Integer.compare(o1.key,o2.key);
						}
					}
				});
			}
			int maxsize = -1;
			for(ArrayList<sett> cur : list) maxsize = Math.max(cur.size(), maxsize);
			if(maxsize*2>100)  maxsize=50;
			
			int[][] newarr = new int[R][maxsize*2];
			for(int z=0;z<R;z++) {
				ArrayList<sett> cur = list[z];
				int idx = 0;
				for(sett c : cur) {
					if(idx>100) break;
					newarr[z][idx]=c.key;
					newarr[z][idx+1]=c.val;
					idx+=2;
				}
			}
			check(newarr,i+1);
		}
		else {
			ArrayList<sett> list[] = new ArrayList[C];
			for(int z=0;z<C;z++) list[z] = new ArrayList<>();
			for(int z=0;z<C;z++) {
				HashMap<Integer, Integer> map = new HashMap<>();
				for(int k=0;k<R;k++) {
					if(arr[k][z]!=0) {
						if(map.get(arr[k][z]) == null) map.put(arr[k][z], 1);
						else map.put(arr[k][z], map.get(arr[k][z])+1);
					}
				}
				for(Entry<Integer, Integer> cur : map.entrySet()) {
					list[z].add(new sett(cur.getKey(),cur.getValue()));
				}
				Collections.sort(list[z],new Comparator<sett>() {
					@Override
					public int compare(sett o1, sett o2) {
						if(o1.val!=o2.val) {
							return Integer.compare(o1.val, o2.val);
						}
						else {
							return Integer.compare(o1.key,o2.key);
						}
					}
				});
			}
			int maxsize = -1;
			for(ArrayList<sett> cur : list) maxsize = Math.max(cur.size(), maxsize);
			if(maxsize*2>100)  maxsize=50;
			int[][] newarr = new int[maxsize*2][C];
			for(int z=0;z<C;z++) {
				ArrayList<sett> cur = list[z];
				int idx = 0;
				for(sett c : cur) {
					if(idx>100) break;
					newarr[idx][z]=c.key;
					newarr[idx+1][z]=c.val;
					idx+=2;
				}
			}
			check(newarr,i+1);
		}
	}
	private static void printmap(int[][] arr) {
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("-------------------------");
	}
}
