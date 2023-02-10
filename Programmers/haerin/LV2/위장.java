package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42578
// title : 위장
// type : HashMap
// time : 5m
// Created by haerin on 2023-02-10
import java.util.*;
public class 위장 {
    class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> map = new HashMap<>();
            for(String[] cloth : clothes) {
                map.put(cloth[1], map.getOrDefault(cloth[1],0)+1);
            }
            int answer = 1;
            for(String type : map.keySet()){
                answer *= (map.get(type)+1);
            }
            return answer-1;
        }
    }
}
