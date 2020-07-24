import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.Arrays;
import java.io.FileInputStream;

public class Solution_SWEXPERT_4014_활주로건설 {
	public static int N,map[][],len;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_활주로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());		for(int i=1;i<=T;i++) {			String[] s = br.readLine().split(" ");			N = Integer.parseInt(s[0]);			len = Integer.parseInt(s[1]);						map = new int[N][N];			for(int z=0;z<N;z++) {				s = br.readLine().split(" ");				for(int x=0;x<N;x++) {					map[z][x] = Integer.parseInt(s[x]);				}			}						System.out.println("#"+i+" "+check());		}
		
	}	private static int check() {		//가로		int cnt1 = 0;case1:	for(int z=0;z<N;z++) {			boolean v[] = new boolean[N];			for(int x=0;x<N-1;x++) {				if(map[z][x] == map[z][x+1]) continue;				else if(map[z][x]-map[z][x+1] == 1) {//하강					int cury = x+1;					int val = map[z][x+1];					for(int k=cury;k<cury+len;k++) {						if((k == N) || v[k] || (val != map[z][k])) continue case1;					}					for(int k=cury;k<cury+len;k++) {						v[k] = true;					}				}				else if(map[z][x]-map[z][x+1] == -1) {//상승					int cury = x;					int val = map[z][x];					for(int k = cury;k>cury-len;k--) {						if((k == -1) || v[k] || (val != map[z][k])) continue case1;					}					for(int k=cury;k>cury-len;k--) v[k] = true;				}				else continue case1;			}			cnt1++;		}				//세로		int cnt2 = 0;case2:	for(int x=0;x<N;x++) {			boolean v[] = new boolean[N];			for(int z=0;z<N-1;z++) {				if(map[z][x] == map[z+1][x]) continue;				else if(map[z][x]-map[z+1][x]==1) { //하강					int curx = z+1;					int val = map[z+1][x];					for(int k=curx;k<curx+len;k++) {						if((k == N) || v[k] || (val!= map[k][x])) continue case2;					}					for(int k=curx;k<curx+len;k++) {						v[k]=true;					}				}				else if(map[z][x]-map[z+1][x] == -1) {//상승					int curx = z;					int val = map[z][x];					for(int k=curx;k>curx-len;k--) {						if((k == -1) || v[k] || (val != map[k][x])) continue case2;					}					for(int k=curx;k>curx-len;k--) {						v[k]=true;					}				}				else continue case2;			}			cnt2++;		}		return cnt1+cnt2;	}
	
}
