package algo804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_6603_로또_김민호 {
	public static boolean v[];
	public static int arr[],cnt,res[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_로또.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s[] = br.readLine().split(" ");
			if(s[0].equals("0")) break;
			cnt = Integer.parseInt(s[0]);
			arr = new int[cnt];
			
			for(int z=0;z<cnt;z++) {
				arr[z]=Integer.parseInt(s[z+1]);
			}
			
			v = new boolean[cnt];
			res = new int[6];
			comb(0,0);
			System.out.println();
		}

	}
	private static void comb(int count,int start) {
		if(count==6) {
			for(int a: res) System.out.print(a+" ");
			System.out.println();
		}
		else {
			for(int i=start;i<cnt;i++) {
				if(!v[i]) {
					v[i]=true;
					res[count]=arr[i];
					comb(count+1,i);
					v[i]=false;
				}
			}
		}
	}

}
