package Leetcode.haerin.Easy;
// https://leetcode.com/problems/climbing-stairs/description/
// title : 70. Climbing Stairs
// type : Dynamic Programming
// time : 3m
// Created by haerin on 2023-05-12
public class climbingStairs {
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1; dp[1] = 1;
            
            for(int i=2; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
}
