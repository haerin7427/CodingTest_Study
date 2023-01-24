// https://school.programmers.co.kr/learn/courses/30/lessons/12921
// title : 소수 찾기
// type : 정수 계산
// time : 6m
// Created by haerin on 2023-01-24
public class 소수찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for(int i=2; i<=n; i++) {
                boolean isPrime = true;
                for(int j=2; j<=Math.sqrt(i); j++) {
                    if(i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
