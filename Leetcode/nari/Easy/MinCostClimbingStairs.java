// https://leetcode.com/problems/min-cost-climbing-stairs/
// title : 746. Min Cost Climbing Stairs
// time taken : 3 m 9 s

public class MinCostClimbingStairs {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            int[] dp = new int[len];

            // cost의 최소길이 2
            dp[0] = cost[0];
            dp[1] = cost[1];

            for(int i=2;i<len;i++) {
                dp[i] = Math.min(dp[i-1] , dp[i-2]) + cost[i];
            }

            return Math.min(dp[len-1] , dp[len-2]);
        }
    }
}
