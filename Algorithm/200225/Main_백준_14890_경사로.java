import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_14890_경사로 {
	public static int map[][],size,len,cnt;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_경사로.txt"));
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		size = Integer.parseInt(s[0]);
		len = Integer.parseInt(s[1]);
		
		map = new int[size][size];
		
		for(int z=0;z<size;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<size;x++) {
				map[z][x] = Integer.parseInt(s[x]);
			}
		}

		garo();
		sero();
		System.out.println(cnt);
//		System.out.println(cnt-1);
	}

	private static void sero() {
case2:	for(int z=0;z<size;z++) {
		boolean f[] = new boolean[size];
			for(int x=0;x<size-1;x++) {
				int gap = map[x][z]-map[x+1][z];
				if(gap==0) continue;
				else if(gap==-1 || gap==1) {
					if(gap==1) { //내리막
						int h = map[x+1][z];
						for(int p=x+1;p<x+1+len;p++) {
							if(p>=size) continue case2;
							if(h!=map[p][z]) continue case2;
							if(!f[p]) f[p]=true;
							else continue case2;
						}
						x = x+len-1;
					}
					else { //오르막
						int h = map[x][z];
						for(int p=0;p<len;p++) {
							if(x-p<0) continue case2;
							if(h!=map[x-p][z]) continue case2;
							if(!f[x-p]) f[x-p]=true;
							else continue case2;
						}
					}
				}
				else if(gap>1 || gap<-1) {
					continue case2;
				}
			}
			cnt++;
		}
	}

	private static void garo() {
case1:	for(int z=0;z<size;z++) {
		boolean f[] = new boolean[size];
			for(int x=0;x<size-1;x++) {
				int gap = map[z][x]-map[z][x+1];
				if(gap==0) continue;
				else if(gap==-1 || gap==1) {
					if(gap==1) { //내리막
						int h = map[z][x+1];
						for(int p=x+1;p<x+1+len;p++) {
							if(p>=size) continue case1;
							if(h!=map[z][p]) continue case1;
							if(!f[p]) f[p]=true;
							else continue case1;
						}
						x = x+len-1;
					}
					else { //오르막
						int h = map[z][x];
						for(int p=0;p<len;p++) {
							if(x-p<0) continue case1;
							if(h!=map[z][x-p]) continue case1;
							if(!f[x-p]) f[x-p]=true;
							else continue case1;
						}
					}
				}
				else if(gap>1 || gap<-1) {
					continue case1;
				}
			}
			cnt++;
			
		}
	}

}
