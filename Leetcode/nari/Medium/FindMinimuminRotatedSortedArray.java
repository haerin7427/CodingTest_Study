// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// title : 153. Find Minimum in Rotated Sorted Array
// time taken : 9 m 37 s

public class FindMinimuminRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int len = nums.length;

            if(len == 1 || nums[0] < nums[len-1]) return nums[0];

            int left = 0, right = len-1;

            while(left < right) {
                int mid = (left+right) / 2;

                // mid에 위치한 값이 left보다 크거나 같고,
                // left에 위치한 값이 right보다 큰 경우 -> mid보다 뒷 편에 최솟값 존재 -> left 이동
                if(nums[left] <= nums[mid] && nums[left] > nums[right]) left = mid+1;
                else right = mid;
            }

            return nums[left];
        }
    }
}
