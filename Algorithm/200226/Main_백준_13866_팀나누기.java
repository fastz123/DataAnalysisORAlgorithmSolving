import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_13866_팀나누기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_팀나누기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[4];
		String[] s = br.readLine().split(" ");
		for(int z=0;z<4;z++) {
			arr[z] = Integer.parseInt(s[z]);
		}

		int min = Integer.MAX_VALUE;
		for(int z=0;z<(1<<4);z++) {
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			for(int k=0;k<4;k++) {
				if((z&(1<<k))>0) {
					list1.add(arr[k]);
				}
				else {
					list2.add(arr[k]);
				}
			}
			if(list1.size()==2 && list2.size()==2) {
				int sum1 =0;
				int sum2 = 0;
				for(int cur : list1) sum1+=cur;
				for(int cur : list2) sum2+=cur;
				int gap = Math.abs(sum1-sum2);
				if(min>gap) min = gap;
			}
		}
		
		System.out.println(min);
	}

}
