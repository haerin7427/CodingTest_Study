package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/72411
// title : 메뉴리뉴얼
// type : 조합 & HashMap
// time : ...
// Created by haerin on 2023-02-27
import java.util.*;
public class 메뉴리뉴얼 {
    class Solution {
        public Map<String, Integer> map;
        public int maxCnt = 0;
        
        public String[] solution(String[] orders, int[] course) {
            List<String> list = new ArrayList<>();
            for(int len : course){
                map = new HashMap<>();
                maxCnt = 0;
                
                for(String order : orders){
                    char[] arr = order.toCharArray();
                    Arrays.sort(arr);
                    order = String.valueOf(arr);
                    getCombination("", order, len);
                }
                if(maxCnt > 1){
                    for(String key : map.keySet()){
                        if(map.get(key) == maxCnt){
                            list.add(key);
                        }
                    }
                }
                
            }
            Collections.sort(list);
            String[] answer = new String[list.size()];
            int idx = 0;
            for(String s : list){
                answer[idx++] = s;
            }
            
            return answer;
        }
        
        public void getCombination(String order, String others, int requireLen){
            if(requireLen == 0){
                map.put(order, map.getOrDefault(order, 0)+1);
                maxCnt = Math.max(maxCnt, map.get(order));
                return ;
            }
            
            for(int i=0; i < others.length(); i++){
                getCombination(order+others.charAt(i), others.substring(i+1), requireLen-1);
            }
        }
    }
}
