// https://school.programmers.co.kr/learn/courses/30/lessons/12902
// title : 3 x n 타일링

public class 3xn타일링 {
    class Solution {
        public int solution(int n) {
            // n=1 -> 2가지
            // n=2 -> 3가지
            // n=3 -> 2일 때 패턴에 1일 때 패턴 붙인 것 (6가지) + 가로로 눕혀서 (2가지)
            // n=4 -> 3일 때 패턴에 2일 때 패턴 붙인 것 (11가지)
            // 가로 길이가 2인 직사각형이기 때문에 n이 홀수일 경우, 완전하게 모든 공간을 채우는건 불가능
            // 규칙
            // n이 홀수일 때: dp[n] = dp[n-1]*2 + dp[n-2];
            // n이 짝수일 때: dp[n] = dp[n-1] + dp[n-2];

            int[] dp = new int[n+1];
            
            dp[1] = 2;
            dp[2] = 3;
            
            for(int i=3;i<=n;i++) {
                // 짝수일 경우
                if(i%2 == 0) dp[i] = (dp[i-1] % 1000000007) + (dp[i-2] % 1000000007);
                // 홀수인 경우
                else dp[i] = ((dp[i-1]*2) % 1000000007) + (dp[i-2] % 1000000007);

                dp[i] = dp[i] % 1000000007;
            }
            
            return dp[n];
        }
    }
}