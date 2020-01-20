import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_17406_배열돌리기4 {
	public static class turning{
		int r;
		int c;
		int s;
		public turning(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
	}
	public static turning[] ts,a;
	public static int len,arr[][],x,y,v[],min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		x=sc.nextInt();
		y = sc.nextInt();
		len = sc.nextInt();
		ts = new turning[len];
		arr = new int[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int z=0;z<len;z++) {
			ts[z]=new turning(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		v= new int[len];
		a = new turning[len];
		facto(0,0);
		System.out.println(min);
	}
	private static void facto(int start, int count) {
		if(count==len) {
			int cnt=0;
			int[][] copy=new int[x][y];
			for(turning t : a) {
				if(cnt==0) {
					copy = turn(arr,t.r,t.c,t.s);
					cnt++;
				}
				else {
					copy = turn(copy,t.r,t.c,t.s);
					cnt++;
				}
			}
			
			for(int[] a:copy) {
				int sum=0;
				for(int z=0;z<a.length;z++) {
					sum+=a[z];
				}
				if(min>sum) min=sum;
			}
		}
		else {
			for(int i=0;i<len;i++) {
				if(v[i]==0) {
					v[i]=1;
					a[count]=ts[i];
					facto(i,count+1);
					v[i]=0;
				}
			}
		}
	}
	private static int[][] turn(int[][] arr, int r,int c,int s) {
		if(s==0) return arr;
		int[][] copy = new int[x][y];
		for(int z=0;z<x;z++) {
			for(int m=0;m<y;m++) {
				copy[z][m]=arr[z][m];
			}
		}
		for(int k=0;k<(s*2)+1-1;k++) {
			copy[r-s-1][c-s+k+1-1]=arr[r-s-1][c-s+k-1];
			copy[r-s+1+k-1][c+s-1]=arr[r-s+k-1][c+s-1];
			copy[r+s-1][c+s-k-1-1]=arr[r+s-1][c+s-k-1];
			copy[r+s-1-k-1][c-s-1]=arr[r+s-1-k][c-s-1];
		}
		//System.out.println(s);
		copy = turn(copy,r,c,s-1);
		return copy;
	}
}