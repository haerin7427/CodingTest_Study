package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/17687
// title : [3차] n진수 게임
// type : ...
// time : 11m
// Created by haerin on 2023-02-24
public class 삼차n진수게임 {
    class Solution {
        public String solution(int n, int t, int m, int p) {
            int num = 0;
            StringBuilder sb = new StringBuilder();
            // m*(t-1)+p는 플레이어가 마지막으로 언급할 숫자의 인덱스
            while(sb.length() < m*(t-1)+p){
                sb.append(Integer.toString(num++, n));
            }
            
            StringBuilder answer = new StringBuilder();
            for(int i=p-1; i< m*(t-1)+p; i+=m){
                answer.append(sb.toString().toUpperCase().charAt(i));
            }
            return answer.toString();
        }
    }
}
