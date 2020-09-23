package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution_프로그래머스_길찾기게임 {
	public static class Node{
		int num;
		int x;
		int y;
		Node left;
		Node right;
		public Node(int num,int x,int y) {
			this.num=num;
			this.x = x;
			this.y = y;
		}
	}
	public static LinkedList<Node> prelist,postlist;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_길찾기게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		LinkedList<Node> list = new LinkedList<>();

		for(int z=0;z<T;z++) {
			String[] s = br.readLine().split(",");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			list.add(new Node(z+1,x,y));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.y != o2.y) return -Integer.compare(o1.y, o2.y);
				else return Integer.compare(o1.x, o2.x);
			}
		});
		for(Node n : list) System.out.println(n.num+" "+n.x+" "+n.y);
		Node root = null;
		for(int z=0;z<list.size();z++) {
			Node cur = list.get(z);
			if(root==null) {
				root=cur;
				continue;
			}
			Node lastnode = root;
			while(true) {
				if(lastnode.x < cur.x) {
					if(lastnode.right==null) {
						lastnode.right=cur;
						break;
					}
					lastnode = lastnode.right;
				}
				else if(lastnode.x > cur.x) {
					if(lastnode.left==null) {
						lastnode.left=cur;
						break;
					}
					lastnode = lastnode.left;
				}
			}
			
		}
		
		prelist = new LinkedList<>();
		postlist = new LinkedList<>();
		go_Pre(root);
		go_Post(root);
		
		int[][] ans = new int[2][prelist.size()];
		for(int z=0;z<list.size();z++) {
			ans[0][z] = prelist.get(z).num;
			ans[1][z] = postlist.get(z).num;
		}
		
		System.out.println(Arrays.deepToString(ans));
	}
	private static void go_Post(Node cur) {
		if(cur.left!=null) go_Post(cur.left);
		if(cur.right!=null) go_Post(cur.right);
		postlist.add(cur);
	}
	private static void go_Pre(Node cur) {
		prelist.add(cur);
		if(cur.left!=null) go_Pre(cur.left);
		if(cur.right!=null) go_Pre(cur.right);
	}
	

}
