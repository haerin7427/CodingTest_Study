package Leetcode.haerin.Medium;
// https://leetcode.com/problems/jump-game/description/
// title : 55. Jump Game
// type : DP
// time : 10m
// Creatd by haerin on 2023-05-19
public class jumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            if(nums.length == 1){
                return true;
            }
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            for(int i=1; i<nums.length; i++){
                dp[i] = minJump(i, nums, dp);
            }
            return dp[nums.length-1];
        }
    
        private boolean minJump(int index, int[] nums, boolean[] isPossible){
            for(int j = 0; j<index; j++){
                if(!isPossible[j]) continue;
                if(j + nums[j] >= index){
                    return true;
                }
            }
            return false;
        }
    }
}
