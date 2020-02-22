import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main_정올_1078_저글링방사능오염{
    public static int v[][],arr[][],x,y,count;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        y=sc.nextInt();
        x=sc.nextInt();
        arr = new int[x][y];
        for(int m=0;m<x;m++) {
            String s=sc.next();
            for(int n=0;n<y;n++) {
                arr[m][n]=s.charAt(n)-'0';
            }
        }
        int max=Integer.MIN_VALUE;
        int sty=sc.nextInt();
        int stx=sc.nextInt();
        v = new int[x][y];
        count=-1;
        bfs(stx-1,sty-1);
        int cnt=0;
        for(int m=0;m<x;m++) {
            for(int n=0;n<y;n++) {
                if(max<v[m][n]) max=v[m][n];
                if(arr[m][n]==1 && v[m][n]==0) cnt++;
            }
        }
        System.out.println(max);
        System.out.println(cnt);
         
    }
    public static Queue<int[]> q = new LinkedList();
    private static void bfs(int i, int j) {
        v[i][j]=3;
        q.offer(new int[] {i,j,count+1});
        while(!q.isEmpty()) {
            int[] cur= q.poll();
            v[cur[0]][cur[1]]=cur[2]+3;
            int di[] = {0,-1,0,1};
            int dj[] = {-1,0,1,0}; 
            for(int z=0;z<4;z++) {
                int newx = cur[0]+di[z];
                int newy = cur[1]+dj[z];
                if(newx>=0 && newx<x && newy>=0 && newy<y && v[newx][newy]==0 && arr[newx][newy]==1) {
                    q.offer(new int[] {newx,newy,cur[2]+1});
                }
            }
        }
    }
 
}