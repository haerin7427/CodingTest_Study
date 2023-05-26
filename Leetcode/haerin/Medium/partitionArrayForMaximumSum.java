package Leetcode.haerin.Medium;
// https://leetcode.com/problems/partition-array-for-maximum-sum/
// title : 1043. Partition Array for Maximum Sum
// type : DP
// time : 10m
// Created by haerin on 2023-05-26
public class partitionArrayForMaximumSum {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int N = arr.length; 
            int[] dp = new int[N+1];
    
            for(int i=1; i<=N; i++){
                int max = 0, val = dp[i-1]+arr[i-1];
                // 마지막 부분집합의 합이 제일 커지는 구간을 찾는다.
                for(int j=1; j<=Math.min(i,k); j++){
                    max = Math.max(max, arr[i-j]);
                    val = Math.max(dp[i-j]+max*j, val);
                }
                dp[i] = val;
            }
            return dp[N];
            
        }
    }
}
