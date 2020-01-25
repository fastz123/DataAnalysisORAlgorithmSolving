import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_SWEXPERT_모의_무선충전 {

	public static class Person{
		int x;
		int y;
		int cur_amount;
		public Person(int x, int y, int cur_amount) {
			this.x = x;
			this.y = y;
			this.cur_amount = cur_amount;
		}
	}
	
	public static class Carea{
		int x;
		int y;
		int amount;
		public Carea(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}
	
	public static ArrayList<Integer> map[][];
	public static Person p1,p2;
	public static Carea[] charger;
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_무선충전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			int time = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[1]);
			
			arr = new int[2][time];
			for(int z=0;z<2;z++) {
				s = br.readLine().split(" ");
				for(int x=0;x<time;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			
			map = new ArrayList[10][10];
			
			for(int p=0;p<10;p++) {
				for(int q=0;q<10;q++) {
					map[p][q] = new ArrayList<>();
				}
			}
			
			charger = new Carea[N];
			
			for(int z=0;z<N;z++) {
				s = br.readLine().split(" ");
				int cy=Integer.parseInt(s[0])-1;
				int cx=Integer.parseInt(s[1])-1;
				int size = Integer.parseInt(s[2]);
				int amount = Integer.parseInt(s[3]);
				
				charger[z] = new Carea(cx, cy, amount);
				
				for(int p=cx-size;p<=cx+size;p++) {
					for(int q=cy-size;q<=cy+size;q++) {
						if(p>=0 && p<10 && q>=0 && q<10 && (Math.abs(cx-p)+Math.abs(cy-q))<=size) {
							map[p][q].add(z+1);
						}
					}
				}
			}
			
			p1 = new Person(0, 0, 0);
			p2 = new Person(9, 9, 0);
			
			int ans = 0;
			int idx=0;
			while(true) {
				int max = check();
				ans+=max;
				if(idx==time) break;
				move(idx);
				idx++;
			}
			
			System.out.println("#"+(i+1)+" "+ans);
		}

	}

	private static void move(int t) {
		if(arr[0][t]==1) { //상
			p1.x--;
		}
		else if(arr[0][t]==2) {// 우
			p1.y++;
		}
		else if(arr[0][t]==3) { //하
			p1.x++;
		}
		else if(arr[0][t]==4) {//좌
			p1.y--;
		}
		
		if(arr[1][t]==1) { //상
			p2.x--;
		}
		else if(arr[1][t]==2) {// 우
			p2.y++;
		}
		else if(arr[1][t]==3) { //하
			p2.x++;
		}
		else if(arr[1][t]==4) {//좌
			p2.y--;
		}
	}

	private static int check() {
		
		int curx1 = p1.x;
		int cury1 = p1.y;
		
		int curx2 = p2.x;
		int cury2 = p2.y;
		
		ArrayList<Integer> p1list = map[curx1][cury1];
		ArrayList<Integer> p2list = map[curx2][cury2];
		
//		if(map[curx1][cury1].size()>0) {
//			for(int cur : map[curx1][cury1]) p1list.add(cur);
//		}
//		if(map[curx2][cury2].size()>0) {
//			for(int cur : map[curx2][cury2]) p2list.add(cur);
//		}
		
		int max = 0;
		if(p1list.size()>0 && p2list.size()>0) {
			for(int p1cur : p1list) {
				for(int p2cur: p2list) {
					if(p1cur!=p2cur) {
						int curchar =  charger[p1cur-1].amount + charger[p2cur-1].amount;
						if(curchar>max) max = curchar;
					}
					else {
						int curchar = charger[p1cur-1].amount;
						if(curchar>max) max = curchar;
					}
				}
			}
		}
		else if(p1list.size()==0 && p2list.size()>0) {
			for(int p2cur : p2list) {
				int curchar = charger[p2cur-1].amount;
				if(curchar>max) max = curchar;
			}
		}
		else if(p1list.size()>0 && p2list.size()==0) {
			for(int p1cur : p1list) {
				int curchar = charger[p1cur-1].amount;
				if(curchar>max) max = curchar;
			}
		}
		else max=0;
		
		return max;
	}

}
