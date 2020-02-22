import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
public class Main_정올_1370_회의실배정{
    public static class Meeting implements Comparable<Meeting>{
        int num;
        int start;
        int end;
        Meeting(int num,int start,int end) {
            this.num=num;
            this.start=start;
            this.end=end;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
        public int getStart() {
            return start;
        }
        public void setStart(int start) {
            this.start = start;
        }
        public int getEnd() {
            return end;
        }
        public void setEnd(int end) {
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) {
            return Integer.compare(end, o.end);
        }
        @Override
        public String toString() {
            return num+"("+start+","+end+")";
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
         
        int N = sc.nextInt();
         
        Meeting[] m = new Meeting[N];
        for(int i=0;i<N;i++) {
            m[i]=new Meeting(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
         
        Arrays.sort(m);
         
        //System.out.println(Arrays.toString(m).replace("[", "").replace("]", ""));
         
        List<Meeting> li = new ArrayList<>();
        li.add(m[0]);
        for(int i=1;i<m.length;i++) {
            if(li.get(li.size()-1).end<=m[i].start) li.add(m[i]);
        }
        System.out.println(li.size());
        for(Meeting meet:li) {
            System.out.print(meet.num+" ");
        }
    }
 
}
