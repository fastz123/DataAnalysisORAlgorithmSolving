import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class Solution_SWEXPERT_모의_미생물격리 {
 
    public static class object{
        int x;
        int y;
        int num;
        int see;
        public object(int x, int y, int num, int see) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.see = see;
        }
    }
    public static ArrayList<object> list;
    public static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            String s[] = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
             
            list = new ArrayList<>();
            for(int z=0;z<k;z++) {
                s = br.readLine().split(" ");
                int p = Integer.parseInt(s[0]);
                int q = Integer.parseInt(s[1]);
                int n = Integer.parseInt(s[2]);
                int w = Integer.parseInt(s[3]);
                list.add(new object(p,q,n,w));
            }
             
            int sec=0;
             
            while(true) {
                sec++;
                Move();
                check();
                int sum=0;
                if(M==sec) {
                    for(object o : list) {
                        sum+=o.num;
                    }
                    System.out.println("#"+(i+1)+" "+sum);
                    break;
                }
            }
        }
 
    }
    private static void check() {
        ArrayList<object> arr[][] = new ArrayList[N][N];
        for(int z=0;z<N;z++) {
            for(int x=0;x<N;x++) {
                arr[z][x] = new ArrayList<>();
            }
        }
        for(object o : list) {
            arr[o.x][o.y].add(o);
        }
         
        list = new ArrayList<>();
        for(int z=0;z<N;z++) {
            for(int x=0;x<N;x++) {
                if(arr[z][x].size()>=2) {
                    Collections.sort(arr[z][x], new Comparator<object>() {
                        @Override
                        public int compare(object o1, object o2) {
                            return Integer.compare(o1.num, o2.num);
                        }
                    });
                     
                    int sum=0;
                    for(object cur:arr[z][x]) {
                        sum+=cur.num;
                    }
                    arr[z][x].get(arr[z][x].size()-1).num=sum;
                    list.add(arr[z][x].get(arr[z][x].size()-1));
                }
                else if(arr[z][x].size()==1) list.add(arr[z][x].get(0));
            }
        }
    }
    private static void Move() {
        for(object o : list) {
            if(o.see==1) {
                o.x--;
                if(o.x==0) {
                    o.num/=2;
                    o.see=2;
                }
            }
            else if(o.see==2) {
                o.x++;
                if(o.x==N-1) {
                    o.num/=2;
                    o.see=1;
                }
            }
            else if(o.see==3) {
                o.y--;
                if(o.y==0) {
                    o.num/=2;
                    o.see=4;
                }
            }
            else {
                o.y++;
                if(o.y==N-1) {
                    o.num/=2;
                    o.see=3;
                }
            }
        }
    }
 
}