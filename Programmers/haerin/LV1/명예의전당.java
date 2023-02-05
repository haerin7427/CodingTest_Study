// https://school.programmers.co.kr/learn/courses/30/lessons/138477
// title : 명예의전당
// type : ...
// time : 10m
// Created by haerin on 2023-02-02, 2023-02-05
import java.util.*;
public class 명예의전당 {
    class Solution {
        public int[] solution(int k, int[] score) {
            List<Integer> list = new LinkedList<>();
            int[] answer = new int[score.length];
            int idx=0;
            for(int s : score) {
                if(list.size() < k) {
                    list.add(s);
                    Collections.sort(list);
                }else if(list.get(0) < s) {
                    list.remove(0);
                    list.add(s);
                    Collections.sort(list);
                }
                answer[idx++] = list.get(0);
            }
            return answer;
        }
    }
    // priorityQueue 사용이 속도가 더 빠름
    class Solution2 {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            
            for(int i=0; i<score.length; i++) {
                if(pq.size() < k) {
                    pq.add(score[i]);
                }else if(pq.peek() < score[i]) {
                    pq.remove();
                    pq.add(score[i]);
                }
                answer[i] = pq.peek();
            }
            return answer;
        }
    }
}