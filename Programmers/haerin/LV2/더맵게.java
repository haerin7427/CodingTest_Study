package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42626
// title : 더 맵게
// type : Heap
// time : 6m
// Created by haerin on 2023-02-22
import java.util.*;
public class 더맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int s : scoville){
                pq.add(s);
            }
            int answer = 0;
            while(pq.peek() < K){
                if(pq.size() < 2){
                    answer = -1;
                    break;
                }
                answer += 1;
                int n1 = pq.remove();
                int n2 = pq.remove();
                pq.offer(n1+n2*2);
            }
            return answer;
        }
    }
}
