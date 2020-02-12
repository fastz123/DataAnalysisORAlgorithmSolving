import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_17471_게리맨더링2 {
	public static int map[][],people[],min;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_게리맨더링.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		people = new int[size];
		for(int z=0;z<size;z++) people[z] = Integer.parseInt(s[z]);
		map = new int[size][size];
		for(int z=0;z<size;z++) {
			s = br.readLine().split(" ");
			int c = Integer.parseInt(s[0]);
			for(int k=1;k<=c;k++) {
				map[z][Integer.parseInt(s[k])-1]=1;
//				map[Integer.parseInt(s[k])-1][z]=1;
			}
		}
		min = Integer.MAX_VALUE;
		for(int z=0;z<(1<<size);z++) {
//			z=13;
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			for(int k=0;k<size;k++) {
				if((z&(1<<k))>0) {
					list1.add(k);
				}
				else list2.add(k);
			}
//			for(int cur : list1) System.out.print(cur+" ");
//			System.out.println();
//			System.out.println("----------------");
//			for(int cur : list2) System.out.print(cur+" ");
//			System.out.println();
//			System.out.println("%%%%%%%%%%%%%%%%%%%%%");
			
			if(list1.size()>0 && list2.size()>0) {
				//연결확인
				v1 = new boolean[size];
				v1[list1.get(0)]=true;
				dfs(list1.get(0),list1,v1);
//				System.out.println(Arrays.toString(v1));
				
				v2 = new boolean[size];
				v2[list2.get(0)]=true;
				dfs(list2.get(0),list2,v2);
//				System.out.println(Arrays.toString(v2));
				
//				System.out.println("------------------------");
				
				int cnt=0;
				for(int p=0;p<size;p++) {
					if(v1[p]^v2[p]) cnt++;
				}
				
				if(cnt==size) {
					int area1people = summation(list1); 
					int area2people = summation(list2);
					int cur = Math.abs(area2people-area1people);
					if(min>cur) min = cur;
				}
			}
			
		}
		
		System.out.println(min==Integer.MAX_VALUE? -1:min);
		
	}
	private static int summation(ArrayList<Integer> list) {
		int sum=0;
		for(int z=0;z<list.size();z++) sum+=people[list.get(z)];
		return sum;
	} 
	public static boolean v1[],v2[];
	private static void dfs(int cur, ArrayList<Integer> list,boolean[] v) {
		for(int i=0;i<list.size();i++) {
			if(!v[list.get(i)] && map[cur][list.get(i)]==1) {
				v[list.get(i)]=true;
				dfs(list.get(i),list,v);
				//v[list.get(i)]=false;
			}
		}
	}

}
