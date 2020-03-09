import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_백준_17827_달팽이리스트 {

	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_달팽이리스트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		
		s = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int z=0;z<N;z++) {
			arr[z] = Integer.parseInt(s[z]);
		}
		
		int rotatearr[] = new int[N-K+1];
		for(int z=K-1;z<N;z++) rotatearr[z-(K-1)] = arr[z];
//		System.out.println(Arrays.toString(rotatearr));
		
		
		for(int z=0;z<M;z++) {
			int cur = Integer.parseInt(br.readLine());
			if(N==K) {
				if(cur<N) bw.write(arr[cur]+"\n");//System.out.println(arr[cur]);
				else bw.write(arr[N-1]+"\n");//System.out.println(arr[N-1]);
			}
			else {
				if(cur<N) bw.write(arr[cur]+"\n");//System.out.println(arr[cur]);
				else {
					cur = (cur-N-(K-1));
					cur%=N-(K-1);
//					System.out.println(rotatearr[cur+(K-1)]);
					bw.write(rotatearr[cur+(K-1)]+"\n");
				}
			}
		}
		bw.flush();

	}

}
