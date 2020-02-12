import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main_백준_17135_캐슬디펜스2 {
	public static int map[][],N,M,copy[][],cnt,len;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_캐슬디펜스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		len = Integer.parseInt(s[2]);
		
		N++;
		
		map = new int[N][M];
		copy = new int[N][M];
		cnt=0;
		for(int z=0;z<N-1;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<M;x++) {
				map[z][x] = Integer.parseInt(s[x]);
				copy[z][x] = map[z][x];
				if(map[z][x]==1) cnt++;
			}
		}
		max = Integer.MIN_VALUE;
		dfs(0,0);
		System.out.println(max);
	}
	public static int max;
	private static void dfs(int idx, int cnt) {
		if(cnt==3) {
			int cat = check();
			if(max<cat) {
				max = cat;
			}
			restore(map,copy);
			
			return;
		}
		if(idx>=M) return;
		else {
			
			//각자리마다 넣어주고 복원
			map[N-1][idx]=7;
			dfs(idx+1,cnt+1);
			map[N-1][idx]=0;
			
			//안넣음
			dfs(idx+1,cnt);
		}
		
	}

	private static void restore(int[][] map2, int[][] copy2) {
		for(int z=0;z<N-1;z++) {
			for(int x=0;x<M;x++) {
				map2[z][x] = copy2[z][x];
			}
		}
	}

	private static int check() {
		int cnt=0;
		int m = 0;
		while(true) {
			if(m==N-1) {
				break;
			}
			HashSet<String> delset = new HashSet();
			for(int z=0;z<M;z++) {
				if(map[N-1][z]==7) {
					ArrayList<String> list = new ArrayList<>();
					for(int p=N-1-len;p<N-1;p++) {
						for(int q=z-len;q<z+len;q++) {
							if(p>=0&& p<N && q>=0 && q<M && map[p][q]==1) {
								int curlen = Math.abs(N-1-p)+Math.abs(q-z);
								if(curlen<=len) list.add(""+p+" "+q+" "+curlen);
							}
						}
					}
					Collections.sort(list,new Comparator<String>() {
						@Override
						public int compare(String o1, String o2) {
							String[] so1 = o1.split(" ");
							String[] so2 = o2.split(" ");
							if(!so1[2].equals(so2[2])) {
								return Integer.compare(Integer.parseInt(so1[2]), Integer.parseInt(so2[2]));
							}
							else {
								return Integer.compare(Integer.parseInt(so1[1]), Integer.parseInt(so2[1]));
							}
						}
					});
					if(list.size()>0) {
						String curs[] = list.get(0).split(" ");
						String x = curs[0];
						String y = curs[1];
						delset.add(""+x+" "+y);
					}
				}
			}
			ArrayList<String> dellist = new ArrayList<>(delset);
			for(String s : dellist) {
				cnt++;
				String[] ss = s.split(" ");
				int x = Integer.parseInt(ss[0]);
				int y = Integer.parseInt(ss[1]);
				map[x][y]=0;
			}
			down();
			m++;
		}
		return cnt;
	}

	private static void down() {
		for(int z=0;z<M;z++) {
			int cx = N-1;
			while(true) {
				cx--;
				if(cx==-1) break;
				if(map[cx][z]==1 && cx<N-2) {
					map[cx][z]=0;
					map[cx+1][z]=1;
				}
				else if(map[cx][z]==1 && cx==N-2) {
					map[cx][z]=0;
				}
			}
		}
	}

	private static void printmap() {
		for(int z=0;z<N;z++) {
			for(int x=0;x<M;x++) {
				System.out.print(map[z][x]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

}
