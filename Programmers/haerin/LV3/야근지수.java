package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12927
// title : 야근 지수
// type : PriorityQueue
// time : 17m
// Created by haerin on 2023-03-14
import java.util.*;
public class 야근지수 {
    class Solution {
        public long solution(int n, int[] works) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for(int work : works){
                pq.add(work);
            }
    
            while(n > 0 && !pq.isEmpty()){
                int now = pq.remove();
                now -= 1;
                n -= 1;
                if(now > 0)
                pq.add(now);
            }
            
            
            long answer = 0;
            while(!pq.isEmpty()){
                int value = pq.remove();
                answer += Math.pow(value, 2);
            }
            return answer;
        }
    }
}
