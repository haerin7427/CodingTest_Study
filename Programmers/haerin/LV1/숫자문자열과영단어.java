// https://school.programmers.co.kr/learn/courses/30/lessons/81301
// title : 숫자 문자열과 영단어
// time : 21m
// type : 문자열
// Created by haerin on 2023/01/14
import java.util.regex.*;
public class 숫자문자열과영단어 {
    class Solution {
        public int solution(String s) {
            String words[][] = new String[][]{{"zero", "0"}, {"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"}, {"five", "5"}, {"six", "6"}, {"seven", "7"}, {"eight", "8"}, {"nine", "9"}};
            
            for(int i=0; i<words.length; i++) {
                if(Pattern.matches("[0-9]+",s)) {
                    break;
                }
                s = s.replaceAll(words[i][0], words[i][1]);
            }
            return Integer.valueOf(s);
        }
    }

    class Solution2 {
        public int solution(String s) {
            String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            
            for(int i=0; i<words.length; i++) {
                if(Pattern.matches("[0-9]+",s)) {
                    break;
                }
                s = s.replaceAll(words[i], Integer.toString(i));
            }
            return Integer.valueOf(s);
        }
    }
}
