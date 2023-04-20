// https://school.programmers.co.kr/learn/courses/30/lessons/181187
// title : 두 원 사이의 정수 쌍

// 피타고라스의 식 -> x^2+y^2 = r^2
// r은 문제에서 주었고, X를 0~r까지 탐색 -> 가정하면, y의 갯수가 추정 가능

public class 두원사이의정수쌍 {
    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;
            
            // r1 < r2
            for(int i=1;i<=r2;i++) {
                long R1 = (long) Math.pow(r1, 2);
                long R2 = (long) Math.pow(r2, 2);
                long I = (long) Math.pow(i, 2);
                
                // 테두리까지 확인
                // 올림
                long min = (int) Math.ceil(Math.sqrt(R1 - I));
                // 내림
                long max = (int) Math.floor(Math.sqrt(R2 - I));
    
                answer += (max - min + 1);
            }
            
            return answer * 4;
        }
    }
}