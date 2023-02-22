// https://school.programmers.co.kr/learn/courses/30/lessons/131127
// title : 할인 행사

import java.util.*;

public class 할인행사 {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            // 정현이가 원하는 제품들의 총 수량
            int total = 0;
            // 정현이가 원하는 제품, 수량
            HashMap<String, Integer> wantMap = new HashMap<>();
            // wantMap과 disMap이 동일한지
            boolean isSame = true;
            
            // wantMap 채우기 + 정현이가 원하는 제품들의 총 수량 구하기
            for(int i=0;i<number.length;i++) {
                wantMap.put(want[i], number[i]);
                total += number[i];
            }
            
            // discount에서 총 수량 뺀 만큼 반복
            for(int i=0;i<=discount.length-total;i++) {
                HashMap<String, Integer> disMap = new HashMap<>();
                
                // i부터 total만큼 반복 -> 해당 index의 discount를 disMap에 제품 이름, 수량 담기
                for(int j=i;j<total+i;j++) {
                    disMap.put(discount[j], disMap.getOrDefault(discount[j], 0) + 1);
                }
                
                // wantMap와 disMap 비교
                for(String key : wantMap.keySet()) {
                    if(!disMap.containsKey(key) || wantMap.get(key) != disMap.get(key)) {
                        isSame = false;
                        break;
                    }
                }
                
                if(isSame) answer++;
                else isSame = true;
            }
            
            return answer;
        }
    }
}