// https://school.programmers.co.kr/learn/courses/30/lessons/142086
// title : 가장가까운같은글자
// time : 11m
// type : HashMap
// Created by haerin on 2023-01-31
import java.util.*;
public class 가장가까운같은글자 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            HashMap<Character, Integer> map = new HashMap<>();
            
            for(int i=0; i<s.length(); i++) {
                if(map.get(s.charAt(i)) == null) {
                    answer[i] = -1;
                }else {
                    answer[i] = i - map.get(s.charAt(i));
                }
                map.put(s.charAt(i), i);
            }
            
            return answer;
        }
    }
}
