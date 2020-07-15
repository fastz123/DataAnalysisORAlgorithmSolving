import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEXPERT_1953_탈주범검거 {

	public static int di[][] = {{0,-1,0,1},{-1,1},{0,0},{-1,0},{0,1},{1,0},{0,-1}}, 
					  dj[][] = {{-1,0,1,0},{0,0},{-1,1},{0,1},{1,0},{0,-1},{-1,0}},
					  N,M,time,map[][];
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_탈주범검거.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			int stx = Integer.parseInt(s[2]);
			int sty = Integer.parseInt(s[3]);
			time = Integer.parseInt(s[4]);
			
			map = new int[N][M];
			for(int z=0;z<N;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<M;x++) {
					map[z][x] = Integer.parseInt(s[x]);
				}
			}
			
			q = new LinkedList<>();
			v = new boolean[N][M];
			v[stx][sty] = true;
			int res = bfs(stx,sty,0);
			System.out.println("#"+(i+1)+" "+(res==0? check():res));
		}

	}
	
	private static Queue<int[]> q;
	private static int bfs(int stx, int sty, int t) {
		q.offer(new int[] {stx,sty,t});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[2] == time-1) {
				int c = check();
				return c;
			}
			
			int num = map[cur[0]][cur[1]]-1;
			
			for(int z=0;z<di[num].length;z++) {
				int newx = cur[0]+di[num][z];
				int newy = cur[1]+dj[num][z];
				
				if(newx>=0 && newx<N && newy>=0 && newy<M && map[newx][newy]!=0 && !v[newx][newy]) {
					if(num == 0) {
						if(z==0) {
							if(map[newx][newy]==3 || map[newx][newy]==4 || map[newx][newy]==5 || map[newx][newy]==1) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else if(z==1) {
							if(map[newx][newy]==2 || map[newx][newy]==5 || map[newx][newy]==6 || map[newx][newy]==1) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else if(z==2) {
							if(map[newx][newy]==3 || map[newx][newy]==6 || map[newx][newy]==7 || map[newx][newy]==1) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else {
							if(map[newx][newy]==2 || map[newx][newy]==4 || map[newx][newy]==7 || map[newx][newy]==1) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
					else if(num==1) { //상하
						if(z==0) {
							if(map[newx][newy]==2 || map[newx][newy]==1 || map[newx][newy]==5 || map[newx][newy]==6) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else if(z==1) {
							if(map[newx][newy]==1 || map[newx][newy]==2 || map[newx][newy]==4 || map[newx][newy]==7) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
					else if(num==2) {//좌우
						if(z==0) {
							if(map[newx][newy]==1 || map[newx][newy]==3 || map[newx][newy]==4 || map[newx][newy]==5) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else if(z==1) {
							if(map[newx][newy]==1 || map[newx][newy]==3 || map[newx][newy]==6 || map[newx][newy]==7) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
					else if(num==3) {//상우
						if(z==0) {
							if(map[newx][newy]==1 || map[newx][newy]==2 || map[newx][newy]==5 || map[newx][newy]==6) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else if(z==1) {
							if(map[newx][newy]==1 || map[newx][newy]==3 || map[newx][newy]==6 || map[newx][newy]==7) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
					else if(num==4) {//우하
						if(z==0) {
							if(map[newx][newy]==1 || map[newx][newy]==3 || map[newx][newy]==6 || map[newx][newy]==7) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else {
							if(map[newx][newy]==1 || map[newx][newy]==2 || map[newx][newy]==4 || map[newx][newy]==7) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
					else if(num==5) {//하좌
						if(z==0) {
							if(map[newx][newy]==1 || map[newx][newy]==2 || map[newx][newy]==4 || map[newx][newy]==7) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else {
							if(map[newx][newy]==1 || map[newx][newy]==3 || map[newx][newy]==4 || map[newx][newy]==5) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
					else if(num==6) {//좌상
						if(z==0) {
							if(map[newx][newy]==1 || map[newx][newy]==3 || map[newx][newy]==4 || map[newx][newy]==5) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else {
							if(map[newx][newy]==1 || map[newx][newy]==2 || map[newx][newy]==5 || map[newx][newy]==6) {
								v[newx][newy] = true;
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
					
//					v[newx][newy] = true;
//					q.offer(new int[] {newx,newy,cur[2]+1});
				}
			}
		}
		return 0;
	}
	private static int check() {
		int cnt = 0;
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(v[z][x]) cnt++;
			}
		}
		return cnt;
	}

}
