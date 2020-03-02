import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_백준_13913_숨바꼭질4 {
	public static Stack<Integer> stack;
	public static String res;
	public static boolean v[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_숨바꼭질4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int me = Integer.parseInt(s[0]);
		you = Integer.parseInt(s[1]);
		
		if(me==you) {
//			System.out.println(0+"\n"+me);
			System.out.println(0);
			return;
		}
		
		list = new ArrayList<>();
		list.add(me);
		
		min = Integer.MAX_VALUE;
		v = new boolean[(me+you)*2];
//		dfs(me,stack,0);
//		System.out.println(res);
		bfs(me,0);
	}

	public static ArrayList<Integer> list;
	public static Queue<int[]> q = new LinkedList<>();
	private static int bfs(int me, int i) {
		v[me]=true;
		q.offer(new int[] {me,i});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==you) {
				System.out.println(cur[1]);
				for(int a : list) System.out.print(a+" ");
				return cur[1];
			}
			if(cur[0]*2<v.length && !v[cur[0]*2]) {
				v[cur[0]*2]=true;
				list.add(cur[0]*2);
				q.offer(new int[] {cur[0]*2,cur[1]+1});
				list.remove(list.size()-1);
			}
			if(cur[0]+1<v.length && !v[cur[0]+1]) {
				v[cur[0]+1]=true;
				list.add(cur[0]+1);
				q.offer(new int[] {cur[0]+1,cur[1]+1});
				list.remove(list.size()-1);
			}
			if(cur[0]-1>=0 && !v[cur[0]-1]) {
				v[cur[0]-1]=true;
				list.add(cur[0]-1);
				q.offer(new int[] {cur[0]-1,cur[1]+1});
				list.remove(list.size()-1);
			}
		}
		return 0;
	}

	public static int you,min;
	

}
