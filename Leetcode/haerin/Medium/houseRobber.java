package Leetcode.haerin.Medium;
// https://leetcode.com/problems/house-robber/
// title : 198. House Robber
// type : DP
// time : ...
// created by haerin on 2023-06-27
public class houseRobber {
    class Solution {
        public int rob(int[] nums) {
            int N = nums.length;
            int[] dp = new int[N];
            dp[0] = nums[0];
            if(N > 1) {
                dp[1] = Math.max(dp[0], nums[1]);
            }

            for(int i=2; i<N; i++){
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
            return dp[N-1];
        }
    }
}
