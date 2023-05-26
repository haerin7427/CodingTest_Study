package Leetcode.haerin.Easy;
// https://leetcode.com/problems/min-cost-climbing-stairs/description/
// title : 746. Min Cost Climbing Stairs
// type : DP
// time : 4m
// Created by haerin on 2023-05-25
public class minCostClimbingStairs {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length+1];
            dp[0] = 0; dp[1] = 0;
            for(int i=2; i<dp.length; i++){
                dp[i] = Math.min(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1]);
            }
            return dp[cost.length];
        }
    }
}
