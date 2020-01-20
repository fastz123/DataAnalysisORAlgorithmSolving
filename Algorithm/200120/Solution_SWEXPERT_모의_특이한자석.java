import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_SWEXPERT_모의_특이한자석 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_특이한자석.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int movecnt = Integer.parseInt(br.readLine());
			int[][] arr = new int[4][8];
			for(int z=0;z<4;z++) {
				String[] s= br.readLine().split(" ");
				for(int x=0;x<8;x++) {
					arr[z][x] = Integer.parseInt(s[x]);
				}
			}
			
			ArrayList<int[]> list = new ArrayList<>();
			for(int z=0;z<movecnt;z++) {
				String s[] = br.readLine().split(" ");
				list.add(new int[] {Integer.parseInt(s[0])-1,Integer.parseInt(s[1])});
			}
			
//			System.out.println(Arrays.deepToString(arr));
//			for(int[] a:list) System.out.println(a[0]+" "+a[1]);
			for(int z=0;z<movecnt;z++) {
				boolean[] checklist = check(arr);
				move(checklist,list.get(z),arr);
//				for(int[] ar:arr) System.out.println(Arrays.toString(ar));
//				System.out.println("--------------------------------------");
			}
			
			int sum1=0;
			int sum2=0;
			int sum3=0;
			int sum4=0;
			if(arr[0][0]==1) sum1 = 1;
			if(arr[1][0]==1) sum2 = 2;
			if(arr[2][0]==1) sum3 = 4;
			if(arr[3][0]==1) sum4 = 8;
			System.out.println("#"+(i+1)+" "+(sum1+sum2+sum3+sum4));
		}
	}

	private static boolean[] check(int[][] arr) {
		boolean[] checklist = new boolean[3];
		if(arr[0][2]!=arr[1][6]) checklist[0]=true;
		if(arr[1][2]!=arr[2][6]) checklist[1]=true;
		if(arr[2][2]!=arr[3][6]) checklist[2]=true;
		return checklist;
	}

	private static void move(boolean[] checklist ,int[] cur,int[][] arr) {
		int where = cur[0];
		int direction = cur[1];
		
		if(direction==1) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int z=0;z<8;z++) list.add(arr[where][z]);
			Collections.rotate(list, 1);
			for(int z=0;z<8;z++) arr[where][z] = list.get(z);
		}
		else {
			ArrayList<Integer> list = new ArrayList<>();
			for(int z=0;z<8;z++) list.add(arr[where][z]);
			Collections.rotate(list, -1);
			for(int z=0;z<8;z++) arr[where][z] = list.get(z);
		}
		//left
case1:	while(where>0) {
			where--;
			direction*=-1;
			if(checklist[where]) {
				if(direction==1) {
					ArrayList<Integer> list = new ArrayList<>();
					for(int z=0;z<8;z++) list.add(arr[where][z]);
					Collections.rotate(list, 1);
					for(int z=0;z<8;z++) arr[where][z] = list.get(z);
				}
				else {
					ArrayList<Integer> list = new ArrayList<>();
					for(int z=0;z<8;z++) list.add(arr[where][z]);
					Collections.rotate(list, -1);
					for(int z=0;z<8;z++) arr[where][z] = list.get(z);
				}
			}
			else break case1;
		}
		where = cur[0];
		direction = cur[1];
case2:	while(where<3) {
			direction*=-1;
			if(checklist[where]) {
				if(direction==1) {
					ArrayList<Integer> list = new ArrayList<>();
					for(int z=0;z<8;z++) list.add(arr[where+1][z]);
					Collections.rotate(list, 1);
					for(int z=0;z<8;z++) arr[where+1][z] = list.get(z);
				}
				else {
					ArrayList<Integer> list = new ArrayList<>();
					for(int z=0;z<8;z++) list.add(arr[where+1][z]);
					Collections.rotate(list, -1);
					for(int z=0;z<8;z++) arr[where+1][z] = list.get(z);
				}
			}
			else break case2;
			where++;
		}
	}
}
