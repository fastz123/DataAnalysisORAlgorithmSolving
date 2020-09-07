package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution_프로그래머스_디스트컨트롤러 {
	public static class Job{
		int in;
		int work;
		int end;
		public Job(int in, int work) {
			this.in = in;
			this.work = work;
			this.end = -1;
		}
		
	}
	public static class Workplace{
		Job curjob;
		int startTime;
		int endTime;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_디스크컨트롤러.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		PriorityQueue<Job> pq = new PriorityQueue<Job>(new Comparator<Job>() {
			
			@Override
			public int compare(Job o1, Job o2) {
//				if(o1.in!=o2.in) return Integer.compare(o1.in, o2.in);
//				else 
				return Integer.compare(o1.work, o2.work);
			}
		});
		
		LinkedList<Job> list = new LinkedList();
		for(int z=0;z<T;z++) {
			String[] s = br.readLine().split(" ");
			int in = Integer.parseInt(s[0]);
			int work = Integer.parseInt(s[1]);
			list.add(new Job(in,work));
		}
		
		Collections.sort(list, new Comparator<Job>() {

			@Override
            public int compare(Job o1, Job o2){
                return Integer.compare(o1.in,o2.in);
            }
		});
		
		int time = 0;
		Workplace wp = new Workplace();
		ArrayList<Job> endlist = new ArrayList();
		while(true) {
			if(list.isEmpty() && wp.curjob == null) {
				break;
			}
			
			while(!list.isEmpty()) {
				if(time==list.peek().in) pq.offer(list.poll());
				else if(time<list.peek().in) break;
			}
			
			if(wp.curjob != null) {
				if(time-wp.startTime==wp.curjob.work) {
					wp.endTime=time;
					wp.curjob.end = time;
					endlist.add(wp.curjob);
					wp.curjob=null;
					wp.startTime=-1;
					wp.endTime=-1;
					
					Job cur = pq.poll();
					wp.curjob = cur;
					wp.startTime = time;
				}
			}
			else {
				Job cur = pq.poll();
				wp.curjob = cur;
				wp.startTime = time;
			}
			time++;
		}
		
		int sum = 0;
		for(Job j: endlist) {
			sum += j.end-j.in;
		}
		
		System.out.println(sum/T);
	}
}
