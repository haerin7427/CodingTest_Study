package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12981
// title : 영어 끝말잇기
// type : 문자열
// time : 11m
// Created by haerin on 2023-02-09
import java.util.*;
public class 영어끝말잇기 {
    // 0.061ms
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[]{0,0};
            Set<String> wordsSet = new HashSet<>();
            wordsSet.add(words[0]);
    
            for(int i=1; i<words.length; i++){
                if(!words[i].startsWith(words[i-1].substring(words[i-1].length()-1)) || wordsSet.contains(words[i])){
    
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }else {
                    wordsSet.add(words[i]);
                }
            }
    
            return answer;
        }
    }
    // 0.059ms
    class Solution2 {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[]{0,0};
            Set<String> wordsSet = new HashSet<>();
            wordsSet.add(words[0]);
    
            for(int i=1; i<words.length; i++){
                if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1) || wordsSet.contains(words[i])){
    
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }else {
                    wordsSet.add(words[i]);
                }
            }
    
            return answer;
        }
    }
}
