// https://school.programmers.co.kr/learn/courses/30/lessons/160586
// title : 대충 만든 자판
// type : hashmap
// time : 10m
// Created by haerin on 2023-03-13
import java.util.*;
public class 대충만든자판 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            Map<Character, Integer> map = new HashMap<>();
            for(String key : keymap){
                for(int i=0; i<key.length(); i++){
                    if(map.get(key.charAt(i)) != null){
                        map.put(key.charAt(i), Math.min(map.get(key.charAt(i)), i+1));
                    }else{
                        map.put(key.charAt(i), i+1);
                    }
                }
            }
            int[] answer = new int[targets.length];
            for(int i=0; i<answer.length; i++){
                boolean flag = true;
                int sum = 0;
                for(char key : targets[i].toCharArray()){
                    if(map.get(key) == null){
                        flag = false;
                        break;
                    }
                    sum += map.get(key);
                }
                if(flag){
                    answer[i] = sum;
                }else {
                   answer[i] = -1; 
                }
                
            }
            return answer;
        }
    }
}
