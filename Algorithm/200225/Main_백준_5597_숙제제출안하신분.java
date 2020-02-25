import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_5597_숙제제출안하신분 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_숙제.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean arr[] = new boolean[30];
		for(int z=0;z<28;z++) {
			arr[Integer.parseInt(br.readLine())-1]=true;
		}
		
		for(int z=0;z<30;z++) {
			if(!arr[z]) System.out.println(z+1);
		}

	}
}

