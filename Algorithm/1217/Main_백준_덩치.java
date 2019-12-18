import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_백준_덩치 {

	public static class WH{
		int weight;
		int height;
		public WH(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_덩치.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		WH[] arr = new WH[cnt];
		for(int z=0;z<cnt;z++) {
			String s[] = br.readLine().split(" ");
			arr[z]=new WH(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}

		ArrayList<WH> list[] = new ArrayList[cnt];
		for(int z=0;z<cnt;z++) list[z] = new ArrayList<>();
		
		for(int z=0;z<cnt;z++) {
			for(int x=0;x<cnt;x++) {
				if(z!=x) {
					if(arr[z].weight<arr[x].weight && arr[z].height<arr[x].height) {
						list[z].add(arr[x]);
					}
				}
			}
		}
		for(ArrayList<WH> a:list) System.out.print((a.size()+1)+" ");
	}

}
