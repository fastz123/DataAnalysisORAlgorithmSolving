package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_프로그래머스_소수찾기 {
	public static int select[],len;
    public static String Numbers;
    public static boolean v[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String numbers = br.readLine();
		Numbers = numbers;
		len = numbers.length();
        
        for(int z=1;z<=len;z++){
            v = new boolean[len];
            select = new int[z];
            perm(0,z);
        }
	}
	
	public static int cnt;
    private static void perm(int count, int l){
        if(count==l){
            // StringBuffer sb = new StringBuffer();
            // for(int c : select)  sb.append(c);
            // int cur = Integer.parseInt(sb.toString());
            // boolean f = isPrime(cur);
            // System.out.println(f+" "+cur);
            // if(isPrime(cur)) cnt++;
            System.out.println(Arrays.toString(select));
            return;
        }
        for(int i=0;i<len;i++){
            if(!v[i]){
                v[i]=true;
                select[count]=Numbers.charAt(i)-'0';
                perm(count+1,l);
                v[i]=false;
            }
        }
    }

}
