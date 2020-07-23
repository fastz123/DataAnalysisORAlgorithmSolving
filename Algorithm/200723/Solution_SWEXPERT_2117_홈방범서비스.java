import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.Arrays;
import java.io.FileInputStream;

public class Solution_SWEXPERT_2117_홈방범서비스 {
	public static int N,M,map[][],max;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_홈방범서비스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());		for(int i=1;i<=T;i++) {			String[] s = br.readLine().split(" ");			N = Integer.parseInt(s[0]);			M = Integer.parseInt(s[1]);						map = new int[N][N];			for(int z=0;z<N;z++) {				s = br.readLine().split(" ");				for(int x=0;x<N;x++) {					map[z][x] = Integer.parseInt(s[x]);				}			}						max = Integer.MIN_VALUE;			for(int z=0;z<N;z++) {				for(int x=0;x<N;x++) {					for(int k=1;k<=(N+1);k++) {						int cur = k-1;						int area = 1+(2*cur*cur)+(2*cur);						if(max > area) continue;						check(cur,z,x,area);					}				}			}						System.out.println("#"+i+" "+max);		}
		
	}	private static void check(int k, int z, int x,int area) {		int cnt = 0;		for(int p=z-k;p<=z+k;p++) {			for(int q=x-k;q<=x+k;q++) {				if(p>=0 && p<N && q>=0 && q<N) {					int distance = Math.abs(p-z)+Math.abs(q-x);					if(distance <= k) {						if(map[p][q] == 1) cnt++;					}				}			}		}				int curM = cnt*M - area;		if(curM>=0) max = Math.max(max, cnt);	}

}
