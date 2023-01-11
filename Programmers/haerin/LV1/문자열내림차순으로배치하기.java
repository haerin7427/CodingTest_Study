// https://school.programmers.co.kr/learn/courses/30/lessons/12917
// title : 문자열 내림차순으로 배치하기
// time : 7m
// 유형 : 문자열
// Created by haerin on 2023/01/11
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class 문자열내림차순으로배치하기 {
    class Solution {
        public String solution(String s) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            StringBuffer sb = new StringBuffer(new String(charArr));
            return sb.reverse().toString();
        }
        public String solution2(String s) {
            return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        }
    }
}