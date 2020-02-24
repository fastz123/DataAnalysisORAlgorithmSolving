import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.ArrayList;import java.util.Arrays;
import java.io.FileInputStream;

public class Main_백준_16956_늑대와양 {
	public static int R,C;	public static char map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_늑대와양.txt"));
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");		R = Integer.parseInt(s[0]);		C = Integer.parseInt(s[1]);		map = new char[R][C];						ArrayList<int[]> Wolflist = new ArrayList<>();		boolean f= false;		case1:	for(int z=0;z<R;z++) {			String ss = br.readLine();			for(int x=0;x<C;x++) {				map[z][x] = ss.charAt(x);				if(map[z][x]=='S' && ((x-1>=0 && map[z][x-1] == 'W') || (z-1>=0 && map[z-1][x]=='W'))) {					f=true;					break case1;				}				else if(map[z][x]=='W' && ((x-1>=0 && map[z][x-1] == 'S') || (z-1>=0 && map[z-1][x]=='S'))) {					f=true;					break case1;				}				if(map[z][x]=='W') Wolflist.add(new int[] {z,x});			}		}		if(f) System.out.println(0);		else {			for(int z=0;z<Wolflist.size();z++) {				int[] cur = Wolflist.get(z);				drawing(cur);			}			System.out.println(1);			printmap();		}		
	}	private static void printmap() {		for(int z=0;z<R;z++) {			for(int x=0;x<C;x++) {				System.out.print(map[z][x]);			}			System.out.println();		}	}	public static int[] di= {0,-1,0,1}, dj= {-1,0,1,0};	private static void drawing(int[] cur) {		for(int z=0;z<4;z++) {			int newx = cur[0]+di[z];			int newy = cur[1]+dj[z];			if(newx>=0 && newx<R && newy>=0 && newy<C && map[newx][newy]=='.') map[newx][newy]='D';		}	}

}
