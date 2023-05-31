package Leetcode.haerin.Easy;
// https://leetcode.com/problems/sum-of-all-subset-xor-totals/
// title : 1863. Sum of All Subset XOR Totals
// type : recursive
// time : 20m
// Created by haerin on 2023-05-30
public class sumOfAllSubsetXORTotals {
    class Solution {
        public int subsetXORSum(int[] nums) {
            return getSum(nums, 0, 0);
        }
        private int getSum(int[] nums, int i, int cur) {
            if(i == nums.length) {
                return cur;
            }
            // num[i]를 XOR 연산 하는 경우와 하지 않는 경우
            return getSum(nums, i+1, cur^nums[i]) + getSum(nums, i+1, cur);
        }
    }
}
