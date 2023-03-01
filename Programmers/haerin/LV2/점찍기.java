package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/140107
// title : 점 찍기
// type : 수학
// time : 12m
// Created by haerin on 2023-03-01
public class 점찍기 {
    class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            for(int a=0; a*k<=d; a++){
                long num = (long) Math.sqrt(Math.pow(d,2) - Math.pow(a*k,2)); // x^2+y^2=r^2 원의 공식 사용
                num /= k; // k로 나눠줘야 최대 b값을 구할 수 있음
                answer += (num+1); // b가 0이 될수있으므로 b의 최댓값+1을 해서 개수를 구함
            }
            return answer;
        }
    }
}
