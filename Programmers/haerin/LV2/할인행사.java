package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/131127
// title : 할인 행사
// type : HashMap
// time : 20m
// Created by haerin on 2023-02-22
import java.util.*;
public class 할인행사 {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            Map<String, Integer> wantMap = new HashMap<>();
            for(int i=0; i<want.length; i++){
                wantMap.put(want[i], number[i]);
            }
            
            int answer = 0;
            for(int i=0; i<=discount.length-10; i++){
                Map<String, Integer> discountMap = new HashMap<>();
                for(int j=i; j<i+10; j++){
                    if(j >= discount.length) break;
                    discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0)+1);
                }
                
                
                boolean flag = true;
                for(String key : wantMap.keySet()){
                    if(discountMap.get(key) == null || discountMap.get(key)<wantMap.get(key)){
                        flag = false;
                        break;
                    }
                }
                if(flag) answer += 1;
            }
            return answer;
        }
    }
}
