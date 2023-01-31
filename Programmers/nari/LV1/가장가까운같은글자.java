// https://school.programmers.co.kr/learn/courses/30/lessons/142086
// title : 가장 가까운 같은 글자

import java.util.*;

public class 가장가까운같은글자 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                
                if(map.containsKey(c)) {
                    answer[i] = i - map.get(c);
                    map.put(c, i);
                }
                else {
                    map.put(c, i);
                    answer[i] = -1;
                }
            }
            
            return answer;
        }
    }
}