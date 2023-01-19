// https://school.programmers.co.kr/learn/courses/30/lessons/12930
// title : 이상한 문자 만들기
// time : 12m
// type : 문자열
// Created by haerin on 2023/01/18
import java.util.*;
public class 이상한문자만들기 {
    // 속도 0.05ms
    class Solution {
        public String solution(String s) {
            char[] charArray = s.toUpperCase().toCharArray();
            int th = 0;
            for(int i=0; i<charArray.length; i++) {
                if(charArray[i] == ' ') {
                    th = 0;
                    continue;
                }
                
                th += 1;
                if(th % 2 == 0) {
                    charArray[i] += ('a' - 'A');
                    // charArray[i] = Character.toLowerCase(charArray[i]));
                }
            }
            
            return new String(charArray);
            // return String.valueOf(charArray); 속도면에서 큰 차이 없으나 이 방식이 미세하게 더 빠름
        }
    }
    // 문자열 처리가 속도가 훨씬 오래 걸림
    class Solution2 {
        public String solution(String s) {
            String[] sArray = s.toUpperCase().split("");
            int th = 0;
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<sArray.length; i++) {
                if(sArray[i].equals(" ")) {
                    th = 0;
                    sb.append(sArray[i]);
                    continue;
                }
                
                th += 1;
                if(th % 2 == 0) {
                    sb.append(sArray[i].toLowerCase());
                } else {
                    sb.append(sArray[i]);
                }
            }
            return sb.toString();
        }
    }
    // 속도 0.395ms
    class Solution3 {
        public String solution(String s) {
            String[] sArray = s.toUpperCase().split("");
            int th = 0;
            StringBuffer sb = new StringBuffer();
            for(String word : sArray) {
                th = word.equals(" ") ? 0 : th + 1;
                sb.append( th%2 == 0 ? word.toLowerCase() : word.toUpperCase()); 
            }
            return sb.toString();
        }
    }
}
