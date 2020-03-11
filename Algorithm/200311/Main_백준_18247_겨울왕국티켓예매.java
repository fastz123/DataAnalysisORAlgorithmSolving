import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_18247_겨울왕국티켓예매 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			int[][] arr = new int[N][M];
			int cnt=1;
			boolean f=false;
case1:		for(int z=0;z<N;z++) {
				for(int x=0;x<M;x++) {
					if(z=='L'-'A' && x==3) {
						System.out.println(cnt);
						f=true;
						break case1;
					}
					cnt++;
				}
			}
			if(!f) System.out.println(-1);
		}

	}

}
