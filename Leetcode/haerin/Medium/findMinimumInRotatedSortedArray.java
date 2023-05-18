package Leetcode.haerin.Medium;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// title : 153. Find Minimum in Rotated Sorted Array
// type : 이분탐색
// time : 11m
// Created by haerin on 2023-05-16
public class findMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            int answer = 5001;
            while(left <= right){
                int mid = (left + right)/2;
    
                if(answer > nums[mid]){
                    answer = nums[mid];
                }
    
                if(nums[left] < nums[mid] && nums[mid] < nums[right]){
                    right = mid -1;
                }else if(nums[mid] < nums[left] && nums[mid] < nums[right]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
                
            }
            return answer;
        }
    }
}
