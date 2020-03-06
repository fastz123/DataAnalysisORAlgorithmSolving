import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
 
public class Main_정올_2247_도서관{
 
    public static class p {
        int i;
        int o;
        public p(int i, int o) {
            this.i = i;
            this.o = o;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int n = Integer.parseInt(br.readLine());
        ArrayList<p> list = new ArrayList<>();
        for(int z=0;z<n;z++) {
            String s[] = br.readLine().split(" ");
            int in=Integer.parseInt(s[0]);
            int out=Integer.parseInt(s[1]);
            list.add(new p(in,out));
        }
         
        Collections.sort(list, new Comparator<p>() {
            @Override
            public int compare(p o1, p o2) {
                if(o1.i<o2.i) return -1;
                else if(o1.i==o2.i) return 0;
                else return 1;
            }
             
        });
         
        //for(p a:list) System.out.println(a.i+" "+a.o);
         
        int in=list.get(0).i;
        int out=list.get(0).o;
        int inmax=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for(int z=1;z<list.size();z++) {
            if(list.get(z).i <= out) {
                if(list.get(z).o > out) {
                    out=list.get(z).o;
                }
            }
            else {
                int gap = list.get(z).i-out;
                if(gap>max) max=gap;
                in=list.get(z).i;
                out=list.get(z).o;
            }
            int ingap= out-in;
            if(inmax<ingap) inmax=ingap;
        }
        System.out.println(inmax+" "+max);
    }
 
}