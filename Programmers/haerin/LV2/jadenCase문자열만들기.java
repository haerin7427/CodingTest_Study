package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12951
// title : JadenCase 문자열 만들기
// time : 17m
// type : 문자열
// Created by haerin on 2023-01-30
public class jadenCase문자열만들기 {
    class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            for(String str : s.split(" ")){
                sb.append(" ");
                if(str.equals("")){
                    continue;
                }else if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                    sb.append(str.substring(0,1));
                    sb.append(str.substring(1).toLowerCase());
                }else{
                    sb.append(str.substring(0,1).toUpperCase());
                    sb.append(str.substring(1).toLowerCase());
                }
            }
            if(s.charAt(s.length()-1) == ' ') {
                sb.append(" ");
            }
            
            return sb.toString().substring(1);
        }
    }
}
