import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_12100_2048easy {
	public static int arr[][],a[],p[],size;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		size=sc.nextInt();
		p = new int[]{0,1,2,3};
		a = new int[5];
		arr = new int[size][size];
		for(int m=0;m<size;m++) {
			for(int n=0;n<size;n++) {
				arr[m][n]=sc.nextInt();
			}
		}
		max=Integer.MIN_VALUE;
		facto(0,0);
		System.out.println(max);
	}
	public static int max;
	private static void facto(int start, int count) {
		if(count==5) {
			//System.out.println(Arrays.toString(a));
			int[][] copy = new int[size][size];
			for(int z=0;z<size;z++){
                for(int x=0;x<size;x++){
                    copy[z][x]=arr[z][x];
                }
            }
			for(int i=0;i<a.length;i++) {
				if(a[i]==0)	{//상
					for(int y=0;y<size;y++) {
						int curx=0;
						while(true) {
							if(curx==size) break;
							if(copy[curx][y]!=0 && curx!=size-1) {
								int loadx=curx;
								while(true) {
									loadx++;
									if(loadx==size || copy[loadx][y]!=0 && copy[loadx][y]!=copy[curx][y]) break;
									if(copy[loadx][y]==copy[curx][y]) {
										copy[curx][y]*=2;
										copy[loadx][y]=0;
										break;
									}
								}
							}
							curx++;
						}
						curx=0;
						while(true) {
							if(curx==size) break;
							if(copy[curx][y]!=0) {
								int loadx=curx;
								while(true) {
									if(loadx==0 || copy[loadx-1][y]!=0 ) break;
									else{
										copy[loadx-1][y]=copy[loadx][y];
										copy[loadx][y]=0;
									}
									loadx--;
								}
							}
							curx++;
						}
					}
				}
				else if(a[i]==1) { // 하
					for(int y=0;y<size;y++) {
						int curx=size-1;
						while(true) {
							if(curx==-1) break;
							if(copy[curx][y]!=0 && curx!=0) {
								int loadx=curx;
								while(true) {
									loadx--;
									if(loadx==-1 || copy[loadx][y]!=0 && copy[loadx][y]!=copy[curx][y]) break;
									if(copy[loadx][y]==copy[curx][y]) {
										copy[curx][y]*=2;
										copy[loadx][y]=0;
										break;
									}
								}
							}
							curx--;
						}
						curx=size-1;
						while(true) {
							if(curx==-1) break;
							if(copy[curx][y]!=0) {
								int loadx=curx;
								while(true) {
									if(loadx==size-1 || copy[loadx+1][y]!=0 ) break;
									else{
										copy[loadx+1][y]=copy[loadx][y];
										copy[loadx][y]=0;
									}
									loadx++;
								}
							}
							curx--;
						}
					}
				}
				else if(a[i]==2) {// 우
					for(int x=0;x<size;x++) {
						int cury=size-1;
						while(true) {
							if(cury==-1) break;
							if(copy[x][cury]!=0 && cury!=0) {
								int loady=cury;
								while(true) {
									loady--;
									if(loady==-1 || copy[x][loady]!=0 && copy[x][loady]!=copy[x][cury]) break;
									if(copy[x][loady]==copy[x][cury]) {
										copy[x][cury]*=2;
										copy[x][loady]=0;
										break;
									}
								}
							}
							cury--;
						}
						cury=size-1;
						while(true) {
							if(cury==-1) break;
							if(copy[x][cury]!=0) {
								int loady=cury;
								while(true) {
									if(loady==size-1 || copy[x][loady+1]!=0 ) break;
									else{
										copy[x][loady+1]=copy[x][loady];
										copy[x][loady]=0;
									}
									loady++;
								}
							}
							cury--;
						}
					}
				}
				else {//좌
					for(int x=0;x<size;x++) {
						int cury=0;
						while(true) {
							if(cury==size) break;
							if(copy[x][cury]!=0 && cury!=size-1) {
								int loady=cury;
								while(true) {
									loady++;
									if(loady==size || copy[x][loady]!=0 && copy[x][loady]!=copy[x][cury]) break;
									if(copy[x][loady]==copy[x][cury]) {
										copy[x][cury]*=2;
										copy[x][loady]=0;
										break;
									}
								}
							}
							cury++;
						}
						cury=0;
						while(true) {
							if(cury==size) break;
							if(copy[x][cury]!=0) {
								int loady=cury;
								while(true) {
									if(loady==0 || copy[x][loady-1]!=0 ) break;
									else{
										copy[x][loady-1]=copy[x][loady];
										copy[x][loady]=0;
									}
									loady--;
								}
							}
							cury++;
						}
					}
				}
				for(int m=0;m<size;m++) {
					for(int n=0;n<size;n++) {
						if(max<copy[m][n]) max=copy[m][n];
					}
				}
			}
			
		}
		else {
			for(int i=0;i<4;i++) {
				a[count]=p[i];
				facto(start,count+1);
			}
		}
		
	}

}
