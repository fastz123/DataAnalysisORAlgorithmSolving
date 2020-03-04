import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.Arrays;
import java.io.FileInputStream;

public class Main_백준_1475_방번호 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_방번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();		char[] arr = new char[s.length()];		for(int z=0;z<s.length();z++) arr[z] = s.charAt(z);				//		System.out.println(Arrays.toString(arr));		int[] v = new int[10];		for(int z=0;z<s.length();z++) {			v[arr[z]-'0']++;		}				int max = 0;		int num6 = v[6];		int num9 = v[9];		for(int z=0;z<10;z++) {			if(v[z]>max) {				if(z==6 || z==9) continue;				else max = v[z];			}		}		int sum = num6+num9;		if(sum%2 == 1 ) sum++;		System.out.println(max>sum/2 ? max:sum/2);	}

}
