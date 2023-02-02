// https://school.programmers.co.kr/learn/courses/30/lessons/118666
// title: 성격유형검사하기
// type : ...
// time : 15m
// Created by haerin on 2023-02-02
import java.util.*;
public class 성격유형검사하기 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            String[] types = new String[]{"RT", "CF", "JM", "AN"};
            HashMap<Character, Integer> recode = new HashMap<>();
            for(int i=0; i<choices.length; i++) {
                if(choices[i] == 4) continue;
                
                if(choices[i] < 4) {
                    recode.put(survey[i].charAt(0), recode.getOrDefault(survey[i].charAt(0), 0) + 4-choices[i]);
                }else {
                    recode.put(survey[i].charAt(1), recode.getOrDefault(survey[i].charAt(1), 0) + choices[i]-4);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<types.length; i++){
                char type = recode.getOrDefault(types[i].charAt(0), 0) < recode.getOrDefault(types[i].charAt(1), 0) ? types[i].charAt(1) : types[i].charAt(0);
                sb.append(type);
            }
            return sb.toString();
        }
    }
}
