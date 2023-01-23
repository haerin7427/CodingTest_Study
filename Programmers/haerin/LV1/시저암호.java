// https://school.programmers.co.kr/learn/courses/30/lessons/12926
// title : 시저 암호
// type : 문자
// time : 13m
// Created by haerin on 2023-01-23
public class 시저암호 {
    // 0.291ms
    class Solution {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                if(c == ' ') {
                    sb.append(c);
                } else {
                    int temp = c+n;
                    if(c <= 'Z' && c+n > 'Z') {
                        temp -= 26;
                    } else if (c >= 'a' && c <= 'z' && c+n > 'z') {
                        temp -= 26;
                    }
                    char temp_char = (char) temp;
                    
                    sb.append(temp_char);
                }
            }
            return sb.toString();
        }
    }
    // 0.104ms
    class Solution2 {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                char temp = c;
                if(temp >= 'A' && temp <= 'Z') {
                    temp = (char) ((temp - 'A' + n) % 26 + 'A');
                } else if (temp >= 'a' && temp <= 'z') {
                    temp = (char) ((temp - 'a' + n) % 26 + 'a');
                }           
                sb.append(temp);
            }
            return sb.toString();
        }
    }
}
