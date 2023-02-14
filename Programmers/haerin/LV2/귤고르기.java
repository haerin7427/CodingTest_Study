package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/138476
// title : 귤 고르기
// type : 정렬 & 그리디
// time : 15m
// Created by haerin on 2023-02-13
import java.util.*;;
public class 귤고르기 {
    class Solution {
        public int solution(int k, int[] tangerine) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<tangerine.length; i++){
                map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
            }
            
            List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));
            int answer = 0;
            int sum = 0;
            for(Map.Entry<Integer, Integer> list : entryList){
                sum += list.getValue();
                answer += 1;
                if(sum >= k){
                    break;
                }
            }
            return answer;
        }
    }
}
