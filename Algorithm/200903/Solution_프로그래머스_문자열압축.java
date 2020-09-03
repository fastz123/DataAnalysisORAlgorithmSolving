package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_프로그래머스_문자열압축 {
	public static class Word{
		String cur;
		int cnt;
		public Word(String cur, int cnt) {
			this.cur = cur;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_문자열압축.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int answer = 0;
		int len = s.length();
        int hl = len/2;
        int min = Integer.MAX_VALUE;
        
        String front = s.substring(0,hl);
        String back = s.substring(hl);
         System.out.println(front+" "+back);
        if(hl==0) {
        	min = 1;
        	System.out.println(min);
        	return;
        }
        else if(front.equals(back)) min = Math.min(min, (hl)+1);
//    	hl--;
        while(hl>0){
            Queue<String> q = new LinkedList<>();
            for(int z=0;z<len;z+=hl){
                if(z+hl<= len){
                    String sub = s.substring(z,z+hl);
                    q.offer(sub);
                }
            }
            if(len%hl!=0) q.offer(s.substring((len/hl)*hl));
            for(String ss : q) System.out.print(ss+" ");
            System.out.println();

            String result="";

            ArrayList<Word> list = new ArrayList<>();
            int cnt = 1;
            int max = Integer.MIN_VALUE;
            while(!q.isEmpty()){
                String cur = q.poll();
                while(cur.equals(q.peek())){
                    String temp = q.poll();
                    cnt++;
                }
                
                max = Math.max(max, cnt);
                Word ss = new Word(cur,cnt);
                list.add(ss);
                cnt=1;
            }

            for(Word c : list) {
            	if(c.cnt==1) {
            		for(int p=0;p<c.cnt;p++) {
            			result+=c.cur;
            		}
            	}
            	else {
            		result += c.cnt + c.cur;
            	}
            }
            
            min = Math.min(min, result.length());
            System.out.println(result);
            hl--;
        }
        
        System.out.println(min);
        

	}

}
