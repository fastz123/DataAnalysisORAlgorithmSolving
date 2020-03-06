import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.ArrayList;import java.util.Arrays;import java.util.Collections;import java.util.Comparator;import java.util.LinkedList;import java.util.Queue;
import java.io.FileInputStream;

public class Main_백준_16236_아기상어 {	public static class fish{		int x;		int y;		int distance;		public fish(int x, int y, int distance) {			this.x = x;			this.y = y;			this.distance = distance;		}	}
	public static int v[][],di[]= {0,-1,0,1}, dj[]= {-1,0,1,0};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_아기상어.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int size = Integer.parseInt(br.readLine());
		int[][] map = new int[size][size];				int stx = -1;		int sty = -1;		for(int z=0;z<size;z++) {			String[] s = br.readLine().split(" ");			for(int x=0;x<size;x++) {				map[z][x] = Integer.parseInt(s[x]);				if(map[z][x]==9) {					stx = z;					sty = x;				}			}		}		//		fillmax(size);		Queue<int[]> q = new LinkedList<>();		int cursize = 2;		int mcnt=0;		int eatcnt=0;		while(true) {			v = new int[size][size];			ArrayList<fish> list = new ArrayList<>();			q.offer(new int[] {stx,sty,0});			while(!q.isEmpty()) {				int[] cur = q.poll();				for(int z=0;z<4;z++) {					int newx = cur[0]+di[z];					int newy = cur[1]+dj[z];					if(newx>=0 && newx<size && newy>=0 && newy<size && v[newx][newy]==0 && (newx!=stx || newy !=sty) && map[newx][newy]<=cursize) {						v[newx][newy]=cur[2]+1;						if(map[newx][newy]!=0 && map[newx][newy]<cursize) list.add(new fish(newx,newy,v[newx][newy]));						q.offer(new int[] {newx,newy,cur[2]+1});					}				}			}						if(list.size()>0) {				if(list.size()>1) {					Collections.sort(list,new Comparator<fish>() {						@Override						public int compare(fish o1, fish o2) {							if(o1.distance!=o2.distance) return Integer.compare(o1.distance, o2.distance);							else {								if(o1.x!=o2.x) return Integer.compare(o1.x, o2.x);								else return Integer.compare(o1.y, o2.y);							}						}					});				}				map[stx][sty]=0;				stx=list.get(0).x;				sty=list.get(0).y;				map[stx][sty]=9;				mcnt+=list.get(0).distance;				eatcnt++;				if(eatcnt==cursize) {					cursize++;					eatcnt=0;				}			}			else break;//			System.out.println(mcnt);		}		System.out.println(mcnt);				
	}	private static void fillmax(int size) {		for(int z=0;z<size;z++) {			for(int x=0;x<size;x++) {				v[z][x] = Integer.MAX_VALUE;			}		}	}

}
