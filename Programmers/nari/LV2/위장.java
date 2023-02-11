// https://school.programmers.co.kr/learn/courses/30/lessons/42578
// title : 위장

import java.util.*;

public class 위장 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> map = new HashMap<>();
            
            for(String[] c : clothes) {
                map.put(c[1], map.getOrDefault(c[1], 0) + 1);
            }
            
            for (String key : map.keySet()) {
                // 해당 key를 입지 않을 경우 (+1)
                answer *= map.get(key)+1;
            }
            
            return answer-1;
        }
    }
}