package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12899
// title : 124 나라의 숫자
// type : 정수
// time : 19m
// Created by haerin on 2023-02-15
public class 일이사나라의숫자 {
    class Solution {
        public String solution(int n) {
            String[] rules = {"4", "1", "2"};
            StringBuilder sb = new StringBuilder();
            while(n > 0){
                sb.append(rules[n % 3]);
                if(n % 3 == 0){
                    n -= 1; 
                } // n이 3의 배수이면 자릿수가 하나 올라가기 때문에 -1을 해서 보정이 필요하다.
                 n /= 3;
            }
            return sb.reverse().toString();
        }
    }
}
