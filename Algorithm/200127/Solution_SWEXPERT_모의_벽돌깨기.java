package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_SWEXPERT_모의_벽돌깨기 {
 
    public static int N,W,H,arr[][],copy[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            W = Integer.parseInt(s[1]);
            H = Integer.parseInt(s[2]);
             
            arr = new int[H][W];
            copy = new int[H][W];
            for(int z=0;z<H;z++) {
                s = br.readLine().split(" ");
                for(int x=0;x<W;x++) {
                    arr[z][x] = Integer.parseInt(s[x]);
                    copy[z][x] = Integer.parseInt(s[x]);
                }
            }
            b = new int[N];
            min = Integer.MAX_VALUE;
            perm(0);
            System.out.println("#"+(i+1)+" "+min);
        }
 
    }
 
    public static int b[],min;
    private static void perm(int count) {
        if(count==N) {
            //System.out.print(Arrays.toString(b));
            drop(b);
            int cur = check(arr);
            //System.out.println(cur);
            if(min > cur) {
                min = cur;
            }
            restore();
        }
        else {
            for(int i=0;i<W;i++) {
                b[count] = i;
                perm(count+1);
            }
        }
    }
    private static void restore() {
        for(int z=0;z<H;z++) {
            for(int x=0;x<W;x++) {
                arr[z][x] = copy[z][x];
            }
        }
    }
    private static int check(int[][] arr2) {
        int cnt=0;
        for(int z=0;z<H;z++) {
            for(int x=0;x<W;x++) {
                if(arr[z][x]!=0) cnt++;
            }
        }
        return cnt;
         
    }
    private static void drop(int[] b) {
         
        for(int cur:b) {
            int cy = cur;
            int cx = 0;
            while(true) {
                if(cx>=H) break;
                if(arr[cx][cy]!=0) break;
                cx++;
            }
            if(cx<H) crash(cx,cy,arr[cx][cy]-1);
            down(arr);
        }
    }
     
    private static void down(int[][] arr2) {
         
        for(int z=0;z<W;z++) {
            int cx = H;
            while(true) {
                cx--;
                if(cx<0) break;
                if(arr2[cx][z]!=0) {
                    int curx = cx;
                    while(true) {
                        if(curx+1<H && arr2[curx+1][z]==0) {
                            arr2[curx+1][z] = arr2[curx][z];
                            arr2[curx][z]=0;
                        }
                        else break;
                        curx++;
                    }
                }
            }
        }
    }
    private static void crash(int cx, int cy,int len) {
        arr[cx][cy]=0;
        for(int z = cx-len;z<=cx+len;z++) {
            if(z>=0 && z<H) {
                if(arr[z][cy]>=2) crash(z,cy,arr[z][cy]-1);
                arr[z][cy]=0;
            }
        }
        for(int x=cy-len;x<=cy+len;x++) {
            if(x>=0 && x<W) {
                if(arr[cx][x]>=2) crash(cx,x,arr[cx][x]-1);
                arr[cx][x] = 0;
            }
        }
    }
 
}