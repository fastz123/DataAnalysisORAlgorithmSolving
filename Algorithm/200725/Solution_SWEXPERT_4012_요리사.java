import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.ArrayList;import java.util.Arrays;
import java.io.FileInputStream;

public class Solution_SWEXPERT_4012_요리사 {
	public static int min,map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_요리사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());		for(int i=1;i<=T;i++) {			int size = Integer.parseInt(br.readLine());			map = new int[size][size];			for(int z=0;z<size;z++) {				String[] s= br.readLine().split(" ");				for(int x=0;x<size;x++) {					map[z][x] = Integer.parseInt(s[x]);				}			}						min = Integer.MAX_VALUE;			for(long z=0;z<(1<<size);z++) {				ArrayList<Integer> menu1 = new ArrayList<>();				ArrayList<Integer> menu2 = new ArrayList<>();				for(int k=0;k<size;k++) {					if((z&(1<<k))>0) menu1.add(k);					else menu2.add(k);				}								if(menu1.size()==menu2.size()) {					int menu1_val = check(menu1);					int menu2_val = check(menu2);					min = Math.min(min, Math.abs(menu1_val-menu2_val));				}			}						System.out.println("#"+i+" "+min);		}
		
	}	private static int check(ArrayList<Integer> menu) {		int sum=0;				for(int z=0;z<menu.size();z++) {			for(int x=0;x<menu.size();x++) {				if(z!=x) {					int p = map[menu.get(z)][menu.get(x)];//					int q = map[menu.get(x)][menu.get(z)];					sum+=p;				}			}		}				return sum;	}

}
