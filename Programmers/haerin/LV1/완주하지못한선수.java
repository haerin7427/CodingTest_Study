// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// title : 완주하지 못한 선수
// type : HashMap
// time : 6m
// Created by haerin on 2023-02-03
import java.util.*;
public class 완주하지못한선수 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> record = new HashMap<>();
            for(String p : participant){
                record.put(p, record.getOrDefault(p, 0)+1);
            }
            for(String p : completion){
                record.put(p, record.get(p)-1);
            }
            for(String key : record.keySet()) {
                if(record.get(key) != 0) {
                    return key;
                }
            }
            
            return "";
        }
    }
}
