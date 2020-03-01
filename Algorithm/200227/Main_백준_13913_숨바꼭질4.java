import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_백준_13913_숨바꼭질4 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_숨바꼭질4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int me = Integer.parseInt(s[0]);
		you = Integer.parseInt(s[1]);
		
		v = new boolean[100000*2];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {me,0});
		min = Integer.MAX_VALUE;
		
		int time=0;
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			if(cur[1]==you) {
				if(min>cur[1]) {
					min = cur[1];
				}
			}
			
			if(cur[1]>min) continue;
			if(cur[0]<0) continue;
			
			
			int newx3 = cur[0]*2;
			q.offer(new int[] {newx3,cur[1]*2});
			int newx1 = cur[0]-1;
			q.offer(new int[] {newx1,cur[1]+1});
			int newx2 = cur[0]+1;
			q.offer(new int[] {newx2,cur[1]-1});
		}
		
//		System.out.println(min);
//		while(!stack.isEmpty()) System.out.println();
	}

	public static int you,min;
	public static boolean v[];
//	private static void dfs(int me, Stack<Integer> stack,int time) {
//		if(time>min) return;
//		if(me<0) return;
//		if(me==you && time==4) {
//			if(time<min) {
//				min = time;
//				res = new ArrayList<>();
//				for(int a:list) res.add(a);
//			}
//			return;
//		}
//		else {
//			
//			if(me<you) {
//				
//				//순간이동
//				int telpo = 2*me;
//				if(!list.contains(telpo)) {
//					list.add(telpo);
//					dfs(telpo,list,time+1);
//					list.remove(list.size()-1);
//				}
//				if(!list.contains(me+1)) {
//					//우로 이동
//					list.add(me+1);
//					dfs(me+1,list,time+1);
//					list.remove(list.size()-1);
//				}
//				if(!list.contains(me-1)) {
//					//좌로 이동
//					list.add(me-1);
//					dfs(me-1,list,time+1);
//					list.remove(list.size()-1);
//				}
//			}
//			else {
//				if(!list.contains(me-1)) {
//					//이동
//					list.add(me-1);
//					dfs(me-1,list,time+1);
//					list.remove(list.size()-1);
//				}
//			}
//		}
//	}

}
