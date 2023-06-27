package Leetcode.haerin.Medium;
// https://leetcode.com/problems/house-robber-ii/
// title : 213. House Robber II
// type : DP
// time : ...
// created by haerin on 2023-06-27
public class houseRobber2 {
    class Solution {
        public int rob(int[] nums) {
            int N = nums.length;
            if(N == 1) {
                return nums[0];
            }else if(N == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int[] dp1 = new int[N];
            int[] dp2 = new int[N];
    
            dp1[0] = nums[0];
            dp2[0] = 0;
            dp1[1] = Math.max(dp1[0], nums[1]);
            dp2[1] = Math.max(dp2[0], nums[1]);
            for(int i=2; i<N-1; i++){
                dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
                dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
            }
    
            dp1[N-1] = dp1[N-2];
            dp2[N-1] = Math.max(dp2[N-3] + nums[N-1], dp2[N-2]);
            
            return Math.max(dp1[N-1], dp2[N-1]);
        }
    }
}
