package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution_프로그래머스_오픈채팅방2 {
	public static class Print{
		String id;
		boolean isin;
		public Print(String id, boolean isin) {
			this.id=id;
			this.isin = isin;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_오픈채팅방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] record = br.readLine().split(",");

		HashMap<String, String> umap = new HashMap<>();
		
		LinkedList<Print> plist = new LinkedList<>();
		
		for(int z=0;z<record.length;z++) {
			String[] cur = record[z].split(" ");
			String doing = cur[0];
			String id = cur[1];
			String name = new String();
			
			if(doing.equals("Enter")) {
				name = cur[2];
				if(umap.get(id)==null) {
					umap.put(id, name);
				}
				else {
					umap.replace(id, name);
				}
				plist.add(new Print(id,true));
			}
			else if(doing.equals("Leave")) {
				plist.add(new Print(id,false));
			}
			else {
				name = cur[2];
				umap.replace(id, name);
			}
		}
		String[] answer = new String[plist.size()];
		int idx = 0;
		for(Print p : plist) {
			String id = p.id;
			boolean isin = p.isin;
			if(isin) answer[idx] = umap.get(id)+"님이 들어왔습니다.";
			else answer[idx] = umap.get(id)+"님이 나갔습니다.";
			idx++;
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
