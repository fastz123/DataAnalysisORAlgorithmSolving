package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_1327_소트게임 {
	public static class C{
		StringBuffer arr;
		int cnt;
		public C(StringBuffer arr, int cnt) {
			this.arr = arr;
			this.cnt = cnt;
		}
	}
	public static boolean v[];
	public static int n, k,min,arrays[];
	public static HashMap<String,Boolean> map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_소트게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);
		arrays = new int[n];
		StringBuffer arr = new StringBuffer();
		s = br.readLine().split(" ");
		for(int z=0;z<n;z++) {
			arr.append(s[z]);
			arrays[z] = Integer.parseInt(s[z]);
		}
		
		Arrays.sort(arrays);
		
		map = new HashMap<>();
		
		min = Integer.MAX_VALUE;
		q = new LinkedList<>();
//		map.put(arr.toString(), true);
		q.offer(new C(arr,0));
		bfs();
		
		System.out.println(min==Integer.MAX_VALUE? -1:min);
	}

	public static Queue<C> q;
	private static void bfs() {
		while(!q.isEmpty()) {
			C cur = q.poll();
			
			if(check(cur.arr)) {
				min = Math.min(cur.cnt, min);
				return;
			}
			
			if(map.get(cur.arr.toString())==null) {
				map.put(cur.arr.toString(),true);
				for(int i=0;i<=n-k;i++) {
					StringBuffer sb = new StringBuffer();
					sb.append(cur.arr);
					int st = i;
					int end = i+k;
					StringBuffer sub = new StringBuffer();
					sub.append(sb.toString().substring(st,end));
					sub = sub.reverse();
					sb.replace(st, end, sub.toString());
					q.offer(new C(sb,cur.cnt+1));
				}
			}
		}
	}
	
	private static boolean check(StringBuffer arr) {
		int len = arr.length();
		for(int i=0;i<len;i++) {
			int cur = arr.charAt(i)-'0';
			if(arrays[i]!=cur) return false;
		}
		return true;
	}

}
