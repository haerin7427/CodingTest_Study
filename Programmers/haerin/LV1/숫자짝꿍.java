// https://school.programmers.co.kr/learn/courses/30/lessons/131128
// title : 숫자짝꿍
// type : ...
// time : 14m
// Created by haerin on 2023-02-06
import java.util.*;
public class 숫자짝꿍 {
    // 테스트 케이스 기준 평균 속도 solution2가 더 빠름
    class Solution {
        public String solution(String X, String Y) {
            HashMap<Character, Integer> map = new HashMap<>();
            ArrayList<Character> list = new ArrayList<>();
            for(char x : X.toCharArray()) {
                map.put(x, map.getOrDefault(x,0)+1);
            }
            for(char y : Y.toCharArray()) {
                if(map.get(y) != null && map.get(y) > 0) {
                    list.add(y); 
                    map.put(y, map.get(y)-1);
                }
            }
            if(list.size() == 0) return "-1";
            
            Collections.sort(list, Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for(char c : list) {
                sb.append(c);
            }
            
            if(sb.toString().matches("0+")) return "0";
            return sb.toString();
        }
    }
    class Solution2 {
        public String solution(String X, String Y) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(char x : X.toCharArray()) {
                map.put(x, map.getOrDefault(x,0)+1);
            }
            
            StringBuilder sb = new StringBuilder();
            for(char y : Y.toCharArray()) {
                if(map.get(y) != null && map.get(y) > 0) {
                    sb.append(y);
                    map.put(y, map.get(y)-1);
                }
            }
            
            if(sb.length() == 0) return "-1";
            if(sb.toString().matches("0+")) return "0";
            
            char[] charArr = sb.toString().toCharArray();
            Arrays.sort(charArr);
            return new StringBuilder(new String(charArr)).reverse().toString();
        }
    }
}
