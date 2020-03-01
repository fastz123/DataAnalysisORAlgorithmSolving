import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_13458_시험감독 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_시험감독.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		int[] arr = new int[cnt];
		
		String[] s = br.readLine().split(" ");
		for(int z=0;z<cnt;z++) {
			arr[z] = Integer.parseInt(s[z]);
		}
		
		s = br.readLine().split(" ");
		int spv = Integer.parseInt(s[0]);
		int sup = Integer.parseInt(s[1]);
		
		long res = 0;
		
		for(int z=0;z<cnt;z++) {
			if(arr[z]-spv>0) {
				res+=1;
				if((arr[z]-spv)%sup==0) res+=(arr[z]-spv)/sup;
				else res+=((arr[z]-spv)/sup) +1;
			}
			else {
				res++;
			}
		}

		System.out.println(res);
	}

}
