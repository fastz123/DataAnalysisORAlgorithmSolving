import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_15683_감시 {
	public static int map[][],N,M;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_감시.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s= br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];
		int c = 0;
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<M;x++) {
				map[z][x] = Integer.parseInt(s[x]);
				if(map[z][x]==0) c++;
			}
		}
		min = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(min);
	}

	public static int di[]= {0,-1,0,1},dj[]= {-1,0,1,0},min;
	private static void dfs(int i, int j) {
		if(i==N && j==0) {
			int cnt = check();
			if(min>cnt) {
//				printmap();
				min = cnt;
			}
			return;
		}
		if(map[i][j]==0 || map[i][j]>=9 || map[i][j]==6) {
			if(j+1<M) dfs(i,j+1);
			else dfs(i+1,0);
		}
		else {
			if(map[i][j]==1) {
				for(int z=0;z<4;z++) {
					int curx=i;
					int cury=j;
					while(true) {
						curx+=di[z];
						cury+=dj[z];
						if(curx>=0&& curx<N && cury>=0 && cury<M && map[curx][cury]>=1 && map[curx][cury]<=5) {
							continue;
						}
						else if(curx>=0&& curx<N && cury>=0 && cury<M && (map[curx][cury]>=9 ||map[curx][cury]==0)) {
							map[curx][cury]+=9;
						}
						else {
							break;
						}
					}
					if(j+1<M) dfs(i,j+1);
					else dfs(i+1,0);
					//복구
					curx=i;
					cury=j;
					while(true) {
						curx+=di[z];
						cury+=dj[z];
						if(curx>=0&& curx<N && cury>=0 && cury<M && map[curx][cury]>=1 && map[curx][cury]<=5) {
							continue;
						}
						else if(curx>=0&& curx<N && cury>=0 && cury<M && (map[curx][cury]>=9 ||map[curx][cury]==0)) {
							map[curx][cury]-=9;
						}
						else {
							break;
						}
					}
				}
			}
			else if(map[i][j]==2) {
				//상하
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				//복구
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				
				//좌우
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				//복구
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
			}
			else if(map[i][j]==3) {
				//상우
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				//복구
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				//우하
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				//하좌
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				//좌상
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
			}
			else if(map[i][j]==4) {
				//좌상우
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				//상우하
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				//복구
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				//우하좌
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				//하좌상
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
			}
			else if(map[i][j]==5) {
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]+=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]+=9;
					}
					else break;
				}
				if(j+1<M) dfs(i,j+1);
				else dfs(i+1,0);
				for(int curx = i+1 ; curx<N;curx++) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int cury = j-1;cury>=0;cury--) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
				for(int curx = i-1;curx>=0;curx--) {
					if(map[curx][j]>=1 && map[curx][j]<=5) continue;
					if(map[curx][j]!=6) {
						map[curx][j]-=9;
					}
					else break;
				}
				for(int cury = j+1 ; cury<M;cury++) {
					if(map[i][cury]>=1 && map[i][cury]<=5) continue;
					if(map[i][cury]!=6) {
						map[i][cury]-=9;
					}
					else break;
				}
			}
		}
	}
	private static void printmap() {
		for(int[] a:map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("-----------------");
		
	}
	private static int check() {
		int cnt=0;
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				if(map[z][x]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	

}
