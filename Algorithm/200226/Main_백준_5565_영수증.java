import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Main_백준_5565_영수증 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_영수증.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine());		for(int z=0;z<9;z++) {			total-=Integer.parseInt(br.readLine());		}				System.out.println(total);
	}

}
