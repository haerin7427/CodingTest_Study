// https://leetcode.com/problems/house-robber-ii/
// title : 213. House Robber II
// time taken : 

public class HouseRobberII {
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            int max1 = 0, max2 = 0;
            
            if(len == 1) return nums[0];

            int temp1 = 0, temp2 = nums[0];
            for(int i=1;i<len-1;i++) {
                int temp = Math.max(nums[i]+temp1, temp2);

                temp1 = temp2;
                temp2 = temp;
            }
            max1 = temp2;

            temp1 = 0;
            temp2 = nums[1];
            for(int i=2;i<len;i++) {
                int temp = Math.max(nums[i]+temp1, temp2);

                temp1 = temp2;
                temp2 = temp;
            }
            max2 = temp2;

            return Math.max(max1, max2);
        }
    }
}
