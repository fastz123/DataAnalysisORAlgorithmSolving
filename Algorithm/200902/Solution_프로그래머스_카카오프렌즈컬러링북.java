package algoProblems;

import java.util.Arrays;
class Solution_프로그래머스_카카오프렌즈컬러링북 {
    public static int pic[][],M,N;
    public static boolean v[][];
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        pic = picture;
        M = m;
        N = n;
        cnt=0;
        max = Integer.MIN_VALUE;
        c=0;
        v = new boolean[m][n];
        for(int z=0;z<m;z++){
            for(int x=0;x<n;x++){
                if(pic[z][x]>=1 && !v[z][x]){
                    v[z][x]=true;
                    c=1;
                    dfs(z,x,pic[z][x]);
                    cnt++;
                    max = Math.max(max,c);
                }   
            }
        }
        
        numberOfArea = cnt;
        maxSizeOfOneArea = max;
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int di[]={0,-1,0,1}, dj[]={-1,0,1,0},cnt,max,c;
    private static void dfs(int i, int j, int cur){
        for(int z=0;z<4;z++){
            int newx = i+di[z];
            int newy = j+dj[z];
            if(newx>=0 && newx<M && newy>=0 && newy<N && pic[newx][newy]==cur &&!v[newx][newy]){
                v[newx][newy]=true;
                c++;
                dfs(newx,newy,cur);
            }
        }
    }
}