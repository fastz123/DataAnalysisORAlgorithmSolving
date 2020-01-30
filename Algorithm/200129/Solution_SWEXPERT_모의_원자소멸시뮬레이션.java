package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
 
public class Solution_SWEXPERT_모의_원자소멸시뮬레이션 {
 
    public static class Atom{
        int x;
        int y;
        int see;
        int power;
        public Atom(int x,int y, int see, int power) {
            this.x = x;
            this.y = y;
            this.see = see;
            this.power = power;
        }
    }
    public static ArrayList<Atom> list;
    public static boolean visit[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            sum=0;
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            visit = new boolean[4002][4002];
             
            for(int z=0;z<N;z++) {
                String[] s = br.readLine().split(" ");
                int x=(Integer.parseInt(s[0]) + 1000) * 2;
                int y=(Integer.parseInt(s[1]) + 1000) * 2;
                int see=Integer.parseInt(s[2]); //0,1,2,3 상하좌우
                int power=Integer.parseInt(s[3]);
                list.add(new Atom(x,y,see,power));
                visit[x][y]=true;
            }
             
            int time = 0;
            int maximum = check(list);
            sum=0;
             
             
            while(true) {
                time+=1;
                Queue<int[]> q = move();
                mapcheck(q);
                //System.out.print(time+"----------");
                //for(Atom a : list) System.out.print(a.power+" ");
                //System.out.println();
                //System.out.println(sum);
                if(list.size()<=1) break;
                if(maximum/2==time) break;
            }
             
            System.out.println("#"+(i+1)+" "+sum);
        }
 
    }
     
    public static int sum ;
    public static ArrayList<Atom>[][] map;
    public static void mapcheck(Queue<int[]> q){
 
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int z = list.size()-1;z>=0;z--) {
                Atom a = list.get(z);
                if(a.x==cur[0] && a.y==cur[1]) {
                    sum+=a.power;
                    list.remove(z);
                    if(list.size()==0) return;
                }
            }
        }
    }
 
 
    private static Queue<int[]> move() {
        Queue<int[]> q = new LinkedList<>();
        for(int z = list.size()-1;z>=0;z--) {
            Atom cur = list.get(z);
            visit[cur.x][cur.y]=false;
            if(cur.see==0) {
                cur.y+=1;
            }
            else if(cur.see==1) {
                cur.y-=1;
            }
            else if(cur.see==2) {
                cur.x-=1;
            }
            else {
                cur.x+=1;
            }
            if(cur.x>=0 && cur.x<4001 && cur.y>=0 && cur.y<4001) {
                if(visit[cur.x][cur.y]==true) {
                    q.offer(new int[] {cur.x,cur.y});
                    visit[cur.x][cur.y]=false;
                }
                else visit[cur.x][cur.y]=true;
            }
            else {
                list.remove(z);
                if(list.size()==0) return q;
            }
        }
        return q;
    }
     
    private static int check(ArrayList<Atom> list) {
        int max = Integer.MIN_VALUE;
        for(int z=0;z<list.size();z++) {
            Atom cur = list.get(z);
            int curx = cur.x;
            int cury = cur.y;
            for(int p =0;p<list.size();p++) {
                if(z!=p) {
                    int tempx = list.get(p).x;
                    int tempy = list.get(p).y;
                    int distance = Math.abs(curx-tempx)+Math.abs(cury-tempy);
                    if(max<distance) max = distance;
                }
            }
        }
        return max;
    }
 
}