package algo2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Main_백준_9375_패션왕신혜빈 {

	static class Cloth{
		String where;
		LinkedList<String> list;
		
		public Cloth(String where) {
			this.where = where;
			this.list = new LinkedList<>();
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_패션왕신혜빈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			
			int N = Integer.parseInt(br.readLine());
			
			LinkedList<Cloth> Clist = new LinkedList<>();
			
			for(int z=0;z<N;z++) {
				String[] s = br.readLine().split(" ");
				String name = s[0];
				String where = s[1];
				
				boolean f= false;
				for(Cloth cur : Clist) {
					if(cur.where.equals(where)) {
						cur.list.add(name);
						f=true;
						break;
					}
				}
				if(!f) {
					Cloth newCloth = new Cloth(where);
					newCloth.list.add(name);
					Clist.add(newCloth);
				}
			}
			
			int ans = 1;
			for(Cloth cur : Clist) {
				ans *= (cur.list.size()+1);
			}
			System.out.println(ans-1);
			
			T--;
		}
	}

}
