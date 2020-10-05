package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_14654_스테판쿼리 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_스테판쿼리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[2][T];
		
		for(int z=0;z<2;z++) {
			String[] s= br.readLine().split(" ");
			for(int x=0;x<T;x++) {
				arr[z][x] = Integer.parseInt(s[x]);
			}
		}
		
		Boolean whowin = null;//A = false, B=true
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		
		for(int z=0;z<T;z++) {
			int A = arr[0][z];
			int B = arr[1][z];
			
			if(z==0) {
				if(A==1) {
					if(B==2) {
						whowin=true;
					}
					else if(B==3) {
						whowin=false;
					}
				}
				
				else if(A==2) {
					if(B==1) {
						whowin=false;
					}
					else if(B==3) {
						whowin=true;
					}
				}
				else {
					if(B==1) {
						whowin=true;
					}
					else if(B==2) {
						whowin=false;
					}
				}
				cnt++;
				max=cnt;
				continue;
			}
			
			if(A==1) {//가위
				if(B==1) {
					//무승부
					//whowin이 true에서 비겼다면
					//A승
					if(whowin) {
						whowin=false;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						whowin=true;
						max = Math.max(max, cnt);
						cnt=1;
					}
				}
				else if(B==2) {
					//바위 B승
					if(whowin==false) {
						whowin = true;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						cnt++;
					}
				}
				else {//보 A승
					if(whowin==true) {
						whowin=false;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						cnt++;
					}
				}
			}
			else if(A==2) {//바위
				if(B==1) {//가위 A승
					if(whowin==true) {
						whowin=false;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						cnt++;
					}
				}
				else if(B==2) {//바위
					if(whowin) {
						whowin=false;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						whowin=true;
						max = Math.max(max, cnt);
						cnt=1;
					}
				}
				else {
					if(whowin==false) {
						whowin = true;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						cnt++;
					}
				}
			}
			else {//보
				if(B==1) {//가위 B승
					if(whowin==false) {
						whowin = true;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						cnt++;
					}
				}
				else if(B==2) {//바위 A승
					if(whowin==true) {
						whowin=false;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						cnt++;
					}
				}
				else {
					if(whowin) {
						whowin=false;
						max = Math.max(max, cnt);
						cnt=1;
					}
					else {
						whowin=true;
						max = Math.max(max, cnt);
						cnt=1;
					}
				}
			}
		}
		
		System.out.println(max>cnt? max:cnt);

	}

}
