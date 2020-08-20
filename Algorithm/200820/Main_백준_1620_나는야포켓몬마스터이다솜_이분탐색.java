package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main_백준_1620_나는야포켓몬마스터이다솜 {

	public static class Pokemo{
		int num;
		String name;
		public Pokemo(int num,String name) {
			this.num=num;
			this.name=name;
		}
	}
	public static ArrayList<Pokemo> list;
	public static ArrayList<Pokemo> list2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<>();
		list2 = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		for(int z=0;z<N;z++) {
			String c= br.readLine();
			Pokemo cur = new Pokemo(z+1,c);
			list.add(cur);
			list2.add(cur);
		}
		
		Collections.sort(list,new Comparator<Pokemo>() {

			@Override
			public int compare(Pokemo o1, Pokemo o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
		for(int z=0;z<M;z++) {
			String cur = br.readLine();
			if(cur.charAt(0)>='A' && cur.charAt(0)<='Z') {
				bs(cur,0,list.size());
			}
			else {
				System.out.println(list2.get(Integer.parseInt(cur)-1).name);
			}
		}

//		HashMap<String, String> map = new HashMap<>();
//		for(int z=0;z<N;z++) {
//			String cur = br.readLine();
//			map.put(Integer.toString(z+1), cur);
//			map.put(cur,Integer.toString(z+1));
//		}
//		
//		for(int z=0;z<M;z++) {
//			String res = map.get(br.readLine());
//			System.out.println(res);
//		}
		
	}

	private static void bs(String cur, int start, int end) {
		int mid = (start+end)/2;
		Pokemo curP = list.get(mid);
		String midstr = curP.name;
		if(midstr.equals(cur)) {
			System.out.println(curP.num);
			return;
		}
		else {
			if(cur.compareTo(midstr)>0) {
				bs(cur,mid+1,end);
			}
			else {
				bs(cur,start,mid);
			}
			
		}
	}

}
