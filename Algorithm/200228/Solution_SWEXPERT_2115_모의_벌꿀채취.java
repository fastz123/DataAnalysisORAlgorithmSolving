import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_2115_모의_벌꿀채취 {

	public static class ggul{
		int x;
		int y[];
		public ggul(int x,int[] y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int size,len,m,arr[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_벌꿀채취.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			size = Integer.parseInt(s[0]);
			len = Integer.parseInt(s[1]);
			m = Integer.parseInt(s[2]);
			
			
			
			arr = new int[size][size];
			for(int z=0;z<size;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			
			max = Integer.MIN_VALUE;
			ArrayList<ggul> list = new ArrayList<>();
			dfs(0,0,list);
			
			System.out.println("#"+(i+1)+" "+max);
		}

	}
	public static int max;
	private static void dfs(int i, int j, ArrayList<ggul> list) {
		if(i>=size) return;
		if(list.size()==2) {
			int cur = check(list);

			if(cur>max) max = cur;
			return;
		}
		if(j>=size) {
			dfs(i+1,0,list);
			return;
		}
		//선택
		boolean f = true;
		int[] cur = new int[len];
		for(int z=j;z<j+len;z++) {
			if(z>=0 && z<size) {
				cur[z-j] = z;
			}
			else {
				f=false;
				break;
			}
		}
		if(f) {
			list.add(new ggul(i,cur));
			dfs(i,j+len,list);
			list.remove(list.size()-1);
		}
		
		//안선택
		dfs(i,j+1,list);
	}

	private static int check(ArrayList<ggul> list) {
		int res=0;
		for(ggul cur : list) {
			int x= cur.x;
			int[] y = cur.y;
			
			int value[] = new int[len];
			for(int z=0;z<len;z++) value[z] = arr[x][y[z]];
			
			int max = Integer.MIN_VALUE;
			int maxres = Integer.MIN_VALUE;
			for(int z=0;z<(1<<len);z++) {
				int sum=0;
				int powsum=0;
				for(int k=0;k<len;k++) {
					if((z&(1<<k))>0) {
						sum+=value[k];
						powsum += value[k]*value[k];
					}
				}
				if(sum<=m) {
					if(maxres<powsum) maxres = powsum;
				}
			}
			res+=maxres;
		}
		return res;
	}

}
