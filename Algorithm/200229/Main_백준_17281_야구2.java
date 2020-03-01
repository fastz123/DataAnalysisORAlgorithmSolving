import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_17281_야구2 {
	public static int res[],arr2[],arr[][],N;
	public static boolean v[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_야구.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for(int z=0;z<N;z++) {
			String[] s = br.readLine().split(" ");
			for(int x=0;x<9;x++) {
				arr[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		//1번 제외
		arr2 = new int[8];
		for(int z=1;z<9;z++) {
			arr2[z-1] = z;
		}
		
//		System.out.println(Arrays.toString(arr2));
		//8명 순서 정하기
		max = Integer.MIN_VALUE;
		res = new int[8];
		v = new boolean[8];
		perm(0);
		
		System.out.println(max);
	}
	public static int max;
	private static void perm(int count) {
		if(count==8) {
			int[] temp = new int[9];
			for(int z=0;z<=8;z++) {
				if(z<3) temp[z] = res[z];
				else if(z==3) temp[z] = 0;
				else if(z>3) temp[z] = res[z-1];
			}
//			System.out.println(Arrays.toString(temp));
			int curscore = game(temp);
//			System.out.println(curscore);
			if(curscore>max) max = curscore;
			return;
		}
		else {
			for(int i=0;i<8;i++) {
				if(!v[i]) {
					v[i]=true;
					res[count]=arr2[i];
					perm(count+1);
					v[i]=false;
				}
			}
		}
	}
	private static int game(int[] temp) {
		int score = 0;
		int curining = 0; 
		int t = 0;
		while(true) {
			boolean[] map = new boolean[3];
			
			int outcount=0;
			while(true) {
				if(t==9) t=0;
				int cur = arr[curining][temp[t]];
				
				if(cur == 4) {
					for(int z=0;z<3;z++) {
						if(map[z]==true) score++;
					}
					score++;
					for(int z=0;z<3;z++) map[z] = false;
				}
				else if(cur == 3) { //3루타
					for(int z=0;z<3;z++) {
						if(map[z]==true) score++;
					}
					map[0]=false;
					map[1]=false;
					map[2]=true;
				}
				else if(cur == 2) {//2루타
					for(int z=2;z>=1;z--) {
						if(map[z]==true) score++;
					}
					if(map[0]==true) map[2]=true;
					else map[2]=false;
					map[0]=false;
					map[1]=true;
				}
				else if(cur == 1) {// 1루타
					if(map[2]==true) score++;
					boolean copy[] = new boolean[3];
					for(int z=0;z<3;z++) copy[z]=map[z];
					for(int z=0;z<2;z++) map[z+1]=copy[z];
					map[0]=true;
				}
				else {//아웃
					outcount++;
					if(outcount==3) {
						t++;
						break;
					}
				}
				
				t++;
			}
			
			curining++;
			if(curining==N) break;
		}
		return score;
	}

}
