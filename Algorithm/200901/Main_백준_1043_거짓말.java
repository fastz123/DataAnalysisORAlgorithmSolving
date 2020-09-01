package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_1043_거짓말 {
	public static int N,map[][];
	public static boolean v[];
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		s = br.readLine().split(" ");
		ArrayList<Integer> KnowPeople = new ArrayList();
		int len = Integer.parseInt(s[0]);
		for(int z=1;z<=len;z++) {
			KnowPeople.add(Integer.parseInt(s[z])-1);
		}
		
		ArrayList<Integer>[] party = new ArrayList[M];
		map = new int[N][N];
		int cnt = 0;
		for(int z=0;z<M;z++) {
			party[z] = new ArrayList<Integer>();
			s = br.readLine().split(" ");
			len = Integer.parseInt(s[0]);
			for(int p=1;p<=len;p++) party[z].add(Integer.parseInt(s[p])-1);
		}
		
		for(int z=0;z<M;z++) {
			ArrayList<Integer> list = party[z];
			for(int p=0;p<list.size();p++) {
				for(int q=0;q<list.size();q++) {
					if(p!=q) {
						map[list.get(p)][list.get(q)]=1;
					}
				}
			}
		}
		
		v = new boolean[N];
		for(int cur : KnowPeople) {
			if(!v[cur]) {
				v[cur]=true;
				dfs(cur);
			}
		}
		
//		System.out.println(Arrays.toString(v));
		ArrayList<Integer> Flist = new ArrayList<Integer>();
		for(int z=0;z<N;z++) {
			if(!v[z]) Flist.add(z);
		}
		
		if(Flist.size()==0) {
			bw.write(0+"\n");
//			return;
		}
		else {
			for(int z=0;z<M;z++) {
				if(check(party[z],Flist)) cnt++;
			}
			
			bw.write(cnt+"\n");
			
		}
		
		bw.flush();
		bw.close();
		
		
		
	}


	


	private static void dfs(int i) {
		for(int z=0;z<N;z++) {
			if(map[i][z]==1 && !v[z]) {
				v[z]=true;
				dfs(z);
			}
		}
	}





	private static boolean check(ArrayList<Integer> party, ArrayList<Integer> Flist) {
		for(int z=0;z<party.size();z++) {
			int cur = party.get(z);
			if(!Flist.contains(cur)) return false;
		}
		return true;
	}

}
