package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_백준_18115_카드놓기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_카드놓기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<len;i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		Deque<Integer> deq = new ArrayDeque<Integer>();
		//1번 맨위 내려놓기
		//2번 맨위에서 두번쨰 내려놓기
		//3번 맨밑카드내려놓기
		int num = 1;
		for(int i=len-1;i>=0;i--) {
			int cur = arr[i];
			if(cur==1) {
				deq.offerFirst(num);
			}
			else if(cur==2) {
				int n = deq.pollFirst();
				deq.offerFirst(num);
				deq.offerFirst(n);
			}
			else {
				deq.offerLast(num);
			}
			num++;
		}

		for(int n : deq) bw.write(n+" ");
		bw.flush();
	}

}
