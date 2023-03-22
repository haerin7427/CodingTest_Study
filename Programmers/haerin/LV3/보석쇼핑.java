package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/67258
// title : 보석 쇼핑
// type : 구현
// time : ...
// Created by haerin on 2023-03-21
import java.util.*;
public class 보석쇼핑 {
    // 효율성 테스트 4/15 통과
    class Solution {
        public int[] solution(String[] gems) {
            int[] answer = new int[]{0,100001};
            Set<String> set = new HashSet<>();
            for(String gem : gems){
                set.add(gem);
            }
            for(int s=0; s<gems.length; s++){
                Set<String> hashset = new HashSet<>();
                int e = s;
                for(int i=s; i<gems.length; i++){
                    hashset.add(gems[i]);
                    if(hashset.size() == set.size()){
                        e = i;
                        if(e-s < answer[1]-answer[0]){
                            answer[0] = s+1;
                            answer[1] = e+1;
                        }
                        break;
                    }
                }
                
            }
            return answer;
        }
    }
    class Solution2 {
        public int[] solution(String[] gems) {
            // 보석 종류 확인
            Set<String> set = new HashSet<>();
            for(String gem : gems){
                set.add(gem);
            }
            if(set.size()==1) return new int[]{1,1};
            
            // 가장 짧은 진열대 구간 찾기
            int[] answer = new int[]{0,100001};
            Queue<String> queue = new LinkedList<>();
            Map<String, Integer> map = new HashMap<>();
            
            int idx = 0;
            for (int i = 0; i < gems.length; i++) {
                // 보석 담기
                map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
                queue.add(gems[i]);

                // 첫 번째 순서에 있는 보석이 여러개 담겨 있는 경우, 보석 빼기
                while (map.get(queue.peek()) > 1) {
                    map.put(queue.peek(), map.get(queue.poll()) - 1);
                    idx++;
                }

                // 모든 종류의 보석이 있는 지, 진열대 길이가 이전보다 짧은 지 확인
                if (map.size() == set.size() && answer[1]-answer[0] > (queue.size()-1)) {
                    answer[0] = idx+1;
                    answer[1] = idx+queue.size();
                }
            }
            return answer;
        }
    }
}
