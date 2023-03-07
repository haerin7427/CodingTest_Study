// https://school.programmers.co.kr/learn/courses/30/lessons/152996
// title : 시소 짝꿍

import java.util.*;

public class 시소짝꿍 {
    // 이중 for문 사용
    class Solution1 {
        public long solution(int[] weights) {
            long answer = 0;
            HashSet<int[]> set = new HashSet<>();
            
            // 1. a == b (x2 == x2 / x3 == x3 / x4 == x4)
            // 2. a x 2 == b x 3
            // 3. a x 2 == b x 4
            // 4. a x 3 == b x 4
            
            for(int i=0;i<weights.length-1;i++) {
                for(int j=i+1;j<weights.length;j++) {
                    // hashset에 존재하지 않는 경우
                    if(set.add(new int[]{weights[i], weights[j]})) {
                        if(weights[i] == weights[j]) answer++;
                        else if(weights[i]*2 == weights[j]*3) answer++;
                        else if(weights[i]*3 == weights[j]*2) answer++;
                        else if(weights[i]*2 == weights[j]*4) answer++;
                        else if(weights[i]*4 == weights[j]*2) answer++;
                        else if(weights[i]*3 == weights[j]*4) answer++;
                        else if(weights[i]*4 == weights[j]*3) answer++;
                    }
                    
                }
            }
            
            return answer;
        }
    }

    class Solution2 {
        public long solution(int[] weights) {
            long answer = 0;
            HashMap<Double, Integer> map = new HashMap<>();
                
            // 1. a == b (x2 == x2 / x3 == x3 / x4 == x4)
            // 2. a x 2 == b x 3
            // 3. a x 2 == b x 4
            // 4. a x 3 == b x 4
                
            Arrays.sort(weights);
                
            for(int weight : weights) {
                // 하나의 무게로 나올 수 있는 무게 값
                double d1 = (double) weight;
                double d2 = (weight * 2.0) / 3.0;
                double d3 = (weight * 2.0) / 4.0;
                double d4 = (weight * 3.0) / 4.0;
                
                // 위에서 구한 값이 map에 key로 존재하는지
                if(map.containsKey(d1)) answer += map.get(d1);
                if(map.containsKey(d2)) answer += map.get(d2);
                if(map.containsKey(d3)) answer += map.get(d3);
                if(map.containsKey(d4)) answer += map.get(d4);
                
                map.put(d1, map.getOrDefault(d1, 0) + 1);
            }
            
            return answer;
        }
    }
}