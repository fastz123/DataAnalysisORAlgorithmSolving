import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEXPERT_2383_점심식사시간 {

	public static class Person{
		int x;
		int y;
		int distance1;
		int distance2;
		int dtime;
		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Stairs{
		int x;
		int y;
		int len;
		ArrayList<Person> q;
		public Stairs(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
			this.q = new ArrayList<>();
		}
		
	}
	
	public static ArrayList<Person> list_a,list_b;
	public static ArrayList<Stairs> slist;
	public static int min;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_점심식사시간.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int size = Integer.parseInt(br.readLine());
//			int[][] map = new int[size][size];
			
			ArrayList<Person> plist = new ArrayList<>();
			slist = new ArrayList<>();
			
			for(int z=0;z<size;z++) {
				String[] s = br.readLine().split(" ");
				for(int x=0;x<size;x++) {
					int cur = Integer.parseInt(s[x]);
//					map[z][x] = cur;
					if(cur == 1) plist.add(new Person(z,x));
					else if(cur>=2) slist.add(new Stairs(z,x,cur));
				}
			}
			
			Stairs s1 = slist.get(0);
			Stairs s2 = slist.get(1);
			
			for(Person p : plist) {
				p.distance1 = Math.abs(p.x-s1.x) + Math.abs(p.y-s1.y);
				p.distance2 = Math.abs(p.x-s2.x) + Math.abs(p.y-s2.y);
			}
			
			int pc = plist.size();
			min = Integer.MAX_VALUE;
			
			for(long z=0;z<(1<<pc);z++) {
				list_a = new ArrayList<>();
				list_b = new ArrayList<>();
				for(int k=0;k<pc;k++) {
					if((z&(1<<k))> 0) list_a.add(plist.get(k));
					else list_b.add(plist.get(k));
				}
				
				int t = check();
				min = Math.min(t, min);
			}
			
			System.out.println("#"+(i+1)+" "+(min+1));
		}

	}
	private static int check() {
		Stairs s1 = slist.get(0);
		Stairs s2 = slist.get(1);
//		System.out.print("list_a: ");
//		for(Person p : list_a) {
//			System.out.print(p.x+" "+p.y+"/");
//		}
//		System.out.println();
//		System.out.print("list_b: ");
//		for(Person p : list_b) {
//			System.out.print(p.x+" "+p.y+"/");
//		}
//		System.out.println();
		int time = 0;
		while(true) {
//			System.out.println(time+"---------------------");
			
			if(s1.q.size()>0) {
				for(int z=0;z<s1.q.size();z++) {
					Person p = s1.q.get(z);
					if(p.dtime>0) p.dtime--;
					if(p.dtime==0) {
//						System.out.println(p.x+" "+p.y+" 는 계단 내려옴");
						s1.q.remove(z);
						z--;
					}
				}
			}
			if(s2.q.size()>0) {
				for(int z=0;z<s2.q.size();z++) {
					Person p = s2.q.get(z);
					if(p.dtime>0) p.dtime--;
					if(p.dtime==0) {
						s2.q.remove(z);
//						System.out.println(p.x+" "+p.y+" 는 계단 내려옴");
						z--;
					}
				}
			}
			
			if((list_a.size()==0 && list_b.size()==0) && (s1.q.size()==0 && s2.q.size()==0)) break;
			
			if(list_a.size()>0) {
				for(int z=0;z<list_a.size();z++) {
					Person p = list_a.get(z);
					if(p.distance1-time <= 0) {
						if(s1.q.size()<3)	{
							list_a.remove(p);
							z--;
							p.dtime = s1.len;
							s1.q.add(p);
//							System.out.println(p.x+" "+p.y+" 는 1번 계단 진입");
						}
					}
				}
			}
			
			if(list_b.size()>0) {
				for(int z=0;z<list_b.size();z++) {
					Person p = list_b.get(z);
					if(p.distance2-time <= 0) {
						if(s2.q.size()<3) {
							list_b.remove(p);
							z--;
							p.dtime = s2.len;
							s2.q.add(p);
//							System.out.println(p.x+" "+p.y+" 는 2번 계단 진입");
						}
					}
				}
			}
			if(time>min) return 999;
			time++;
		}
//		System.out.println(time);
//		System.out.println("--------------------------------------------");
		return time;
	}

}
