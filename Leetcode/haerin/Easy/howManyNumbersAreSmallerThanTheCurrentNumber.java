package Leetcode.haerin.Easy;
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
// title : 1365. How Many Numbers Are Smaller Than the Current Number
// type : For
// time : 15m
// created by haerin on 2023-06-28
public class howManyNumbersAreSmallerThanTheCurrentNumber {
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] ans = new int[nums.length];
            for(int i=0; i<nums.length; i++) {
                int count = 0;
                for(int j=0; j<nums.length; j++) {
                    if(i == j) continue;
                    if(nums[i] > nums[j]) {
                        count += 1;
                    }
                }
                ans[i] = count;
            }
            return ans;
        }
    }
}
