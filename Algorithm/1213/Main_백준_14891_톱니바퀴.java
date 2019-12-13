import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_백준_14891_톱니바퀴 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] topni = new int[4][8];
		
		for(int z=0;z<4;z++) {
			String s = br.readLine();
			for(int x=0;x<8;x++) {
				topni[z][x]=s.charAt(x)-'0';
			}
		}
		
		boolean checkarr[] = new boolean[3];
		
		check(topni,checkarr);	//극이 같으면 true 다르면 false
		
		int cnt = Integer.parseInt(br.readLine());
		
		for(int z=0;z<cnt;z++) {
			String s[] = br.readLine().split(" ");
			int topninum = Integer.parseInt(s[0]);
			int direction = Integer.parseInt(s[1]);
			
			rotate(topninum,direction,checkarr,topni);
			check(topni,checkarr);
		}
		int res=0;
		if(topni[0][0]==1) res+=1;
		if(topni[1][0]==1) res+=2;
		if(topni[2][0]==1) res+=4;
		if(topni[3][0]==1) res+=8;
		System.out.println(res);
	}

	private static void rotate(int topninum, int direction, boolean[] checkarr,int[][] topni) {
		
		ArrayList[] list = new ArrayList[4];
		
		for(int z=0;z<4;z++) {
			list[z] = new ArrayList<Integer>();
			for(int k=0;k<8;k++) {
				list[z].add(topni[z][k]);
			}
		}
		
		if(direction==1) {//시계방향
			Collections.rotate(list[topninum-1], 1);
		}
		else { //반시계
			Collections.rotate(list[topninum-1], 7);
		}
		
		int cur = topninum-1;
		int di = direction;
		while(cur>0) {
			// 0 1 2 3
			//  f t f
			cur--;
			di*=-1;
			if(!checkarr[cur]) {
				if(di==1) {//시계방향
					Collections.rotate(list[cur], 1);
				}
				else { //반시계
					Collections.rotate(list[cur], 7);
				}
			}
			else {
				break;
			}
		}
		cur = topninum-1;
		di = direction;
		while(cur<=2) {
			cur++;
			di*=-1;
			if(!checkarr[cur-1]) {
				if(di==1) {//시계방향
					Collections.rotate(list[cur], 1);
				}
				else { //반시계
					Collections.rotate(list[cur], 7);
				}
			}
			else {
				break;
			}
		}
		
		copying(list,topni);
	}

	

	private static void copying(ArrayList[] list, int[][] topni) {
		for(int z=0;z<4;z++) {
			for(int a=0;a<8;a++) {
				if((int)list[z].get(a)==1) {
					topni[z][a]=1;
				}
				else {
					topni[z][a]=0;
				}
			}
		}
	}

	private static void check(int[][] topni, boolean[] checkarr) {
		if(topni[0][2] == topni[1][6]) checkarr[0]=true;
		else checkarr[0]=false;
		
		if(topni[1][2] == topni[2][6]) checkarr[1]=true;
		else checkarr[1]=false;
		
		if(topni[2][2]==topni[3][6]) checkarr[2]=true;
		else checkarr[2]=false;
	}

}
