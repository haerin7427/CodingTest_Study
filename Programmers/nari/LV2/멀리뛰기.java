// https://school.programmers.co.kr/learn/courses/30/lessons/12914
// title : 멀리 뛰기

public class 멀리뛰기 {
    class Solution {
        public long solution(int n) {
            // Dynamic_Programming
            // 피보나치 수열 -> x[n] = x[n-2] + x[n-1]
            // 1 - 1 - 2 - 3 - 5 - 8 - 13
            if(n==1) return 1;
            
            long[] dp = new long[n];
            dp[0] = 1;
            dp[1] = 2;
            
            for(int i=2;i<n;i++) {
                dp[i] += (dp[i-1] + dp[i-2]) % 1234567;
            }
            
            return dp[n-1];
        }
    }
}