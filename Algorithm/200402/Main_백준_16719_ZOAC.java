package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main_백준_16719_ZOAC {
	public static class Charc{
		char c;
		int idx;
		public Charc(char c, int idx) {
			this.c = c;
			this.idx = idx;
		}
	}
	public static class listc{
		String s;
		int idx;
		int addidx;
		public listc(String s, int idx) {
			this.s = s;
			this.idx = idx;
		}
	}
	public static class CCC{
		ArrayList<Charc> temp;
		Charc addc;
		public CCC() {
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_zoac.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s=br.readLine();
		Charc[] arr = new Charc[s.length()];
		ArrayList<Charc> list = new ArrayList<>();
		for(int z=0;z<s.length();z++) list.add(new Charc(s.charAt(z),z));
		
		Charc min = list.get(0);
		for(int z=0;z<s.length();z++) {
			if(list.get(z).c < min.c) {
				min = list.get(z);
			}
		}
		
		ArrayList<ArrayList<Charc>> result = new ArrayList<>();
		ArrayList<Charc> tt = new ArrayList<>();
		tt.add(min);
		result.add(tt);
		String res = ""+min.c;
		list.remove(min.idx);
		System.out.println(res);
		
		while(list.size()!=0) {
			ArrayList<CCC> templist = new ArrayList<>();
			for(int q=0;q<list.size();q++) {
				Charc cur = list.get(q);
				CCC ccc = new CCC();
				ArrayList<Charc> temp = new ArrayList<>();
				ccc.temp = temp;
				ccc.addc = cur;
				for(Charc curr : result.get(0)) ccc.temp.add(curr);
				boolean f=false;
				int idx = ccc.addc.idx;
				for(int z=0;z<result.get(0).size();z++) {
					if(result.get(0).get(z).idx > idx) {
						temp.add(z,ccc.addc);
						f = true;
						break;
					}
				}
				if(!f) {
					temp.add(ccc.addc);
				}
				templist.add(ccc);
			}
			listc[] sortarr = new listc[templist.size()];
			for(int k=0;k<templist.size();k++) sortarr[k]=new listc("", k);
			for(int k=0;k<templist.size();k++) {
				for(Charc cur : templist.get(k).temp) sortarr[k].s+=cur.c;
			}
			Arrays.sort(sortarr,new Comparator<listc>() {

				@Override
				public int compare(listc o1, listc o2) {
					return o1.s.compareTo(o2.s);
				}
				
			});
			int i = sortarr[0].idx;
			result.add(templist.get(i).temp);
			result.remove(0);
			for(int z=0;z<list.size();z++) {
				if(list.get(z).idx==templist.get(i).addc.idx) {
					list.remove(z);
				}
			}
			System.out.println(sortarr[0].s);
		}
	}

}
