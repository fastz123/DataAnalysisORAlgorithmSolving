package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution_프로그래머스_프렌즈4블록 {
	public static char[][] map;
    public static int M,N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_프렌즈4블록.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int m = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);
		
		String[] board = br.readLine().split(" "); 
		M=m;
        N=n;
        map = new char[m][n];
        for(int z=0;z<m;z++){
            for(int x=0;x<n;x++){
                map[z][x] = board[z].charAt(x);
            }
        }
        
        HashSet<Integer> set;
        int cnt = 0;
        while(true){
            printmap();
            set = new HashSet<>();
            for(int z=0;z<m-1;z++){
                for(int x=0;x<n-1;x++){
                    char c = map[z][x];
                    if(c!='X' && map[z][x+1]==c && map[z+1][x]==c && map[z+1][x+1]==c){
                        set.add(z*n+x);
                        set.add((z+1)*n+x);
                        set.add((z*n)+x+1);
                        set.add((z+1)*n+x+1);
                    }
                }
            }
            
            if(set.size()==0) break;
            else{
                ArrayList<Integer> list = new ArrayList<>(set);
                cnt += list.size();
                crash(list);
                down();
            }
        }

	}
	private static void printmap(){
        for(char[] a:map){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }
    
    private static void down(){
        
        for(int z=0;z<N;z++){
            int curx = M;
            while(true){
                curx--;
                if(curx<0) break;
                if(map[curx][z]=='X'){
                    int cx = curx;
                    while(true){
                        cx--;
                        if(cx<0) break;
                        if(map[cx][z]!='X') {
                            map[curx][z] = map[cx][z];
                            map[cx][z]='X';
                            break;
                        }
                    }
                    
                }
            }
        }
    }
    
    private static void crash(ArrayList<Integer> list){
        for(int cur : list){
            map[cur/N][cur%N] = 'X';
        }
    }

}
