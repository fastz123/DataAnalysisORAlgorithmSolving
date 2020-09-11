package algoProblems;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collections;
public class Solution_프로그래머스_튜플 {

	public static void main(String[] args) throws Exception {
		LinkedList<ArrayList<Integer>> list = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
        String s = br.readLine();
        for(int z=1;z<s.length()-1;z++){
            ArrayList<Integer> al = new ArrayList<>();
            if(s.charAt(z)=='{'){
                int stidx = z+1;
                int idx = z+1;
                while(true){
                    if(s.charAt(idx) == '}') break;
                    idx++;
                }
                int endidx = idx;
                String[] cur = s.substring(stidx,endidx).split(",");
                for(String c : cur){
                    al.add(Integer.parseInt(c));
                }
                z=endidx+1;
            }
            list.add(al);
        }
        
        Collections.sort(list, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                return Integer.compare(o1.size(), o2.size());
            }
        });
        
        // for(ArrayList<Integer> al:list){
        //     System.out.println(al);
        // }
        
        
        int ls = list.size();
        int[] answer = new int[list.size()];
        int k=0;
        for(int z=0;z<ls;z++){
            int cur = list.get(0).get(0);
            answer[k]=cur;
            k++;
            list.remove(0);
            deleteAll(list,cur);
        }
	}
	private static void deleteAll(LinkedList<ArrayList<Integer>> list, int delnum){
        for(ArrayList<Integer> al : list){
            int c = al.indexOf(delnum);
            al.remove(c);    
        }
    }

}
