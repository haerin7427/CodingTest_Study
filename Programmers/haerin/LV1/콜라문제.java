// https://school.programmers.co.kr/learn/courses/30/lessons/132267?language=java
// title : 콜라 문제
// time : 6m
// type : 숫자
// Created by haerin on 2023-01-19
public class 콜라문제 {
    //  0.030ms
    class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;
            while(a <= n) {
                answer += (n/a)*b;
                n = n%a + (n/a)*b;
            }
            
            return answer;
        }
    }
}
