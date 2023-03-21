package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12904
// title : 가장 긴 팰린드롬
// type : 문자열
// time : 15m
// Created by haerin on 2023-03-21
public class 가장긴팰린드롬 {
    class Solution{
        public int solution(String s){
            int answer = 0;
            for(int i=0; i<s.length(); i++){
                // 홀수일 경우
                int cnt = 1, a = i-1, b = i+1;
                while(a >= 0 && b < s.length()){
                    if(s.charAt(a) != s.charAt(b)) break;
                    cnt += 2;
                    a -= 1;
                    b += 1;
                }
                answer = Math.max(answer, cnt);
                
                // 짝수일 경우
                cnt = 0; a = i; b = i+1;
                while(a >= 0 && b < s.length()){
                    if(s.charAt(a) != s.charAt(b)) break;
                    cnt += 2;
                    a -= 1;
                    b += 1;
                }
                answer = Math.max(answer, cnt);
            }
            return answer;
        }
    }
}