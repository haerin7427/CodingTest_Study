// https://school.programmers.co.kr/learn/courses/30/lessons/12933
// title : 정수 내림차순으로 배치하기
// time : 6m
// 유형 : 문자열
// Created by haerin on 2023/01/12
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class 정수내림차순으로배치하기 {
    class Solution {
        public long solution(long n) {
            String s = Stream.of(String.valueOf(n).split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
            return Long.valueOf(s);
        }
    }
    
}
