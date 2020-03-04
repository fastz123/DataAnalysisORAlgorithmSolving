import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_2606_바이러스 {

	public static boolean map[][],v[];
	public static int size,c,cnt;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_바이러스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		map = new boolean[size][size];
		for(int z=0;z<c;z++) {
			String s[] = br.readLine().split(" ");
			int f = Integer.parseInt(s[0])-1;
			int t = Integer.parseInt(s[1])-1;
			map[f][t]=true;
			map[t][f]=true;
		}
		
		v = new boolean[size];
		cnt=0;
		dfs(0);
		System.out.println(cnt-1);
	}
	private static void dfs(int i) {
		for(int z=0;z<size;z++) {
			if(map[i][z] && !v[z]) {
				cnt++;
				v[z]=true;
				dfs(z);
			}
		}
	}
}
