package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/17677
// title : [1차] 뉴스 클러스터링
// type : 문자열
// time : 28m
// Created by haerin on 2023-02-14
import java.util.*;
public class 일차뉴스클러스터링 {
    class Solution {
        public int solution(String str1, String str2) {
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();
            
            float intersection=0.0f, union=0.0f;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<str1.length()-1; i++){
                if(!str1.substring(i, i+2).matches("^[a-z]*$")) continue;
                union += 1;
                map.put(str1.substring(i, i+2), map.getOrDefault(str1.substring(i, i+2), 0) + 1);
            }
            
            for(int i=0; i<str2.length()-1; i++){
                String key = str2.substring(i, i+2);
                if(!key.matches("^[a-z]*$")) continue;
                if(map.get(key) != null && map.get(key) > 0){
                    map.put(key, map.get(key)-1);
                    intersection += 1;
                }else{
                    union += 1;
                }
            }
            if(union == 0.0f){
                union += 1;
                intersection += 1;
            }
                
            int answer = (int)(intersection / union * 65536);
            return answer;
        }
    }
}
