package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// title : 이진 변환 반복하기
// type : 문자열
// time : 10m
// Created by haerin on 2023-02-02
public class 이진변환반복하기 {
    class Solution {
        public int[] solution(String s) {
            int cnt = 0;
            int cntZero = 0;
            while(!s.equals("1")){
                cnt += 1;
                cntZero += s.replaceAll("1", "").length();
                s = Integer.toString(s.replaceAll("0", "").length(), 2);
                // s = Integer.toBinaryString(s.replaceAll("0", "").length());
            }
            return new int[]{cnt, cntZero};
        }
    }
}
