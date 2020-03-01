import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_SWEXPERT_1247_최적경로 {

	public static class Spot{
		int x;
		int y;
		public Spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static Spot spot[],home,start;
	public static int size,min;
	public static boolean v[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_최적경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			size = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			start = new Spot(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			home = new Spot(Integer.parseInt(s[2]),Integer.parseInt(s[3]));
			spot = new Spot[size];
			for(int z=0;z<size*2;z+=2) {
				spot[z/2] = new Spot(Integer.parseInt(s[4+z]), Integer.parseInt(s[5+z]));
			}
			min = Integer.MAX_VALUE;
			v = new boolean[size];
			perm(0,0,start);
			System.out.println("#"+(i+1)+" "+min);
		}

	}
	private static void perm(int count,int sum,Spot curspot) {
		if(count==size) {
			sum+=Math.abs(curspot.x-home.x)+Math.abs(curspot.y-home.y);
			if(sum<min) min = sum;
			return;
		}
		else {
			for(int i=0;i<size;i++) {
				if(!v[i]) {
					v[i]=true;
					perm(count+1,sum+Math.abs(curspot.x-spot[i].x)+Math.abs(curspot.y-spot[i].y),spot[i]);
					v[i]=false;
				}
			}
		}
	}
	

}
