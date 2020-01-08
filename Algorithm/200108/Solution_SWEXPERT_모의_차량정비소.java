import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_SWEXPERT_모의_차량정비소 {
 
    public static class People{
        int arrivaltime;
        int a;
        int b;
        int num;
        int time;
        public People(int arrivaltime,  int num) {
            this.arrivaltime = arrivaltime;
            this.num = num;
        }
    }
    public static int A,B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            String[] s = br.readLine().split(" ");
             
            int N = Integer.parseInt(s[0]); //접수 창구 개수
            int[] receptionDesk = new int[N];
             
            int M = Integer.parseInt(s[1]); //정비 창구 개수
            int[] repairtDesk = new int[M];
             
            int K = Integer.parseInt(s[2]); //방문인원수
            People[] people = new People[K];
             
            A = Integer.parseInt(s[3]); //접수창구
            B = Integer.parseInt(s[4]); //정비창구
             
            s = br.readLine().split(" ");
            for(int z=0;z<N;z++) {
                receptionDesk[z] = Integer.parseInt(s[z]);
            }
             
            s = br.readLine().split(" ");
            for(int z=0;z<M;z++) {
                repairtDesk[z] = Integer.parseInt(s[z]);
            }
             
            s = br.readLine().split(" ");
            for(int z=0;z<K;z++) {
                people[z] = new People(Integer.parseInt(s[z]),z+1);
            }
             
            ArrayList<People> recq = new ArrayList<>();
            ArrayList<People> repbq = new ArrayList<>();
            ArrayList<People> repq = new ArrayList<>();
            ArrayList<People> finish = new ArrayList<>();
             
            People[] rec = new People[N];
            People[] rep = new People[M];
             
             
             
            int sec=0;
            while(true) {
                for(int z=0;z<K;z++) {
                    if(people[z].arrivaltime==sec) {
                        recq.add(people[z]);
                        //System.out.println((1+z)+" is reception ready");
                    }
                }
                 
                Collections.sort(recq,new Comparator<People>() {
                    @Override
                    public int compare(People o1, People o2) {
                        return Integer.compare(o1.num, o2.num);
                    }
                });
                 
                int move = 0;
                for(int z=0;z<N;z++) {
                    if(rec[z]==null) {
                        if(recq.size()>=1) {
                            rec[z] = recq.get(0);
                            recq.remove(0);
                            rec[z].a=z+1;
                            rec[z].time=1;
                            //System.out.println(rec[z].num+" being reception");
                        }
                    }
                    else {
                        if(rec[z].time<receptionDesk[z]) {
                            rec[z].time++;
                            //System.out.println(rec[z].num+" time up");
                        }
                        else if(rec[z].time==receptionDesk[z]) {
                            repbq.add(rec[z]);
                            //System.out.println(rec[z].num+" is end of reception");
                            rec[z] = null;
                            if(recq.size()>=1) {
                                rec[z] = recq.get(0);
                                recq.remove(0);
                                rec[z].a=z+1;
                                rec[z].time=1;
                                //System.out.println(rec[z].num+" being reception");
                            }
                            move++;
                        }
                    }
                }
                 
                if(move>=2) {
                    Collections.sort(repbq, new Comparator<People>() {
                        @Override
                        public int compare(People o1, People o2) {
                            return Integer.compare(o1.a, o2.a);
                        }
                    });
                }
                if(repbq.size()>=1) {
                    while(!repbq.isEmpty()) {
                        repq.add(repbq.get(0));
                        //System.out.println(repbq.get(0).num+" is repair ready");
                        repbq.remove(0);
                    }
                }
                     
                for(int z=0;z<M;z++) {
                    if(rep[z]==null) {
                        if(repq.size()>=1) {
                            rep[z] = repq.get(0);
                            repq.remove(0);
                            rep[z].time=1;
                            rep[z].b=z+1;
                            //System.out.println(rep[z].num+" being repair");
                        }
                    }
                    else {
                        if(rep[z].time<repairtDesk[z]) {
                            rep[z].time++;
                            //System.out.println(rep[z].num+" time up");
                        }
                        else if(rep[z].time==repairtDesk[z]) {
                            finish.add(rep[z]);
                            //System.out.println("finish"+" "+rep[z].num);
                            rep[z] = null;
                            if(repq.size()>=1) {
                                rep[z] = repq.get(0);
                                repq.remove(0);
                                rep[z].time=1;
                                rep[z].b=z+1;
                                //System.out.println(rep[z].num+" being repair");
                            }
                        }
                    }
                }
                if(finish.size()==K) {
                    int cnt = check(finish);
                    System.out.println("#"+(i+1)+" "+(cnt==0? -1:cnt));
                    break;
                }
                sec++;
                //System.out.println("--------------------------");
            }
        }
    }
    private static int check(ArrayList<People> finish) {
        int sum=0;
        for(People p : finish) {
            if(p.a==A && p.b==B) sum+=p.num;
        }
        return sum;
    }
 
}