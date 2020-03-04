import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_2839_설탕배달 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_설탕배달.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N<3) {
			System.out.println(-1);
			return;
		}
		else {
			int min = Integer.MAX_VALUE;
			int b = 0;
case1:		while(true) {
				if(b*3>N) {
					break;
				}
				int a = 0;
				while(true) {
					int k = (b*5)+(a*3);
					if(k==N) {
						if(min > a+b) min = a+b;
						break;
					}
					else if(k>N) {
						break;
					}
					a++;
				}
				b++;
			}
			System.out.println(min==Integer.MAX_VALUE? -1:min);
		}

		

	}

}
