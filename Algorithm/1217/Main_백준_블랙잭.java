import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_블랙잭 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[N];
		s = br.readLine().split(" ");
		for(int z=0;z<N;z++) {
			arr[z]=Integer.parseInt(s[z]);
		}
		v = new int[N];
		max = Integer.MIN_VALUE;
		res = new int[3];
		comb(0,0,0);
		System.out.println(max);
	}
	public static int arr[],v[],max,N,M,res[];
	private static void comb(int st, int cnt, int sum) {
		if(cnt==3) {
			//System.out.println(Arrays.toString(res)+" "+sum);
			if(sum<=M && max<sum) {
				max=sum;
				return;
			}
		}
		else {
			for(int i=st;i<N;i++) {
				if(v[i]==0) {
					v[i]=1;
					//res[cnt]=arr[i];
					comb(i,cnt+1,sum+arr[i]);
					v[i]=0;
				}
			}
		}
	}
}
