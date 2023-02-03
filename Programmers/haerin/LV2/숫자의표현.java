package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12924
// title : 숫자의 표현
// type : 완전탐색
// time : 7m
// Created by haerin on 2023-02-03
public class 숫자의표현 {
    class Solution {
        public int solution(int n) {
            int answer = 1;
            int limit = n % 2 == 0 ? n/2 : (n+1)/2;
            for(int m = limit; m>1; m--) {
                int sum = 0;
                for (int num = m; num > 0; num--) {
                    sum += num;
                    if(sum == n) {
                        answer += 1;
                    }else if(sum > n) {
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
