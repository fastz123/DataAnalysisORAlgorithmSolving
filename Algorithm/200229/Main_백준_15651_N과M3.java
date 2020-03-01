import java.io.BufferedReader;import java.io.BufferedWriter;import java.io.InputStreamReader;import java.io.OutputStreamWriter;import java.util.Arrays;
import java.io.FileInputStream;import java.io.IOException;

public class Main_15651_N과M3 {
	public static boolean v[];	public static int arr[],M,N;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {//		System.setIn(new FileInputStream("res/input_N과M3.txt"));
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));		String[] s = br.readLine().split(" ");				N = Integer.parseInt(s[0]);		M = Integer.parseInt(s[1]);		arr = new int[N];		for(int z=0;z<N;z++) arr[z] = z+1;				v = new boolean[N];		int[] res = new int[M];		comb(0,res);		bw.flush();	}	private static void comb(int count,int[] res) throws Exception {		if(count==M) {			for(int z : res) bw.write(z+" ");			bw.write("\n");		}		else {			for(int i=0;i<N;i++) {//				if(!v[i]) {//					v[i]=true;					res[count]=arr[i];					comb(count+1,res);//					v[i]=false;//				}			}		}	}

}
