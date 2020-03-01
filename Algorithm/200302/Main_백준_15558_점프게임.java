import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_15558_점프게임 {
	public static int arr[][],len,k;
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_점프게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		len = Integer.parseInt(s[0]);
		arr = new int[2][len];
		k = Integer.parseInt(s[1]);
		
		for(int z=0;z<2;z++) {
			String ss=br.readLine();
			for(int x=0;x<len;x++) {
				arr[z][x] = ss.charAt(x)-'0';
			}
		}
		

		f=false;
		v = new boolean[2][len+k];
		dfs(0,0,0);
		System.out.println(f? 1:0);
	}

	public static boolean f;
	private static void dfs(int i, int j,int time) {
		v[i][j]=true;
		if(f) return;
		if(time!=0 && time>j) {
			return;
		}
		if(j>=len) {
			f=true;
			return;
		}
		
		//옆으로
		if(i==0 && !v[1][j+k] && (j+k>=len || arr[i+1][j+k]==1)) dfs(i+1,j+k,time+1);
		else if(i==1 && !v[0][j+k] && (j+k>=len || arr[i-1][j+k]==1 )) dfs(i-1,j+k,time+1);

		//아래로
		if(j-1>=0 && arr[i][j-1]==1 && !v[i][j-1]) dfs(i,j-1,time+1);
		
		//위로
		if((j+1>=len || arr[i][j+1]==1 ) && !v[i][j+1]) dfs(i,j+1,time+1);
			
	}

}
