import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_SWEXPERT_샘플_프로세서연결하기 {

	public static ArrayList<int[]> notConnectedlist;
	public static int map[][],SZ;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_SWEXPERT_샘플_프로세서연결하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int size = Integer.parseInt(br.readLine());
			SZ = size+2;
			
			map = new int[SZ][SZ];
			
			for(int z=0;z<SZ;z++) map[0][z] = 9;
			for(int z=0;z<SZ;z++) map[z][0] = 9;
			for(int z=0;z<SZ;z++) map[SZ-1][z]=9;
			for(int z=0;z<SZ;z++) map[z][SZ-1]=9;
			
			notConnectedlist = new ArrayList<>();
			
			for(int z=1;z<=size;z++) {
				String[] s = br.readLine().split(" ");
				for(int x=1;x<=size;x++) {
					map[z][x] = Integer.parseInt(s[x-1]);
					if((map[z][x]==1) && ((map[z-1][x]==9) || (map[z][x-1]==9) || (map[z+1][x]==9) || (map[z][x+1]==9))) {
						
					}
					else if(map[z][x]==1) {
						notConnectedlist.add(new int[] {z,x});
					}
				}
			}
			
			ArrayList<int[]> selectlist;
			maxconcnt = new int[notConnectedlist.size()];
			Arrays.fill(maxconcnt, Integer.MAX_VALUE);
			Connect(notConnectedlist,notConnectedlist.size(),0,0,0);
			
			System.out.println("#"+(i+1)+" "+min);
			
		}

	}
	
	public static int maxconcnt[],min;
	private static void Connect(ArrayList<int[]> selectlist,int len,int idx,int cnt, int concnt) {
		if(len<=idx) {
//			printmap();
			if(concnt==0) maxconcnt[0]=0;
			else if(maxconcnt[concnt-1]>cnt) maxconcnt[concnt-1] = cnt;
//			System.out.println(Arrays.toString(maxconcnt));
			for(int z=maxconcnt.length-1;z>=0;z--) {
				if(maxconcnt[z]!=Integer.MAX_VALUE) {
					min = maxconcnt[z];
					break;
				}
			}
			return;
		}
		else {
			
			//상하좌우 연결
			int cur[] = selectlist.get(idx);
			int x = cur[0];
			int y = cur[1];
			//상으로 붙이기
			boolean f=true;
			int bp=0;
			int addcnt=0;
			for(int cx = x-1; cx>=1;cx--) {
				if(map[cx][y]==1 || map[cx][y]==7) {
					f=false;
					bp=cx;
					break;
				}
				map[cx][y]=7;
				addcnt++;
			}
			if(f) {
				Connect(selectlist,len,idx+1,cnt+addcnt,concnt+1);
				//복구
				for(int cx = x-1; cx>=1;cx--) {
					if(map[cx][y]==1) {
						break;
					}
					else if(map[cx][y]==7) map[cx][y]=0;
				}
			}
			else {
				for(int cx = x-1; cx>bp;cx--) {
					map[cx][y]=0;
				}
			}
			//--------------------------------------
			
			//하로 붙이기
			f=true;
			bp=0;
			addcnt=0;
			for(int cx=x+1;cx<SZ-1;cx++) {
				if(map[cx][y]==1 || map[cx][y]==7) {
					f=false;
					bp=cx;
					break;
				}
				map[cx][y]=7;
				addcnt++;
			}
			if(f) {
				Connect(selectlist,len,idx+1,cnt+addcnt,concnt+1);
				//복구
				for(int cx=x+1;cx<SZ-1;cx++) {
					if(map[cx][y]==1) {
						break;
					}
					else if(map[cx][y]==7) map[cx][y]=0;
				}
			}
			else {
				for(int cx=x+1;cx<bp;cx++) {
					map[cx][y]=0;
				}
			}
			
			//------------------------------------
			
			//좌로 붙이기
			f=true;
			bp=0;
			addcnt=0;
			for(int cy=y-1;cy>=1;cy--) {
				if(map[x][cy]==1 || map[x][cy]==7) {
					f=false;
					bp=cy;
					break;
				}
				map[x][cy]=7;
				addcnt++;
			}
			if(f) {
				Connect(selectlist,len,idx+1,cnt+addcnt,concnt+1);
				//복구
				for(int cy=y-1;cy>=1;cy--) {
					if(map[x][cy]==1) {
						break;
					}
					else if(map[x][cy]==7) map[x][cy]=0;
				}
			}
			else {
				for(int cy=y-1;cy>bp;cy--) {
					map[x][cy]=0;
				}
			}
			//------------------------------------
			
			//우로 붙이기
			f=true;
			bp=0;
			addcnt=0;
			for(int cy=y+1;cy<SZ-1;cy++) {
				if(map[x][cy]==7 || map[x][cy]==1) {
					f=false;
					bp=cy;
					break;
				}
				map[x][cy]=7;
				addcnt++;
			}
			if(f) {
				Connect(selectlist,len,idx+1,cnt+addcnt,concnt+1);
				for(int cy=y+1;cy<SZ-1;cy++) {
					if(map[x][cy]==1) {
						break;
					}
					else if(map[x][cy]==7) map[x][cy]=0;
				}
			}
			else {
				for(int cy=y+1;cy<bp;cy++) {
					map[x][cy]=0;
				}
			}
			
			//------------------------------------
			
			//안붙이기
			Connect(selectlist,len,idx+1,cnt,concnt);
		}
		
		
	}
	private static void printmap() {
		for(int[] a:map) {
			for(int k:a) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
	}

}
