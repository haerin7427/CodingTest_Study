// https://school.programmers.co.kr/learn/courses/30/lessons/12922
// title : 가수박수박수박수박수박수?
// time : 4m
// 유형 : 문자열
// Created by haerin on 2023/01/10
public class 수박수박수박수박수박수 {
    class Solution {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i < n/2; i++) {
                sb.append("수박");
            }
            if(n%2 != 0) {
                sb.append("수");
            }
            return sb.toString();
        }
    }
}
