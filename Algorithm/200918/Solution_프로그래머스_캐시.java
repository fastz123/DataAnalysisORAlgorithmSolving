package algoProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution_프로그래머스_캐시 {
	public static class City{
        String name;
        int time;
        public City(String name, int time){
            this.name = name;
            this.time = time;
        }
    }
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_캐시.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cacheSize = Integer.parseInt(br.readLine());
		String[] cities = br.readLine().split(", ");
		
		if(cacheSize==0) System.out.println((cities.length)*5);
        //가장 최근에 순서대로 남아있는애들
        LinkedList<City> list = new LinkedList<>();
        int t = 0;
        int tm=0;
        for(String cur : cities){
            cur = cur.toLowerCase();
            if(list.size()==0){
                t+=5;
                list.offer(new City(cur,tm));
            }
            else{
                boolean f= false;
                for(City c : list){
                    if(c.name.equals(cur)){//캐시 힛
                        t+=1;
                        c.time = tm;
                        f=true;
                        break;
                    }
                }
                if(!f){ //캐시 미스
                    t+=5;
                    if(list.size() == cacheSize) {
                        Collections.sort(list, new Comparator<City>(){
                           @Override 
                           public int compare(City o1, City o2){
                               return Integer.compare(o1.time, o2.time);
                           }
                        });
                        list.poll();
                    }
                    list.offer(new City(cur,tm));
                }
            }
            for(City c : list) System.out.print(c.name+" ");
            System.out.println();
            tm++;
        }
        System.out.println(t);
		
	}

}
