import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_15686_치킨배달_김민호 {

	public static class XY{
		int x;
		int y;
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static ArrayList<XY> home,Chick,SelectChick;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_치킨배달.txt"));
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int size = Integer.parseInt(s[0]);
		int[][] arr = new int[size][size];
		int chickcnt = Integer.parseInt(s[1]);
		
		
		home = new ArrayList<>();
		Chick = new ArrayList<>();
		for(int z=0;z<size;z++) {
			s = br.readLine().split(" ");
			for(int x=0;x<size;x++) {
				arr[z][x]=Integer.parseInt(s[x]);
				if(arr[z][x]==2) Chick.add(new XY(z,x));
				else if(arr[z][x]==1) home.add(new XY(z,x));
			}
		}
		
		min = Integer.MAX_VALUE;
		for(long z=0;z<(1<<Chick.size());z++) {
			SelectChick = new ArrayList<>();
			for(int k=0;k<Chick.size();k++) {
				if((z&(1<<k))>0) {
					SelectChick.add(Chick.get(k));
				}
			}
			
			if(SelectChick.size()==chickcnt) {
				int cur = check(arr);
				if(cur<min) min = cur;
			}
		}
		
		System.out.println(min);
		
	}
	public static int min;
	private static int check(int[][] arr) {
		int sum=0;
		for(XY H:home) {
			int min = Integer.MAX_VALUE;
			for(XY C:SelectChick) {
				int cur = Math.abs(C.x-H.x)+Math.abs(C.y-H.y);
				if(min>cur) {
					min=cur;
				}
			}
			sum+=min;
		}
		return sum;
	}

}
