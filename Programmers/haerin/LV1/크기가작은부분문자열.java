// https://school.programmers.co.kr/learn/courses/30/lessons/147355
// title : 크기가 작은 부분 문자열
// type : 문자열
// time : 5m
// Created by haerin on 2023-01-22
public class 크기가작은부분문자열 {
    class Solution {
        public int solution(String t, String p) {
            int answer = 0;

            for(int i=0; i<=t.length() - p.length(); i++){
                if(Long.parseLong(p) >= Long.parseLong(t.substring(i, i+p.length()))) {
                    answer += 1;
                }
            }
            
            return answer;
        }
    }
}
