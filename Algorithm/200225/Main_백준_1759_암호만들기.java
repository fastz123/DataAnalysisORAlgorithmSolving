import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_1759_암호만들기 {
	public static int size,len;
	public static char arr[],b[];
	public static boolean v[];
	public static ArrayList<String> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_암호만들기.txt"));
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		size = Integer.parseInt(s[0]);
		len = Integer.parseInt(s[1]);
		
		arr = new char[len];
		String ss = br.readLine();
		char[] array = ss.toCharArray();
		for(int z=0;z<array.length;z+=2) {
			arr[z/2]=array[z];
		}
		
		Arrays.sort(arr);
		v = new boolean[len];
		b = new char[size];
		list = new ArrayList<>();
		comb(0,0);
		for(String sss:list) System.out.println(sss);
	}

	private static void comb(int start, int count) {
		if(count==size) {
			boolean f = check();
			if(f) {
				String s="";
				for(char a : b) s+=a;
				list.add(s);
			}
		}
		else {
			for(int i=start;i<len;i++) {
				if(!v[i]) {
					v[i]=true;
					b[count]=arr[i];
					comb(i,count+1);
					v[i]=false;
				}
			}
		}
	}

	private static boolean check() {
		int moem = 0;
		int jaem = 0;
		for(char a: b) {
			if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u') {
				moem++;
			}
			else {
				jaem++;
			}
		}
		if(moem>=1 && jaem>=2) return true;
		else return false;
	}

}
