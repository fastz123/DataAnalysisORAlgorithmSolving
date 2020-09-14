package algoProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_프로그래머스_삼각달팽이 {
	public static int arr[][],N,totcnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		N=n;
        arr = new int[n][];
        for(int z=0;z<n;z++) arr[z] = new int[z+1];
        totcnt = ((1+n)*n)/2;
        draw(0,0,1,n);
        
        int[] answer = new int[totcnt];
        int idx = 0;
        for(int[] a:arr) {
        	for(int cur : a) {
        		answer[idx] = cur;
        		idx++;
        	}
        }

        System.out.println(Arrays.toString(answer));
	}

	private static void printmap(){
        for(int z=0;z<N;z++) {
            System.out.println(Arrays.toString(arr[z]));
        }
        System.out.println();
    }
    public static boolean f;
    private static void draw(int stx,int sty,int cnt, int n){
        if(f) return;
        int c = cnt;
        for(int z=0;z<n;z++){
            arr[stx+z][sty] = c;
            if(c==totcnt) {
                f = true;
                return;
            }
            c++;
        }
        
        for(int z=1;z<n;z++){
            arr[stx+n-1][z+sty] = c;
            if(c==totcnt) {
                f = true;
                return;
            }
            c++;
        }
        
        for(int z=n-1;z>1;z--){
            arr[stx+z-1][sty+z-1] = c;
            if(c==totcnt) {
                f = true;
                return;
            }
            c++;
        }
        
        draw(stx+2,sty+1,c,n-3);
    }
}
