import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_13460_구슬탈출2 {
	public static int x,y;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_구슬탈출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		
		char[][] map = new char[x][y];
		
		
		for(int z=0;z<x;z++) {
			String ss = br.readLine();
			for(int a=0;a<y;a++) {
				map[z][a] = ss.charAt(a);
			}
		}
		min = Integer.MAX_VALUE;
		//f=false;
		dfs(map,0,true,true);
		System.out.println(min==Integer.MAX_VALUE? -1:min);
	}
	
	private static boolean[] up(char[][] map, boolean blue, boolean red) {
		int cnt=0;
		for(int z=1;z<y-1;z++) {
			int curx = 0;
			while(true) {
				curx++;
				if(curx==x-1) break;
				if(map[curx][z]=='R' || map[curx][z]=='B') {
					int cx = curx;
					char cc = map[curx][z];
					while(true) {
						cx--;
						if(cx==0) break;
						if(map[cx][z]=='.') {
							map[cx][z]=cc;
							map[cx+1][z]='.';
							cnt++;
						}
						else if(map[cx][z]=='O') {
							if(cc=='R') red=false;
							else if(cc=='B') blue = false;
							map[cx+1][z]='.';
							cnt++;
							break;
						}
						else if(map[cx][z]=='#') break;
					}
				}
			}
		}
		return new boolean[] {cnt>0? true:false,blue,red};
	}
	
	private static boolean[] down(char map[][] , boolean blue, boolean red) {
		int cnt=0;
		for(int z=1;z<y-1;z++) {
			int curx = x-1;
			while(true) {
				curx--;
				if(curx==0) break;
				if(map[curx][z]=='R' || map[curx][z]=='B') {
					int cx = curx;
					char cc = map[curx][z];
					while(true) {
						cx++;
						if(cx==x-1) break;
						if(map[cx][z]=='.') {
							map[cx][z]=cc;
							map[cx-1][z]='.';
							cnt++;
						}
						else if(map[cx][z]=='O') {
							if(cc=='R') red=false;
							else if(cc=='B') blue = false;
							map[cx-1][z]='.';
							cnt++;
							break;
						}
						else if(map[cx][z]=='#') break;
					}
				}
			}
		}
		return new boolean[] {cnt>0? true:false,blue,red};
	}
	
	private static boolean[] left(char map[][] , boolean blue, boolean red) {
		int cnt=0;
		for(int z=1;z<x-1;z++) {
			int cury = 0;
			while(true) {
				cury++;
				if(cury==y-1) break;
				if(map[z][cury]=='R' || map[z][cury] == 'B') {
					int cy = cury;
					char cc = map[z][cy];
					while(true) {
						cy--;
						if(cy==0) break;
						if(map[z][cy]=='.') {
							map[z][cy]=cc;
							map[z][cy+1]='.';
							cnt++;
						}
						else if(map[z][cy]=='O') {
							if(cc=='R') red=false;
							else if(cc=='B')blue = false;
							map[z][cy+1]='.';
							cnt++;
							break;
						}
						else if(map[z][cy]=='#') break;
					}
				}
			}
		}
		return new boolean[] {cnt>0? true:false,blue,red};
	}
	
	public static boolean f;
	private static boolean[] right(char[][] map , boolean blue, boolean red) {
		int cnt=0;
		for(int z=1;z<x-1;z++) {
			int cury = y-1;
			while(true) {
				cury--;
				if(cury==0) break;
				if(map[z][cury]=='R' || map[z][cury]=='B') {
					int cy = cury;
					char cc = map[z][cy];
					while(true) {
						cy++;
						if(cy==y-1) break;
						if(map[z][cy]=='.') {
							map[z][cy]=cc;
							map[z][cy-1]='.';
							cnt++;
						}
						else if(map[z][cy]=='O') {
							if(cc=='R') red=false;
							else if(cc=='B') blue = false;
							map[z][cy-1]='.';
							cnt++;
							break;
						}
						else if(map[z][cy]=='#') break;
					}
				}
			}
		}
		return new boolean[] {cnt>0? true:false,blue,red};
	}
	
	private static void restore(char[][] map,char[][] restoremap) {
		for(int p=1;p<x-1;p++) {
			for(int q=1;q<y-1;q++) {
				restoremap[p-1][q-1] = map[p][q];
			}
		}
	}
	
	public static int min;
	private static void dfs(char[][] map, int cnt, boolean blue, boolean red) {
		//printmap(map);
		if(cnt>min) return;
		if(cnt>10) {
			return ;
		}
		if(cnt<=10 && red==true && blue==false) {
			return;
		}
		else if(cnt<=10 && red==false && blue==true) {
			//printmap(map);
			if(cnt<min) min = cnt;
			return;
		}
		else {
			//움직이기전 맵
			char[][] restoremap = new char[x-2][y-2];
			restore(map,restoremap);
//			boolean[] b = right(map,blue,red);
//			dfs(map,cnt+1,b[1],b[2]);
			//위로 움직이기
			boolean[] b = up(map,blue,red);
//			boolean[] b = down(map,blue,red);
//			boolean[] b = left(map,blue,red);
//			b = down(map,blue,red);
//			boolean[] b = right(map,blue,red);
			if(b[0]) {
				dfs(map,cnt+1,b[1],b[2]);
				//복원
				for(int p=1;p<x-1;p++) {
					for(int q=1;q<y-1;q++) {
						map[p][q] = restoremap[p-1][q-1];
					}
				}
			}
			//-------------------------------------------------
			//아래로 움직이기
			b = down(map,blue,red);
			if(b[0]) {
				dfs(map,cnt+1,b[1],b[2]);
				//복원
				for(int p=1;p<x-1;p++) {
					for(int q=1;q<y-1;q++) {
						map[p][q] = restoremap[p-1][q-1];
					}
				}
			}
			//-------------------------------------
			//좌로
			b = left(map,blue,red);
			if(b[0]) {
				dfs(map,cnt+1,b[1],b[2]);
				//복원
				for(int p=1;p<x-1;p++) {
					for(int q=1;q<y-1;q++) {
						map[p][q] = restoremap[p-1][q-1];
					}
				}
			}
			//-------------------------------------------------
			//우로
			b = right(map,blue,red);
			if(b[0]) {
				dfs(map,cnt+1,b[1],b[2]);
				//복원
				for(int p=1;p<x-1;p++) {
					for(int q=1;q<y-1;q++) {
						map[p][q] = restoremap[p-1][q-1];
					}
				}
			}
		}
	}

	private static void printmap(char[][] map) {
		for(int p=0;p<x;p++) {
			for(int q=0;q<y;q++) {
				System.out.print(map[p][q]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

}
