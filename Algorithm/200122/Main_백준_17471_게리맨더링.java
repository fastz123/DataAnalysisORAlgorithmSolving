import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_17471_게리맨더링 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		people = new int[N];
		String s[] = br.readLine().split(" ");
		for(int z=0;z<N;z++) {
			people[z]=Integer.parseInt(s[z]);
		}
//		System.out.println(Arrays.toString(people));
		
		for(int z=0;z<N;z++) {
			s = br.readLine().split(" ");
			int k = Integer.parseInt(s[0]); //인접수
			for(int m=1;m<=k;m++) {
				arr[z][Integer.parseInt(s[m])-1]=1;
				arr[Integer.parseInt(s[m])-1][z]=1;
			}
		}
		min = Integer.MAX_VALUE;
		for(int z=0;z<(1<<N);z++) {
			//z=9;
			list1 = new ArrayList<>();
			list2 = new ArrayList<>();
			for(int k=0;k<N;k++) {
				if((z&(1<<k))>0) {
					list1.add(k+1);
				}
				else {
					list2.add(k+1);
				}
			}
			//분리완료
			//연결되어있는지 체크
			v1 = new int[N];
			v2 = new int[N];
			if(list1.size()>0 && list2.size()>0) {
				v1[list1.get(0)-1]=1;
				v2[list2.get(0)-1]=1;
				cnt1=1;
				cnt2=1;
				//System.out.print(z+" ");
				if(dfs2(list2.get(0)-1)+dfs1(list1.get(0)-1)==N) {
					int cur = Math.abs(tot_p(list1)-tot_p(list2));
					if(min>cur) min = cur;
					//System.out.println(cur+" "+min);
				}
				//System.out.println();
			}
			
//			System.out.println(list1.get(0));
			//dfs1(list1.get(0));
//			dfs2(list2.get(0));
			if((1<<N)-1 == z) {
				System.out.println(min==Integer.MAX_VALUE ? -1:min);
			}
		}
	}
	private static int tot_p(ArrayList<Integer> list) {
		int tot=0;
		for(int z=0;z<list.size();z++) {
			tot+=people[list.get(z)-1];
		}
		return tot;
	}
	public static int min,v1[],v2[],N,people[],arr[][],cnt1,cnt2;
	public static ArrayList<Integer> list1,list2;
	private static int dfs1(int z) {
		for(int i=0;i<N;i++) {
			if(v1[i]==0 && arr[z][i]==1 && list1.contains(i+1)) {
				if(v1[i]==0) cnt1++;
				v1[i]=1;
				dfs1(i);
			}
		}
		return cnt1;
	}
	private static int dfs2(int z) {
		for(int i=0;i<N;i++) {
			if(v2[i]==0 && arr[z][i]==1 && list2.contains(i+1)) {
				if(v2[i]==0) cnt2++;
				v2[i]=1;
				//System.out.println(i);
				dfs2(i);
			}
		}
		return cnt2;
	}

}
