package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution_프로그래머스_후보키 {
	public static int len,b[];
	public static boolean v[];
	public static String Relation[][];
	public static HashSet<int[]> CandidateKey;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_후보키.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] n = br.readLine().split(" " );
		int T = Integer.parseInt(n[0]);
		String[][] relation = new String[T][];
		for(int z=0;z<T;z++) {
			String[] s = br.readLine().split(",");
			relation[z] = s;
		}
		
		CandidateKey = new HashSet<int[]>();
		
		Relation = relation;
		len = relation[0].length;
		
		for(int i=1;i<=len;i++) {
			v = new boolean[len];
			b = new int[i];
			comb(0,0,i);
		}
		
		for(int[] cur : CandidateKey) System.out.println(Arrays.toString(cur));
	}
	private static void comb(int count, int start, int n) {
		if(count==n) {
			if(check()) {
				int[] key = new int[b.length];
				for(int k=0;k<b.length;k++) key[k]=b[k];
				CandidateKey.add(key);
			}
			return;
		}
		else {
			for(int i=start;i<len;i++) {
				if(!v[i]) {
					v[i]=true;
					b[count]=i;
					comb(count+1,i,n);
					v[i]=false;
				}
			}
		}
	}
	
	private static boolean check() {
		for(int[] cur : CandidateKey) {
			int l = cur.length;
			int cnt = 0;
			for(int c : cur) {
				for(int bc : b) {
					if(c==bc) cnt++;
				}
			}
			if(cnt==l) return false;
		}
		
		HashSet<String> set = new HashSet<>();
		
		for(String[] c : Relation) {
			StringBuffer sb = new StringBuffer();
			for(int n : b) {
				sb.append(c[n]);
			}
			set.add(sb.toString());
		}
		
		if(set.size() == Relation.length) return true;
		else return false;
	}

}
