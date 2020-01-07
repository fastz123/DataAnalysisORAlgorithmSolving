package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEXPERT_모의_탈주범검거 {
	public static int v[][],arr[][],time,N,M;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_Ż�ֹ��˰�.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			int mx = Integer.parseInt(s[2]);
			int my = Integer.parseInt(s[3]);
			time = Integer.parseInt(s[4]);
			
			arr = new int[N][M];
			for(int z=0;z<N;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<M;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			v = new int[N][M];
			cnt=0;
			bfs(mx,my);
			//check(v);
			System.out.println("#"+(i+1)+" "+cnt);
		}
	}
	public static Queue<int[]> q = new LinkedList<>();
	public static int cnt,di1[]= {0,-1,0,1},dj1[]= {-1,0,1,0};
	public static int di2[]= {-1,1},dj2[]= {0,0};
	public static int di3[]= {0,0},dj3[]= {-1,1};
	public static int di4[]= {-1,0},dj4[]= {0,1};
	public static int di5[]= {1,0},dj5[]= {0,1};
	public static int di6[]= {0,1},dj6[]= {-1,0};
	public static int di7[]= {0,-1},dj7[]= {-1,0};
	private static void bfs(int mx, int my) {
		q.offer(new int[] {mx,my,1});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(v[cur[0]][cur[1]]==0) {
				v[cur[0]][cur[1]]=cur[2];
				cnt++;
			}
			if(arr[cur[0]][cur[1]]==1) {
				for(int z=0;z<4;z++) {
					int newx = cur[0]+di1[z];
					int newy = cur[1]+dj1[z];
					if(newx>=0 && newx<N && newy>=0 && newy<M && v[newx][newy]==0 && arr[newx][newy]>0 && cur[2]<time) {
						if(z==0) {//��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 3 || arr[newx][newy] == 4 || arr[newx][newy] == 5) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else if(z==1) {//��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 2 || arr[newx][newy] == 5 || arr[newx][newy] == 6) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else if(z==2) { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 3 || arr[newx][newy] == 6 || arr[newx][newy] == 7) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else { // ��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 2 || arr[newx][newy] == 4 || arr[newx][newy] == 7) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
				}
			}
			else if(arr[cur[0]][cur[1]]==2) {
				for(int z=0;z<2;z++) {
					int newx = cur[0]+di2[z];
					int newy = cur[1]+dj2[z];
					if(newx>=0 && newx<N && newy>=0 && newy<M && v[newx][newy]==0 && arr[newx][newy]>0 && cur[2]<time) {
						if(z==0) { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 2 || arr[newx][newy] == 5 || arr[newx][newy] == 6) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 2 || arr[newx][newy] == 4 || arr[newx][newy] == 7) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
				}
			}
			else if(arr[cur[0]][cur[1]]==3) {
				for(int z=0;z<2;z++) {
					int newx = cur[0]+di3[z];
					int newy = cur[1]+dj3[z];
					if(newx>=0 && newx<N && newy>=0 && newy<M && v[newx][newy]==0 && arr[newx][newy]>0 && cur[2]<time) {
						if(z==0) {	//��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 3 || arr[newx][newy] == 4 || arr[newx][newy] == 5) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 3 || arr[newx][newy] == 6 || arr[newx][newy] == 7) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
				}
			}
			else if(arr[cur[0]][cur[1]]==4) {
				for(int z=0;z<2;z++) {
					int newx = cur[0]+di4[z];
					int newy = cur[1]+dj4[z];
					if(newx>=0 && newx<N && newy>=0 && newy<M && v[newx][newy]==0 && arr[newx][newy]>0 && cur[2]<time) {
						if(z==0) { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 2 || arr[newx][newy] == 5 || arr[newx][newy] == 6) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 3 || arr[newx][newy] == 6 || arr[newx][newy] == 7) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
				}
			}
			else if(arr[cur[0]][cur[1]]==5) {
				for(int z=0;z<2;z++) {
					int newx = cur[0]+di5[z];
					int newy = cur[1]+dj5[z];
					if(newx>=0 && newx<N && newy>=0 && newy<M && v[newx][newy]==0 && arr[newx][newy]>0 && cur[2]<time) {
						if(z==0) { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 2 || arr[newx][newy] == 4 || arr[newx][newy] == 7) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 3 || arr[newx][newy] == 6 || arr[newx][newy] == 7) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
				}
			}
			else if(arr[cur[0]][cur[1]]==6) {
				for(int z=0;z<2;z++) {
					int newx = cur[0]+di6[z];
					int newy = cur[1]+dj6[z];
					if(newx>=0 && newx<N && newy>=0 && newy<M && v[newx][newy]==0 && arr[newx][newy]>0 && cur[2]<time) {
						if(z==0) { // ��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 3 || arr[newx][newy] == 4 || arr[newx][newy] == 5) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else { //��
							if(arr[newx][newy] == 1 || arr[newx][newy] == 2 || arr[newx][newy] == 4 || arr[newx][newy] == 7) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
				}
			}
			else if(arr[cur[0]][cur[1]]==7) {
				for(int z=0;z<2;z++) {
					int newx = cur[0]+di7[z];
					int newy = cur[1]+dj7[z];
					if(newx>=0 && newx<N && newy>=0 && newy<M && v[newx][newy]==0 && arr[newx][newy]>0 && cur[2]<time) {
						if(z==0) {
							if(arr[newx][newy] == 1 || arr[newx][newy] == 3 || arr[newx][newy] == 4 || arr[newx][newy] == 5) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
						else {
							if(arr[newx][newy] == 1 || arr[newx][newy] == 2 || arr[newx][newy] == 5 || arr[newx][newy] == 6) {
								q.offer(new int[] {newx,newy,cur[2]+1});
							}
						}
					}
				}
			}
		}
	}

}
