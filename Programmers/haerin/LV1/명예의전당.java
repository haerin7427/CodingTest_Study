// https://school.programmers.co.kr/learn/courses/30/lessons/138477
// title : 명예의전당
// type : ...
// time : 10m
// Created by haerin on 2023-02-02
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
}