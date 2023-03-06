// https://school.programmers.co.kr/learn/courses/30/lessons/150369
// title : 택배 배달과 수거하기

public class 택배배달과수거하기 {
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            int delivery = 0, pickup = 0;
            
            // 제일 먼 곳부터 우선으로
            for(int i=n-1;i>=0;i--) {
                // 배달이 있거나 수거가 있는 경우
                if(deliveries[i] != 0 || pickups[i] != 0) {
                    int cnt = 0;
                    
                    while(delivery < deliveries[i] || pickup < pickups[i]) {
                        cnt++;
                        delivery += cap;
                        pickup += cap;
                    }
                    
                    delivery -= deliveries[i];
                    pickup -= pickups[i];
                    answer += (i+1) * cnt * 2;
                }
            }
            
            return answer;
        }
    }
}