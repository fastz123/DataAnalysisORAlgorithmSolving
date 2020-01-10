package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_백준_N과M3 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_nm3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		max = Integer.parseInt(s[0]);
		size = Integer.parseInt(s[1]);
		
		v = new boolean[max];
		res = new int[size];
		perm(0,res);
		bw.flush();
	}
	public static int arr[],size,max,res[];
	public static boolean v[];
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static void perm(int count, int[] res) throws IOException {
		if(count==size) {
			for(int k : res) bw.write(""+k+" ");
			bw.write("\n");
		}
		else {
			for(int i=1;i<=max;i++) {
				//if(!v[i]) {
				//	v[i]=true;
					res[count]=i;
					perm(count+1,res);
				//	v[i]=false;
				//}
			}
		}
	}

}
