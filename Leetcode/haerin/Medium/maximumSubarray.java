package Leetcode.haerin.Medium;
// https://leetcode.com/problems/maximum-subarray/description/
// title : 53. Maximum Subarray
// type : Kadane's algorithm (카다네 알고리즘)
// time : 10m
// Created by haerin on 2023-05-16
public class maximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++){
                sum += nums[i];
                max = Math.max(max, sum);
                if(sum < 0){
                    sum = 0;
                }
            }
            return max;
        }
    }
}
