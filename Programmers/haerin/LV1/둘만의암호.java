// https://school.programmers.co.kr/learn/courses/30/lessons/155652
// title : 둘만의 암호
// type : 문자열
// time : 10m
// Created by haerin on 2023-02-08
import java.util.*;
public class 둘만의암호 {
    class Solution {
        public String solution(String s, String skip, int index) {
            List<Character> list = new ArrayList<>();
            for(char c : skip.toCharArray()) {
                list.add(c);
            }
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()) {
                int cnt = 0;
                while(cnt < index) {
                    c += 1;
                    if(c > 'z') c = 'a';
                    // c = c=='z' ? 'a' : (char) (c + 1);
                    while(list.contains(c)){
                        c += 1;
                        if(c > 'z') c = 'a';
                    }
                    cnt += 1;
                }
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
