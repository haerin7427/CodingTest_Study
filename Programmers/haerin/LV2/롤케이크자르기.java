package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/132265
// title : 롤케이크 자르기
// type : hashSet & HashMap
// time : 35m
// Created by haerin on 2023-02-27
import java.util.*;
public class 롤케이크자르기 {
    class Solution {
        public int solution(int[] topping) {
            Set<Integer> set = new HashSet<>();
            Map<Integer, Integer> map = new HashMap<>();
            for(int t : topping){
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
            
            int ans = 0;
            for(int i=0; i<topping.length; i++){
                set.add(topping[i]);
                map.put(topping[i], map.get(topping[i])-1);
                if(map.get(topping[i]) == 0){
                    map.remove(topping[i]);
                }            
                if(set.size() == map.size()){
                    ans += 1;
                }
            }
            return ans;
        }
    }
}
