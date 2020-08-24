package algoProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main_백준_10816_숫자카드2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int z=0;z<N;z++) {
			int cur = Integer.parseInt(s[z]);
			if(map.containsKey(cur)){
				map.replace(cur, map.get(cur)+1);
			}else {
				map.put(cur, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		for(int z=0;z<M;z++) {
			int cur = Integer.parseInt(s[z]);
			if(map.get(cur)!=null) {
				bw.write(map.get(cur)+" ");
//				System.out.print(map.get(cur)+" ");
			}
			else {
//				System.out.print(0+" ");
				bw.write("0 ");
			}
		}
		
		bw.flush();
		bw.close();

	}

}
