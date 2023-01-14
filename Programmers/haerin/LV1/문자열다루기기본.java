// https://school.programmers.co.kr/learn/courses/30/lessons/12918
// title : 문자열다루기기본
// time : 3m
// type : 문자열
// Created by haerin on 2023/01/14
import  java.util.regex.*;
public class 문자열다루기기본 {
    class Solution {
        public boolean solution(String s) {
            if(s.length() != 4 && s.length() != 6)
                return false;
            
            return s.replaceAll("[^0-9]","").equals(s);
            // return Pattern.matches("[0-9]+", s); 속도 더 빠름
        }
    }
    // solution2가 속도면에서 더 나음
    class Solution2 {
        public boolean solution(String s) {
            if(s.length() != 4 && s.length() != 6)
                return false;
            
            for(char c : s.toCharArray()) {
                if(c < '0' || c > '9')
                    return false;
            }
            
            return true;
        }
    }
}
