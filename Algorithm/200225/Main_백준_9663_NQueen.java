import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_9663_NQueen {
	public static int size,map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_NQueen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		
		dfs(0,0,0);
		System.out.println(c);
	}
	public static int c;
	private static void dfs(int i, int j, int cnt) {
		if(i-cnt!=0) return;
		if(i>=size) {
			if(cnt==size) {
//				printmap();
				c++;
			}
			return;
		}
		if(j>=size) {
			dfs(i+1,0,cnt);
			return;
		}
			
		boolean f = check(i,j);
		//안둔다.
		if(!f) {
			dfs(i,j+1,cnt);
		}
		//둔다.
		else if(f) {
			//둘수있으니 둔다
			map[i][j]=1;
			dfs(i+1,0,cnt+1);
			map[i][j]=0;
			
			//둘수 있지만 안둔다.
			dfs(i,j+1,cnt);
		}
			
	}


	private static void printmap() {
		for(int[] a:map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("------------------");
	}


	private static boolean check(int i, int j) {
		
		//위
		for(int z=i-1;z>=0;z--) {
			if(map[z][j]==1) return false;
		}
		
		//왼
		for(int z=j-1;z>=0;z--) {
			if(map[i][z]==1) return false;
		}
		
		for(int z=1;z<size;z++) {
			//좌대
			if(i-z>=0 && j-z>=0) {
				if(map[i-z][j-z]==1) return false;
			}
		}
		for(int z=1;z<size;z++) {
			//우대
			if(i-z>=0 && j+z<size) {
				if(map[i-z][j+z]==1) return false;
			}
			else break;
		}
		
		return true;
	}

}
