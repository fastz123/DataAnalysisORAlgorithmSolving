import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution_SWEXPERT_모의_원자소멸시뮬레이션 {

	public static class Atom{
		float x;
		float y;
		int see;
		int power;
		public Atom(float x, float y, int see, int power) {
			this.x = x;
			this.y = y;
			this.see = see;
			this.power = power;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_원소시.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			sum=0;
			int N = Integer.parseInt(br.readLine());
			ArrayList<Atom> list = new ArrayList<>();
			for(int z=0;z<N;z++) {
				String[] s = br.readLine().split(" ");
				float x=Integer.parseInt(s[0]);
				float y=Integer.parseInt(s[1]);
				int see=Integer.parseInt(s[2]); //0,1,2,3 상하좌우
				int power=Integer.parseInt(s[3]);
				sum+=power;
				list.add(new Atom(x,y,see,power));
			}
			
			float time = 0;
			float maximum = check(list);
			
			while(true) {
				time+=0.5;
				move(list);
				HashMap<String, Integer> map = new HashMap<>();
				list = pop(list,map);
				if(list.size()<=1) break;
				if(time==maximum) break;
			}
			int tot = 0;
			for(Atom p : list) tot+=p.power;
			System.out.println("#"+(i+1)+" "+(sum-tot));
		}

	}
	
	public static int sum ;
	private static ArrayList<Atom> pop(ArrayList<Atom> list, HashMap<String, Integer> map) {
		for(int z=0;z<list.size();z++) {
			String s = ""+list.get(z).x+" "+list.get(z).y;
			if(map.get(s)==null) map.put(s, 1);
			else if(map.get(s)==1) {
				map.put(s, map.get(s)+1);
			}
		}
		
		ArrayList<Atom> curlist = new ArrayList<>();
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			String s[] = key.split(" ");
			int val = entry.getValue();
			if(val==1) {
				float curx = Float.parseFloat(s[0]);
				float cury = Float.parseFloat(s[1]);
				for(Atom a : list) {
					if(a.x==curx && a.y==cury) {
						curlist.add(a);
						break;
					}
				}
			}
		}
		return curlist;
	}

	private static void move(ArrayList<Atom> list) {
		for(Atom cur : list) {
			if(cur.see==0) {
				cur.y+=0.5;
			}
			else if(cur.see==1) {
				cur.y-=0.5;
			}
			else if(cur.see==2) {
				cur.x-=0.5;
			}
			else {
				cur.x+=0.5;
			}
		}
	}
	
	private static float check(ArrayList<Atom> list) {
		float max = Float.MIN_VALUE;
		for(int z=0;z<list.size();z++) {
			Atom cur = list.get(z);
			float curx = cur.x;
			float cury = cur.y;
			for(int p =0;p<list.size();p++) {
				if(z!=p) {
					float tempx = list.get(p).x;
					float tempy = list.get(p).y;
					float distance = Math.abs(curx-tempx)+Math.abs(cury-tempy);
					if(max<distance) max = distance;
				}
			}
		}
		return max;
	}

}
