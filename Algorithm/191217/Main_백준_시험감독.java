import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_시험감독 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_시험감독.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int room = Integer.parseInt(br.readLine());
		
		String s[] = br.readLine().split(" ");
		long[] pp = new long[room];
		for(int z=0;z<room;z++) {
			pp[z]=Long.parseLong(s[z]);
		}
		s = br.readLine().split(" ");
		long sv = Long.parseLong(s[0]);
		long sub = Long.parseLong(s[1]);
		
		long tot_p=0;
		
		for(int z=0;z<room;z++) {
			if(pp[z]-sv > 0) {
				tot_p++;
				if((pp[z]-sv)%sub == 0) tot_p+=(pp[z]-sv)/sub;
				else tot_p+=(pp[z]-sv)/sub+1;
			}
			else {
				tot_p++;
			}
		}
		
		System.out.println(tot_p);
	}

}
