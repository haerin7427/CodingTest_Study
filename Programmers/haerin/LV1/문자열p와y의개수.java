// https://school.programmers.co.kr/learn/courses/30/lessons/12916
// title : 문자열p와y의개수
// time : 3m
// 유형 : 문자열
// Created by haerin on 2023/01/10
public class 문자열p와y의개수 {
    class Solution {
        boolean solution(String s) {
            String onlyP = s.replaceAll("[^pP]","");
            String onlyY = s.replaceAll("[^yY]","");
    
            return onlyP.length() == onlyY.length();
        }
    }
    class Solution2 {
        boolean solution(String s) {
            return s.chars().filter(e -> e == 'p' || e == 'P').count() == s.chars().filter(e -> e == 'y' || e == 'Y').count();
        }
    }
    
}
