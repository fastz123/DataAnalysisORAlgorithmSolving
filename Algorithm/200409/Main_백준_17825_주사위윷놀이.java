package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_17825_주사위윷놀이 {

	public static class mal{
		Node curNode;

		public mal(Node curNode) {
			this.curNode = curNode;
		}
		
	}
	public static class Node{
		int num;
		Node rednext;
		Node bluenext;
		public Node(int num, Node rednext, Node bluenext) {
			this.num = num;
			this.rednext = rednext;
			this.bluenext = bluenext;
		}
		public Node(int num, Node rednext) {
			this.num = num;
			this.rednext = rednext;
		}
		public Node(int num) {
			this.num = num;
		}
	}
	public static int len,arr[];
	public static Node end;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_주사위윷놀이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		end = new Node(-999);
		Node n40 = new Node(40,end);
		Node n35 = new Node(35,n40);
		Node n30 = new Node(30,n35);
		Node n25 = new Node(25,n30);
		
		Node n38 = new Node(38,n40);
		Node n36 = new Node(36,n38);
		Node n34 = new Node(34,n36);
		Node n32 = new Node(32,n34);
		Node n26 = new Node(26,n25);
		Node n27 = new Node(27,n26);
		Node n28 = new Node(28,n27);
		Node n30b = new Node(30,n32,n28);
		
		Node n282 = new Node(28,n30b);
		Node n262 = new Node(26,n282);
		Node n242 = new Node(24,n262);
		Node n222 = new Node(22,n242);
		
		Node n24 = new Node(24,n25);
		Node n22 = new Node(22,n24);
		
		Node n20b = new Node(20,n222,n22);
		
		Node n18 = new Node(18,n20b);
		Node n16 = new Node(16,n18);
		Node n14 = new Node(14,n16);
		Node n12 = new Node(12,n14);
		
		Node n192 = new Node(19,n25);
		Node n162 = new Node(16,n192);
		Node n132 = new Node(13,n162);
		
		Node n10b = new Node(10,n12,n132);
		
		Node n8 = new Node(8,n10b);
		Node n6 = new Node(6,n8);
		Node n4 = new Node(4,n6);
		Node n2 = new Node(2,n4);
		
		Node start = new Node(-1,n2);
		
		
		len = 10;
		arr = new int[len];
		String[] s = br.readLine().split(" ");
		int z=0;
		for(String c:s) {
			arr[z] = Integer.parseInt(c);
			z+=1;
		}
//		System.out.println(Arrays.toString(arr));
		
		mal[] malarr = new mal[4];
		for(int k=0;k<4;k++) malarr[k] = new mal(start);
		max = Integer.MIN_VALUE;
		dfs(0,malarr,0);
		System.out.println(max);
	}
	public static int max;
	private static void dfs(int i,mal[] malarr,int score) {
//		System.out.println(score);
		if(checkfinish(malarr) || i>=10) {
			max = Math.max(max, score);
		}
		else {
			//0번 움직
			if(malarr[0].curNode!=end) {
				Node rem0 = malarr[0].curNode;
				if(malarr[0].curNode.bluenext==null) {
					for(int z=0;z<arr[i];z++) {
						if(malarr[0].curNode==end) break;
						malarr[0].curNode = malarr[0].curNode.rednext;
					}
				}
				else {
					malarr[0].curNode = malarr[0].curNode.bluenext;
					for(int z=0;z<arr[i]-1;z++) {
						if(malarr[0].curNode==end) break; 
						malarr[0].curNode = malarr[0].curNode.rednext;
					}
				}
				if(malarr[0].curNode==end) {
					dfs(i+1,malarr,score);
				}
				else {
					boolean f=true;
					for(int k=0;k<4;k++) {
						if(k!=0) {
							if(malarr[k].curNode == malarr[0].curNode) {
								f = false;
							}
						}
					}
					if(f) dfs(i+1,malarr,score+malarr[0].curNode.num);
				}
				malarr[0].curNode=rem0;
				
			}
			//1번 움직
			if(malarr[1].curNode!=end) {
				Node rem1 = malarr[1].curNode;
				if(malarr[1].curNode.bluenext==null) {
					for(int z=0;z<arr[i];z++) {
						if(malarr[1].curNode==end) break;
						malarr[1].curNode = malarr[1].curNode.rednext;
					}
				}
				else {
					malarr[1].curNode = malarr[1].curNode.bluenext;
					for(int z=0;z<arr[i]-1;z++) {
						if(malarr[1].curNode==end) break;
						malarr[1].curNode = malarr[1].curNode.rednext;
					}
				}
				if(malarr[1].curNode==end) dfs(i+1,malarr,score);
				else {
					boolean f=true;
					for(int k=0;k<4;k++) {
						if(k!=1) {
							if(malarr[k].curNode == malarr[1].curNode) {
								f = false;
							}
						}
					}
					if(f) dfs(i+1,malarr,score+malarr[1].curNode.num);
				}
				malarr[1].curNode=rem1;
			}
			
			//2번 움직
			if(malarr[2].curNode!=end) {
				Node rem2 = malarr[2].curNode;
				if(malarr[2].curNode.bluenext==null) {
					for(int z=0;z<arr[i];z++) {
						if(malarr[2].curNode==end) break;
						malarr[2].curNode = malarr[2].curNode.rednext;
					}
				}
				else {
					malarr[2].curNode = malarr[2].curNode.bluenext;
					for(int z=0;z<arr[i]-1;z++) {
						if(malarr[2].curNode==end) break;
						malarr[2].curNode = malarr[2].curNode.rednext;
					}
				}
				if(malarr[2].curNode==end) dfs(i+1,malarr,score);
				else {
					boolean f=true;
					for(int k=0;k<4;k++) {
						if(k!=2) {
							if(malarr[k].curNode == malarr[2].curNode) {
								f = false;
							}
						}
					}
					if(f) dfs(i+1,malarr,score+malarr[2].curNode.num);
				}
				malarr[2].curNode=rem2;
			}
			
			//3번 움직
			if(malarr[3].curNode!=end) {
				Node rem3 = malarr[3].curNode;
				if(malarr[3].curNode.bluenext==null) {
					for(int z=0;z<arr[i];z++) {
						if(malarr[3].curNode==end) break;
						malarr[3].curNode = malarr[3].curNode.rednext;
					}
				}
				else {
					malarr[3].curNode = malarr[3].curNode.bluenext;
					for(int z=0;z<arr[i]-1;z++) {
						if(malarr[3].curNode==end) break;
						malarr[3].curNode = malarr[3].curNode.rednext;
					}
				}
				if(malarr[3].curNode==end) dfs(i+1,malarr,score);
				else {
					boolean f = true;
					for(int k=0;k<4;k++) {
						if(k!=3) {
							if(malarr[k].curNode == malarr[3].curNode) {
								f = false;
							}
						}
					}
					if(f) dfs(i+1,malarr,score+malarr[3].curNode.num);
				}
				malarr[3].curNode=rem3;
			}
		}
	}
	private static boolean checkfinish(mal[] malarr) {
		int cnt = 0;
		for(mal cur : malarr) {
			if(cur.curNode.num==-999) cnt++;
		}
		if(cnt==4) return true;
		else return false;
	}
	

}
