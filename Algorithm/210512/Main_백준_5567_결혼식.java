package algo2;import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.Arrays;import java.util.Collections;import java.util.LinkedList;import java.util.Queue;
import java.io.FileInputStream;

public class Main_백준_5567_결혼식 {
	static int N,M,ans;	static LinkedList<Integer> list[], alist;	static boolean v[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_결혼식.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());		M = Integer.parseInt(br.readLine());				list = new LinkedList[N];		for(int z=0;z<N;z++) list[z] = new LinkedList<>();		alist = new LinkedList<>();		for(int z=0;z<M;z++) {			String s[] = br.readLine().split(" ");			int st = Integer.parseInt(s[0])-1;			int end = Integer.parseInt(s[1])-1;						list[st].add(end);			list[end].add(st);		}				v = new boolean[N];		v[0]=true;		ans=0;		dfs(0,0);//		bfs(0,0);//		int cnt = 0;//		for(boolean vv : v) {//			if(vv) cnt++;//		}//		System.out.println(cnt-1);		System.out.println(Arrays.toString(v));		System.out.println(ans);	}	static Queue<int[]> q;	private static void bfs(int cur, int depth) {		q = new LinkedList<>();		q.offer(new int[] {cur,depth});		while(!q.isEmpty()) {			int[] c = q.poll();			if(c[1]>=2) continue;			for(int cc : list[c[0]]) {				ans++;				v[cc]=true;				q.offer(new int[] {cc,c[1]+1});			}		}	}	private static void dfs(int cur, int depth) {		if(depth>=2) return;				for(int c : list[cur]) {			ans++;			v[cur] = true;			dfs(c,depth+1);		}	}

}
