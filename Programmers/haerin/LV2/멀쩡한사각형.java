package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/62048
// title : 멀쩡한사각형
// type : 일차함수
// time : 4m
// Created by haerin on 2023-02-27
public class 멀쩡한사각형 {
    class Solution {
        public long solution(int w, int h) {
            double a = -1.0 * h / w;
            long answer = 0;
            for(int x=1; x<w; x++){
                answer += (long)(a*x+h);
            }
            return answer*2;
        }
    }
}
