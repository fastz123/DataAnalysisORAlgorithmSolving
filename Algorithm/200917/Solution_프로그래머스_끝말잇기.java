package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_프로그래머스_끝말잇기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_끝말잇기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] words = br.readLine().split(" ");
		
		int[] answer = new int[2];
        int[] c = new int[n];     
        c[0]++;
        int cnt = 1;
        int me = 1;
        while(true){
            if(cnt == words.length) {
//                return answer = new int[]{0,0};
            	System.out.println(Arrays.toString(answer));
            	break;
            }
            String meStr = words[cnt];
            if(check(words,cnt)){
                String befStr = words[cnt-1];
                if(befStr.charAt(befStr.length()-1) != meStr.charAt(0)){
                    c[me]+=1;
                    break;
                }
            }
            else{
                break;
            }
            
            cnt++;
            c[me]++;
            me = (me+1)%n;
        }

        answer = new int[]{me+1,c[me]+1};
        System.out.println(Arrays.toString(answer));
//        return answer;

	}
	
	private static boolean check(String[] words, int me){
        String meStr = words[me];
        for(int z=me-1;z>=0;z--){
            if(meStr.equals(words[z])) return false;
        }
        return true;
    }

}
