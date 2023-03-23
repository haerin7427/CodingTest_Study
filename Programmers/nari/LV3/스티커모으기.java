// https://school.programmers.co.kr/learn/courses/30/lessons/12971
// title : 스티커 모으기(2)

public class 스티커모으기 {
    class Solution {
        public int solution(int sticker[]) {
            int answer = 0;
            int length = sticker.length;
            
            // 예외 처리 -> 하지 않을 경우, 에러
            if(length == 1) return sticker[0];

            int[] dp1 = new int[length];
            int[] dp2 = new int[length];
            
            // 첫번째 스티커를 떼는 방법
            dp1[0] = sticker[0];
            dp1[1] = sticker[0];
            for(int i=2;i<length-1;i++) {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
            }
            
            // 첫번째 스티커를 뗴지 않는 방법
            dp2[0] = 0;
            dp2[1] = sticker[1];
            for(int i=2;i<length;i++) {
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
            }

            answer = Math.max(dp1[length-2], dp2[length-1]);

            return answer;
        }
    }
}