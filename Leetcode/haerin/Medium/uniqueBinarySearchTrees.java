package Leetcode.haerin.Medium;
// https://leetcode.com/problems/unique-binary-search-trees/description/
// title : 96. Unique Binary Search Trees
// type : DP
// time : 30m
// Created by haerin on 2023-05-18
public class uniqueBinarySearchTrees {
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
    
            for(int i=1; i<=n; i++){
                for(int j=0; j<i; j++){
                    // j 는 left node 개수, i-j-1는 right node 개수 (1은 root node)
                    dp[i] += dp[j] * dp[i-j-1];
                }
            }
            return dp[n];
        }
    }
}
