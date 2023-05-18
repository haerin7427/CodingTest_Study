// https://leetcode.com/problems/unique-binary-search-trees/
// title : 96. Unique Binary Search Trees
// time taken : -

public class UniqueBinarySearchTrees {
    class Solution {
        public int numTrees(int n) {
            if(n == 1) return 1;

            int[] dp = new int[n+1];

            dp[0] = 1;
            dp[1] = 1;

            for(int i=2;i<=n;i++) {
                int left = 0, right = i-1;

                while(left <= (i-1)) {
                    dp[i] += dp[left] * dp[right];

                    left++;
                    right--;
                }
            }

            return dp[n];
        }
    }
}
