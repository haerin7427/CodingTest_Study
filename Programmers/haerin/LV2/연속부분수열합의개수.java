package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/131701
// title : 연속 부분 수열 합의 개수
// type : 정수
// time : 10m
// Created by haerin on 2023-02-16
import java.util.*;
public class 연속부분수열합의개수 {
    class Solution {
        public int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i< elements.length; i++){
                int sum = elements[i];
                set.add(sum);
                for(int j=i+1; i != j % elements.length; j++){
                    sum += elements[j % elements.length];
                    set.add(sum);
                }
            }
            int answer = set.size();
            return answer;
        }
    }
}
