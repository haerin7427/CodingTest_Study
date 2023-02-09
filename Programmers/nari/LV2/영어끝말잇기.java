// https://school.programmers.co.kr/learn/courses/30/lessons/12981
// title : 영어 끝말잇기

import java.util.*;

public class 영어끝말잇기 {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            HashMap<String, Integer> map = new HashMap<>();
            boolean finish = true;
            
            map.put(words[0], 1);
            char last = words[0].charAt(words[0].length()-1);
            answer[1]++;
            
            for(int i=1;i<words.length;i++) {
                // 몇 번째 차례인지 -> 1번 사람일 때마다 count
                if(i%n == 0) answer[1]++;
                
                // 이전에 말한 단어 나온 경우
                // 끝 단어와 첫 단어가 같은 단어가 아닌 경우
                if(map.containsKey(words[i]) || last != words[i].charAt(0)) {
                    answer[0] = i%n + 1;
                    finish = false;
                    break;
                }
                
                map.put(words[i], 1);
                last = words[i].charAt(words[i].length()-1);
            }

            if(finish) answer[1] = 0;
            
            return answer;
        }
    }
}