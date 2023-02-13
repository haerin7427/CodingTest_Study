package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/87390
// title : n^2 배열 자르기
// type : 정수
// time : 18m
// Created by haerin on 2023-02-13
public class n제곱배열자르기 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            int size = (int)(right-left)+1;
            int[] answer = new int[size];
            int idx=0;
            for(long i = left; i <= right; i++){
                long y = i / n;
                long x = i % n;
                
                answer[idx++] = (int) Math.max(y,x)+1;
            }
            return answer;
        }
    }
}
