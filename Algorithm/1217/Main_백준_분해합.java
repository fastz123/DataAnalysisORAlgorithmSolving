import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_분해합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		for(int z=0;z<input;z++) {
			//z=198;
			int k = input;
			int c = z;
			int sum=0;
			sum+=z;
			while(true) {
				sum+=c%10;
				
				c/=10;
				if(c==0) {
					if(sum==input) {
						System.out.println(z);
						return;
					}
					break;
				}
			}
			//System.out.println(z + " "+sum);
			if(z==input-1) System.out.println(0);
		}
	}

}
