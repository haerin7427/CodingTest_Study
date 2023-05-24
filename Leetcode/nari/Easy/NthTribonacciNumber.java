// https://leetcode.com/problems/n-th-tribonacci-number/
// title : 1137. N-th Tribonacci Number
// time taken : 33 m 38 s

public class NthTribonacciNumber {
    class Solution {
        public int tribonacci(int n) {
            if(n < 2) return n;
            if(n == 2) return 1;

            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;

            for(int i=3;i<=n;i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            return dp[n];
        }
    }
}
