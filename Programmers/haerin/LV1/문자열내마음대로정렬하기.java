// https://school.programmers.co.kr/learn/courses/30/lessons/12915
// title : 문자열 내 마음대로 정렬하기
// type : 문자열 정렬
// time : 8m
// Created by haerin on 2023-01-27
import java.util.*;
public class 문자열내마음대로정렬하기 {
    // 0.616ms
    class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, new Comparator<String>(){
                @Override
                public int compare (String s1, String s2) {
                    if(s1.substring(n, n+1).equals(s2.substring(n, n+1)))
                        return s1.compareTo(s2);
                    else
                        return s1.substring(n, n+1).compareTo(s2.substring(n, n+1));
                }
            });
            return strings;
        }
    }
    // 0.532ms
    class Solution2 {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, new Comparator<String>(){
                @Override
                public int compare (String s1, String s2) {
                    if(s1.charAt(n) > s2.charAt(n)) return 1;
                    else if(s1.charAt(n) < s2.charAt(n)) return -1;
                    else return s1.compareTo(s2);
                }
            });
            return strings;
        }
    }
}
