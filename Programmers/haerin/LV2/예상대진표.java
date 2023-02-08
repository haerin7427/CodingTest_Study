package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12985
// title : 예상 대진표
// type : 정수
// time : 17m
// Created by haerin on 2023-02-08
public class 예상대진표 {
    class Solution {
        public int solution(int n, int a, int b)
        {
            int answer = 1;
            int min = Math.min(a,b);
            int max = Math.max(a,b);

            while(max-min != 1 || min%2 != 1) {
                answer += 1;
                min = min%2==0 ? min/2 : (min+1)/2;
                max = max%2==0 ? max/2 : (max+1)/2;
            }

            return answer;
        }
    }
}
