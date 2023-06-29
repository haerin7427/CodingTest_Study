// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
// title : 1365. How Many Numbers Are Smaller Than the Current Number
// time taken : 

public class HowManyNumbersAreSmallerThantheCurrentNumber {
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int len = nums.length;
            int[] result = new int[len];

            for(int i=0;i<len;i++) {
                int cnt = 0;

                for(int j=0;j<len;j++) {
                    if(i == j) continue;

                    if(nums[i] > nums[j]) cnt++;
                }

                result[i] = cnt;
            }

            return result;
        }
    }
}
