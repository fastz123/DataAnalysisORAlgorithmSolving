import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_15684_사다리조작 {
	public static int w,h;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_사다리만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		w = Integer.parseInt(s[0]);
		h = Integer.parseInt(s[2]);
		int c = Integer.parseInt(s[1]);
		
		int[][] map = new int[h][w*2-1];
		for(int z=0;z<w*2-1;z+=2) {
			for(int k=0;k<h;k++) {
				map[k][z] = 1;
			}
		}
		for(int z=0;z<c;z++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0])-1;
			int y = Integer.parseInt(s[1]);
			
			map[x][y*2-1] = 1;
		}
		
		min = Integer.MAX_VALUE;
		dfs(map,0,1,0);
		System.out.println(min==Integer.MAX_VALUE? -1:min);
	}

	public static int min;
	private static void dfs(int[][] map, int i, int j, int cnt) {
		if(cnt>min) return;
		if(i>=h) {
//			System.out.println(cnt);
//			printmap(map);
			//체크
			if(check(map)) {
				min = Math.min(min, cnt);
			}
			return;
		}
		if(j>=w*2-1) {
			dfs(map,i+1,1,cnt);
			return;
		}
		if(cnt>=3) {
			dfs(map,i,j+2,cnt);
			return;
		}
		if((j-2>=0 && map[i][j-2]==1) || (j+2<w*2-1 && map[i][j+2]==1) || (map[i][j]==1)) {
			dfs(map,i,j+2,cnt);
			return;
		}
		//놓는다
		map[i][j]=1;
		dfs(map,i,j+2,cnt+1);
		map[i][j]=0;
		
		//안놓는다
		dfs(map,i,j+2,cnt);
		
	}
	private static void printmap(int[][] map) {
		for(int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("---------------------");
	}
	private static boolean check(int[][] map) {
		for(int z=0;z<map[0].length;z+=2) {
			int curx = h-1;
			int cury = z;
			while(true) {
				if(curx<0) break;
				if(cury-1>=0 && map[curx][cury-1]==1) {
					cury-=2;
				}
				else if((cury+1<w*2-1 && map[curx][cury+1]==1)) {
					cury+=2;
				}
				curx--;
			}
			if(cury!=z) return false;
		}
		return true;
	}

}
