import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_SWEXPERT_2477_차량정비소 {
	public static class Customer{
		int num;
		int time;
		int arrtime;
		int Anum;
		int Bnum;
		public Customer(int num, int time, int arrtime) {
			this.num = num;
			this.time = time;
			this.arrtime = arrtime;
		}
	}
	public static class Box{
		int time;
		Customer cur;
		public Box(int time) {
			this.time = time;
		}
	}
	public static int N,M,K;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_차량정비소.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]); //접수창구수
			M = Integer.parseInt(s[1]); //정비창구수
			K = Integer.parseInt(s[2]); //고객수
			int A = Integer.parseInt(s[3]); //접수창구번호
			int B = Integer.parseInt(s[4]); //정비창구번호
			
			Box[] info = new Box[N];
			Box[] repair = new Box[M];
			
			s = br.readLine().split(" ");
			for(int z=0;z<N;z++) info[z] = new Box(Integer.parseInt(s[z]));
			s = br.readLine().split(" ");
			for(int z=0;z<M;z++) repair[z] = new Box(Integer.parseInt(s[z]));
			
			int[] ctime = new int[K];
			s = br.readLine().split(" ");
			ArrayList<Customer> list = new ArrayList<>();
			for(int z=0;z<K;z++) {
				ctime[z] = Integer.parseInt(s[z]);
				list.add(new Customer(z+1,0,ctime[z]));
			}
			
			int t = 0;
			Queue<Customer> ipgu = new LinkedList<>();
			PriorityQueue<Customer> befreadyq = new PriorityQueue<>(new Comparator<Customer>() {
				@Override
				public int compare(Customer o1, Customer o2) {
					return Integer.compare(o1.Anum, o2.Anum);
				}
			});
			Queue<Customer> readyq = new LinkedList<>();
			ArrayList<Customer> endlist = new ArrayList<>();
			while(true) {
				if(endlist.size()==K) break;
				//접수대기
				gotoipgu(list,ipgu,t);
				
				//접수창구 ㄱ
				gotoinfo(info,ipgu,befreadyq);
				//정비대기
				gotoready(befreadyq,readyq,repair,endlist);
				
//				System.out.println("----------------"+t+"----------------");
//				System.out.println(endlist.size());
//				printres(ipgu,info,readyq,repair);
				
				//끝
				t++;
				
			}
			
			int ans = 0;
			for(Customer c : endlist) {
				if(c.Anum == A && c.Bnum == B) {
					ans+=c.num;
//					System.out.println(c.num +" "+c.Anum+" "+c.Bnum);
				}
			}
			System.out.println("#"+(i+1)+" "+(ans==0? -1:ans));
		}

	}
	private static void printres(Queue<Customer> ipgu, Box[] info, Queue<Customer> readyq, Box[] repair) {
		System.out.println("입구");
		for(Customer c: ipgu) System.out.print(c.num+" ");
		System.out.println();
		System.out.println("접수창구");
		for(Box b : info) {
			if(b.cur!=null)	System.out.print(b.cur.num+" ");
			else System.out.print("0 ");
		}
		System.out.println();
		System.out.println("정비대기");
		for(Customer c:readyq) System.out.print(c.num+" ");
		System.out.println();
		System.out.println("정비창구");
		for(Box b : repair) {
			if(b.cur!=null)	System.out.print(b.cur.num+" ");
			else System.out.print("0 ");
		}
		System.out.println();
		
	}
	private static void gotoready(PriorityQueue<Customer> befreadyq, Queue<Customer> readyq, Box[] repair,
			ArrayList<Customer> endlist) {
		
		while(!befreadyq.isEmpty())	readyq.offer(befreadyq.poll());
		for(int z=0;z<M;z++) {
			if(repair[z].cur == null) {
				if(!readyq.isEmpty()) {
					repair[z].cur = readyq.poll();
					repair[z].cur.time = repair[z].time;
					repair[z].cur.Bnum = z+1;
				}
			}
			else {
				repair[z].cur.time--;
				if(repair[z].cur.time==0) {
					endlist.add(repair[z].cur);
					repair[z].cur = null;
					if(!readyq.isEmpty()) {
						repair[z].cur = readyq.poll();
						repair[z].cur.time = repair[z].time;
						repair[z].cur.Bnum = z+1;
					}
				}
			}
		}
		
	}
	private static void gotoinfo(Box[] info, Queue<Customer> ipgu, PriorityQueue<Customer> befreadyq) {
		int cnt = 0;
		for(int z=0;z<N;z++) {
			if(info[z].cur == null) {
				if(!ipgu.isEmpty()) {
					info[z].cur = ipgu.poll();
					info[z].cur.time = info[z].time;
					info[z].cur.Anum = z+1;
				}
			}
			else {
				info[z].cur.time--;
				if(info[z].cur.time==0) {
					befreadyq.offer(info[z].cur);
					info[z].cur = null;
					if(!ipgu.isEmpty()) {
						info[z].cur = ipgu.poll();
						info[z].cur.time = info[z].time;
						info[z].cur.Anum = z+1;
					}
				}
			}
		}
		
	}
	private static void gotoipgu(ArrayList<Customer> list, Queue<Customer> ipgu, int t) {
		for(int z=0;z<list.size();z++) {
			Customer c = list.get(z);
			if(c.arrtime == t) {
				ipgu.offer(c);
				list.remove(c);
				z--;
			}
			else if(c.arrtime > t) break;
		}
		
	}

}
