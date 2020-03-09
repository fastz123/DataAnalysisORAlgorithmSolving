import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.ArrayList;import java.util.Arrays;
import java.io.FileInputStream;

public class Main_백준_17826_나의학점은 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_나의학점은.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> list = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		for(int z=0;z<50;z++) {
			list.add(Integer.parseInt(s[z]));
		}

		int my = Integer.parseInt(br.readLine());
		int cnt=0;
		for(int z=0;z<50;z++) {
			if(my!=list.get(z)) {
				if(my < list.get(z)) cnt++;
			}
		}
		//System.out.println(cnt+1);		cnt++;		if(cnt>=1 && cnt<=5) System.out.println("A+");		else if(cnt>5 && cnt<=15) System.out.println("A0");		else if(cnt>15 && cnt<=30) System.out.println("B+");
		else if(cnt>30 && cnt<=35) System.out.println("B0");
		else if(cnt>35 && cnt<=45) System.out.println("C+");
		else if(cnt>45 && cnt<=48) System.out.println("C0");
		else System.out.println("F");
	}

}
