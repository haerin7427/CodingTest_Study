// https://leetcode.com/problems/house-robber/
// title : 198. House Robber
// time taken : 

public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;

            if(len == 1) return nums[0];
            if(len == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

            int[] dp = new int[len];

            dp[0] = nums[0];
            dp[1] = nums[1];

            for(int i=2;i<len;i++) {
                int max = 0;

                for(int j=0;j<i-1;j++) {
                    if(max < dp[j]) max = dp[j];
                }

                dp[i] = nums[i] + max;
            }

            return dp[len-1] > dp[len-2] ? dp[len-1] : dp[len-2];
        }
    }
}
