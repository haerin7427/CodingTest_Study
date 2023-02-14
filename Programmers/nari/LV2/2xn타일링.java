// https://school.programmers.co.kr/learn/courses/30/lessons/12900
// title : 2 x n 타일링

public class 2xn타일링 {
    class Solution {
        public int solution(int n) {
            // n = 1 -> 1개
            // n = 2 -> 2개
            // n = 3 -> 3개
            // n = 4 -> 5개
            // 1 - 2 - 3 - 5 수열 -> 피보나치 수열

            int[] answer = new int[n];
            answer[0] = 1;
            answer[1] = 2;
            
            for (int i=2;i<n;i++) {
                answer[i] = (answer[i-1] + answer[i-2]) % 1000000007;
            }
            
            return answer[n-1];
        }
    }
}