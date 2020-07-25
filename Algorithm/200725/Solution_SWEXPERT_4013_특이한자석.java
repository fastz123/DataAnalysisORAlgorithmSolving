import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_SWEXPERT_4013_특이한자석 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_특이한자석.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] list = new ArrayList[4];
			for(int z=0;z<4;z++) {
				String[] s = br.readLine().split(" ");
				list[z] = new ArrayList<>();
				for(int x=0;x<8;x++) {
					list[z].add(Integer.parseInt(s[x]));
				}
			}
			
//			for(ArrayList<Integer> l : list) System.out.println(l);
			
			for(int z=0;z<n;z++) {
				String[] s = br.readLine().split(" ");
				int num = Integer.parseInt(s[0])-1;
				int where = Integer.parseInt(s[1]);
				move(list,num,where);
//				for(ArrayList<Integer> l : list) System.out.println(l);
//				System.out.println();
			}
			
			System.out.println("#"+i+" "+((list[0].get(0)==1? 1:0)+(list[1].get(0)==1? 2:0)+(list[2].get(0)==1? 4:0)+(list[3].get(0)==1? 8:0)));
		}

	}

	private static void move(ArrayList<Integer>[] list, int num, int where) {
		boolean[] f = new boolean[3];
		if(list[0].get(2) != list[1].get(6)) f[0]=true;
		if(list[1].get(2) != list[2].get(6)) f[1]=true;
		if(list[2].get(2) != list[3].get(6)) f[2]=true;
		
		Collections.rotate(list[num], where);
		
		//왼쪽
		if(num>=1 && f[num-1]) turn('l',list, num-1, -where, f);
		//오른쪽
		if(num<=2 && f[num]) turn('r',list,num+1, -where, f);
	}

	private static void turn(char c,ArrayList<Integer>[] list, int num, int where, boolean[] f) {
		if(num<0 || num>3) return;
		
		Collections.rotate(list[num], where);
		
		if(c=='l') {
			if(num>=1 && f[num-1]) turn('l',list, num-1, -where, f);
		}
		else {
			if(num<=2 && f[num]) turn('r',list,num+1, -where, f);
		}
	}

}
