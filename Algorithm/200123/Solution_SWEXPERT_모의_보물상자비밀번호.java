import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Solution_SWEXPERT_모의_보물상자비밀번호 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_보물상자비번.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			int size = Integer.parseInt(s[0]);
			int K = Integer.parseInt(s[1]);
			
			int linesize = size/4;
			
			ArrayList<Character> list = new ArrayList<>();
			String ss = br.readLine();
			for(int z=0;z<size;z++) list.add(ss.charAt(z));
			
			ArrayList<String> all = new ArrayList<>();
			for(int p=0;p<linesize;p++) {
				ArrayList<String> curlist = new ArrayList<>();
				String cur = "";
				for(int q=0;q<size;q++) {
					cur+=list.get(q);
					if(cur.length()==linesize) {
						curlist.add(cur);
						cur = "";
					}
				}
				
				for(String c : curlist) {
					if(!all.contains(c)) all.add(c);
				}
				
				Collections.rotate(list, 1);
				
			}
			
			Collections.sort(all, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return -o1.compareTo(o2);
				}
			});
			
			int ans = Integer.parseInt(all.get(K-1),16);
			
			System.out.println("#"+(i+1)+" "+ans);
			
		}

	}

}
