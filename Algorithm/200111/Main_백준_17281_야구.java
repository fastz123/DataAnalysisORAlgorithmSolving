import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_17281_야구{
	public static int v[], N, arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][9];

		for (int z = 0; z < N; z++) {
			String s[] = br.readLine().split(" ");
			for (int x = 0; x < 9; x++) {
				arr[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		a = new int[9];
		v = new int[9];
		max = Integer.MIN_VALUE;
		comb(0);
		System.out.println(max);
	}

	public static int a[],max;
	private static void comb(int count) {
		if (count == 9) { // r = 9-1-0인놈 갯수(1번이 0일수도잇음)
			// for()
			//System.out.print(Arrays.toString(a));
			//
			int score = check(a);
			//System.out.println(" "+score);
			if(max<score) {
				max=score;
				//System.out.print(Arrays.toString(a)+max);
				//System.out.println();
			}
		} else {
			for (int i = 1; i < 9; i++) {
				if(count==3) {
					a[count] = 0;
					count++;
					i--;
				}
				else {
					if (v[i] == 0) {
						v[i] = 1;
						a[count] = i;
						comb(count + 1);
						v[i] = 0;
					}
				}
			}
		}
	}

	private static int check(int[] ar) {
		int score=0;
		int oc=0;
		int index=0;
		int ining=0;
		Queue<Integer> q = new LinkedList<>();
		int[] queue = {0,0,0};
		for(int z=0;z<3;z++) q.offer(0);
		while(true) {
			int k = arr[ining][ar[index]];
			if(k>=1) { //1루타
				for(int base = 2; base>=0;base--) {
					if(queue[base]!=0 && base+k>=3) {
						score++;
						queue[base] =0;
					}
					else if(queue[base]!=0&&base+k <3) {
						queue[base+k] = 1;
						queue[base] = 0;
					}
					if(queue[base] ==0 && k-1 == base) {
						queue[base] = 1;
					}
				}
				if(k==4) score++;
			}
				/*q.offer(1);
				int n = q.poll();
				if(n!=0) score++;
			}
			else if(k==2) { //2루타
				q.offer(1);
				q.offer(0);
				for(int z=0;z<2;z++) {
					int n = q.poll();
					if(n!=0) score++;
				}
			}
			else if(k==3) { //3루타
				q.offer(1);
				q.offer(0);
				q.offer(0);
				for(int z=0;z<3;z++) {
					int n = q.poll();
					if(n!=0) score++;
				}
			}
			else if(k==4) { //홈런
				while(!q.isEmpty()) {
					int n = q.poll();
					if(n!=0) score++;
				}
				for(int z=0;z<3;z++) q.offer(0);
				score++;
			}*/
			else {//아웃
				oc++;
				if(oc%3==0) {
					queue = new int[]{0,0,0};
					//q = new LinkedList<>();
					//for(int z=0;z<3;z++) q.offer(0);
					ining++;
				}
			}
			if(ining==N) return score;
			index++;
			if(index>=9) index%=9;
		}
	}


}

