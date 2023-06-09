// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
// title : 1130. Minimum Cost Tree From Leaf Values
// time taken : 

public class MinimumCostTreeFromLeafValues {
    class Solution {
        int[] Arr;
        int[][] dp;

        public int mctFromLeafValues(int[] arr) {
            Arr = arr;
            int len = arr.length;
            dp = new int[len][len];

            return getMinSum(0, len-1);
        }

        private int getMinSum(int left, int right) {
            if(left >= right) return 0;
            if(dp[left][right] != 0) return dp[left][right];

            int min = Integer.MAX_VALUE;
            
            for(int i=left;i<right;i++) {
                min = Math.min(min, (findMax(left, i)*findMax(i+1,right) + getMinSum(left, i) + getMinSum(i+1, right)));
            }

            return dp[left][right] = min;
        }

        private int findMax(int idx1, int idx2) {
            int max = 0;

            for(int i=idx1;i<=idx2;i++) {
                max = Math.max(max, Arr[i]);
            }

            return max;
        }
    }
}
