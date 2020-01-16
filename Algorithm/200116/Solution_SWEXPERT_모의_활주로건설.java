import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution_SWEXPERT_모의_활주로건설 {
	public static int size,arr[][],len;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_활주로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			size = Integer.parseInt(s[0]);
			len = Integer.parseInt(s[1]);
			arr = new int[size][size];
			for(int z=0;z<size;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			
			int row = checkrow();
			int col = checkcol();
//			System.out.println(row);
//			System.out.println(col);
			System.out.println("#"+(i+1)+" "+(row+col));
			
		}
	}

	private static int checkcol() {
		int cnt=0;
case1:	for(int z=0;z<size;z++) {
			int cur=z;
			HashSet<String> set = new HashSet<>();
case2:		for(int x=0;x<size;x++) {
				if(x==size-1) {
					cnt++;
					break;
				}
				if(arr[x][z] == arr[x+1][z] + 1) { //감소
					int y = x;
					if(y+(len)>=size) continue case1;
					else {
						int curh = arr[y][cur];
						for(int k=1;k<=len;k++) {
							if((curh-1)!=arr[y+k][cur] || set.contains(""+(y+k)+" "+cur)) continue case1;
							else set.add(""+(y+k)+" "+cur);
						}
						x+=(len-1);
					}
				}
				else if(arr[x][z] == arr[x+1][z] - 1) { //상승
					int y=x;
					if(y-(len-1)<0) continue case1;
					else {
						int curh = arr[y][cur];
						for(int k=1;k<len;k++) {
							if(curh!=arr[y-k][cur] || set.contains(""+(y-k)+" "+cur)) continue case1;
							else set.add(""+(y-k)+" "+cur);
						}
					}
				}
				else if(arr[x][z] == arr[x+1][z]) continue;
				else if(Math.abs(arr[x][z]-arr[x+1][z])>1) continue case1;
			}
		}
		
		return cnt;
	}

	private static int checkrow() {
		
		int cnt=0;
		
case1:	for(int z=0;z<size;z++) {
			int cur = z;
			HashSet<String> set = new HashSet<>();
case2:		for(int x=0;x<size;x++) {
				if(x==size-1) {
					cnt++;
					break;
				}
				if(arr[z][x] == arr[z][x+1] + 1) {//감소
					int y = x;
					if(y+(len)>=size) continue case1;
					else {
						int curh = arr[cur][y];
						for(int k=1;k<=len;k++) {
							if(curh-1!=arr[cur][y+k] || set.contains(""+cur+" "+(y+k))) continue case1;
							else set.add(""+cur+" "+(y+k));
						}
						x+=(len-1);
					}
				}
				else if(arr[z][x] == arr[z][x+1] - 1) { //상승
					int y = x;
					if(y-(len-1)<0) continue case1;
					else {
						int curh = arr[cur][y];
						for(int k=1;k<len;k++) {
							if(curh!=arr[cur][y-k] || set.contains(""+cur+" "+(y-k))) continue case1;
							else set.add(""+cur+" "+(y-k));
						}
					}
				}
				else if(arr[z][x] == arr[z][x+1]) continue;
				else if(Math.abs(arr[z][x]-arr[z][x+1])>1) continue case1;
			}
			
		}
		
		return cnt;
	}
} 
