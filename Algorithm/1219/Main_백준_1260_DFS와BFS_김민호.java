import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_1260_DFS와BFS_김민호 {
	public static int vd[],vb[],point,arr[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D와B.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String s[] =br.readLine().split(" ");
		
		point = Integer.parseInt(s[0]);
		arr = new int[point][point];
		int line = Integer.parseInt(s[1]);
		int st_point = Integer.parseInt(s[2])-1;
		
		for(int z=0;z<line;z++) {
			s = br.readLine().split(" ");
			int st = Integer.parseInt(s[0])-1;
			int to = Integer.parseInt(s[1])-1;
			
			arr[st][to]=1;
			arr[to][st]=1;
		}

		vd = new int[point];
		vd[st_point]=1;
		System.out.print((st_point+1)+" ");
		dfs(st_point);
		System.out.println();
		vb = new int[point];
		vb[st_point]=1;
		System.out.print((st_point+1)+" ");
		bfs(st_point);
	}

	public static Queue<Integer> q = new LinkedList<>();
	private static void bfs(int i) {
		q.offer(i);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int z=0;z<point;z++) {
				if(vb[z]==0 && arr[cur][z]==1) {
					vb[z]=1;
					System.out.print((z+1)+" ");
					q.offer(z);
				}
			}
		}
	}

	private static void dfs(int i) {
		for(int z=0;z<point;z++) {
			if(arr[i][z]==1 && vd[z]==0) {
				vd[z]=1;
				System.out.print((z+1)+" ");
				dfs(z);
			}
		}
	}

}
