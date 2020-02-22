import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
 
public class Main_정올_1828_냉장고{
    public static class sten implements Comparable<sten>{
        int st;
        int end;
         
        public sten(int st, int end) {
            this.st = st;
            this.end = end;
        }
 
        @Override
        public int compareTo(sten o) {
            if (this.st > o.st) return 1;
            else if (this.st == o.st) return 0;
            else return -1;
        }
         
         
    }
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        ArrayList<sten> list = new ArrayList<>();
        int T = sc.nextInt();
        for(int z=0;z<T;z++) {
            int st=sc.nextInt();
            int e=sc.nextInt();
            list.add(new sten(st,e));
        }
        Collections.sort(list);
        //for(sten e:list) System.out.println(e.st+" "+e.end);
        int z=1;
        int arr[]=new int[2];
        arr[0]=list.get(0).st;
        arr[1]=list.get(0).end;
        int cnt=0;
        while(true) {
            if(arr[1]<list.get(z).st) {
                cnt++;
                //System.out.println(Arrays.toString(arr));
                arr[0]=list.get(z).st;
                arr[1]=list.get(z).end;
            }
            else if(arr[1] >= list.get(z).st) {
                arr[0]=list.get(z).st;
            }
            if(arr[1] > list.get(z).end) {
                arr[1]=list.get(z).end;
            }
            z++;
            if(z==list.size()) break;
            //System.out.println(Arrays.toString(arr));
        }
        System.out.println(cnt+1);
    }
 
}