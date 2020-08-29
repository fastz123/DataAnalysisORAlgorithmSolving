package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_백준_6118_숨바꼭질 {
	public static class Node{
		int i;
		int len;
		public Node(int i, int len) {
			this.i = i;
			this.len = len;
		}
	}
	public static ArrayList<Integer> list[];
	public static int v[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		
		list = new ArrayList[N];
		for(int z=0;z<N;z++) list[z] = new ArrayList<Integer>();
		
		for(int z=0;z<M;z++) {
			s = br.readLine().split(" ");
			int st = Integer.parseInt(s[0])-1;
			int end = Integer.parseInt(s[1])-1;
			
			list[st].add(end);
			list[end].add(st);
		}
		
		v = new int[N];
		Arrays.fill(v, Integer.MAX_VALUE);
		
		v[0]=0;
		bfs(0,0);
		
		int max = 0;
		int maxidx = 0;
		int maxcnt = 0;
		for(int z=0;z<N;z++) {
			if(max == Integer.MAX_VALUE) continue;
			else if(max == v[z]) maxcnt++;
			else if(max < v[z]) {
				max = v[z];
				maxidx = z;
				maxcnt=1;
			}
		}
//		System.out.println(Arrays.toString(v));
		bw.write((maxidx+1)+" "+max+" "+maxcnt);
		
		bw.flush();
		bw.close();
		
	}
	
	private static void bfs(int i, int len) {
		Queue<Node> q = new LinkedList();
		Node node = new Node(i,len);
		q.offer(node);
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			ArrayList<Integer> num = list[cur.i];
			for(int z=0;z<num.size();z++) {
				if(v[num.get(z)] > cur.len+1) {
					v[num.get(z)] = cur.len+1;
					q.offer(new Node (num.get(z),cur.len+1));
				}
			}
		}
	}

}
