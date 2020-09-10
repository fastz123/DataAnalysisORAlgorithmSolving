package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution_프로그래머스_섬연결하기 {
	public static class Node{
        int to;
        int len;
        public Node(int end, int len){
            this.to=end;
            this.len=len;
        }
    }
	public static LinkedList<Node> list[];
    public static int v[];
    public static boolean visit[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_섬연결하기.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		int k = list.indexOf(2);
		System.out.println(k);
		int[][] costs = new int[T][3];
		for(int z=0;z<T;z++) {
			String[] s = br.readLine().split(" ");
			costs[z][0] = Integer.parseInt(s[0]);
			costs[z][1] = Integer.parseInt(s[1]);
			costs[z][2] = Integer.parseInt(s[2]);
		}
		
		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2],o2[2]);
			}
		});
		
		v = new int[n];
		int cnt = 0;
		for(int z=0;z<n;z++) v[z] = z;
		
		for(int z=0;z<T;z++) {
			
			int[] cur = costs[z];
			if(find(cur[0]) != find(cur[1])) {
				union(cur);
				cnt+=cur[2];
			}
		}
		System.out.println(Arrays.toString(v));
		System.out.println(cnt);
	}
	private static int find(int i) {
		if(v[i]==i) return i;
		else return v[i] = find(v[i]);
	}
	
	private static void union(int[] cur) {
		int a = find(cur[0]);
		int b = find(cur[1]);
		if(a < b) v[b] = a;
		else v[a]=b;
	}
	
	

}
