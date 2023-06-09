// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
// title : 2044. Count Number of Maximum Bitwise-OR Subsets
// time taken : 

public class CountNumberofMaximumBitwiseORSubsets {
    class Solution {
        int[] Nums;
        int len;
        int max = 0, cnt = 0;

        public int countMaxOrSubsets(int[] nums) {
            Nums = nums;
            len = nums.length;

            for(int i=1;i<=len;i++) {
                backtracking(0, 0, 0, i);
            }

            return cnt;
        }

        private void backtracking(int idx, int or, int size, int limit) {
            if(size == limit) {
                if(or == max) cnt++;
                else if(or > max) {
                    max = or;
                    cnt = 1;
                }

                return;
            }

            for(int i=idx;i<len;i++) {
                backtracking(i+1, or | Nums[i], size+1, limit);
            }
        }
    }
}