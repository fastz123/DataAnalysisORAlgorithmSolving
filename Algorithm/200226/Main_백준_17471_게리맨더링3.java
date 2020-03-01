import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.ArrayList;import java.util.Arrays;
import java.io.FileInputStream;

public class Main_백준_17471_게리맨더링3 {
	public static int N,map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_게리맨더링.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());		int[] people = new int[N];		String[] s = br.readLine().split(" ");
		for(int z=0;z<N;z++) {			people[z] = Integer.parseInt(s[z]);		}				map = new int[N][N];		for(int z=0;z<N;z++) {			String[] ss = br.readLine().split(" ");			int c = Integer.parseInt(ss[0]);			for(int k=0;k<c;k++) {				int q = Integer.parseInt(ss[k+1])-1;				map[z][q]=1;				map[q][z]=1;			}		}				int min = Integer.MAX_VALUE;case1:	for(int z=0;z<(1<<N);z++) {//			z=1+2+4+8;			ArrayList<Integer> list1 = new ArrayList<>();			ArrayList<Integer> list2 = new ArrayList<>();			for(int k=0;k<N;k++) {				if((z&(1<<k))>0) {					list1.add(k);				}				else {					list2.add(k);				}			}			if(list1.size()>=1 && list2.size()>=1) {				//연결확인				v = new boolean[N];				v[list1.get(0)]=true;				boolean v1[] = check(list1);				v = new boolean[N];				v[list2.get(0)]=true;				boolean v2[] = check(list2);				boolean res[] = new boolean[N];				for(int p=0;p<N;p++) {					res[p] = v1[p]^v2[p];					if(!res[p]) continue case1;				}					int sum1 = 0;					int sum2 = 0;					for(int a : list1) sum1+=people[a];					for(int a : list2) sum2+=people[a];					int gap = Math.abs(sum1-sum2);					if(min>gap) min = gap;			}		}		System.out.println(min==Integer.MAX_VALUE? -1:min);	}	public static boolean v[];	private static boolean[] check(ArrayList<Integer> list) {		dfs(list,list.get(0));		return v;	}	private static void dfs(ArrayList<Integer> list, int i) {		for(int z=0;z<list.size();z++) {			int cur = list.get(z);			if(!v[cur] && map[i][cur]==1 ) {				v[cur]=true;				dfs(list,cur);			}		}	}	

}
