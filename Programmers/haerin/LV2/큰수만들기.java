package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42883
// title : 큰 수 만들기
// type : Greedy
// time : 20m
// Created by haerin on 2023-02-22
public class 큰수만들기 {
    class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            int startIdx = 0;
            int next = 0;
            
            for (int i = 0; i < number.length() - k; i++) {
                
                int max = 0;
                for (int j = startIdx; j <= i + k; j++) {
                    int current = number.charAt(j) - '0';
    
                    if (max < current) {
                        max = current;
                        next = j;
                    }
                }
                sb.append(max);
                startIdx = next + 1;
            }
            String answer = sb.toString();
            return answer;
        }
    }
}
