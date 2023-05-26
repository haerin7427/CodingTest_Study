package Leetcode.haerin.Easy;
// https://leetcode.com/problems/get-maximum-in-generated-array/
// title : 1646. Get Maximum in Generated Array
// type : DP
// time : 3m
// Created by haerin on 2023-05-26
public class getMacimumInGeneratedArray {
    class Solution {
        public int getMaximumGenerated(int n) {
            if(n < 2){
                return n;
            }
            int max = 0;
            int[] dp = new int[n+1];
            dp[0] = 0; dp[1] = 1;
            for(int i=2; i<=n; i++){
                dp[i] = dp[i/2];
                if(i % 2 == 1){
                    dp[i] += dp[i/2+1];
                }
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }
}
