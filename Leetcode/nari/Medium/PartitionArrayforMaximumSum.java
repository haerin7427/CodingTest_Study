// https://leetcode.com/problems/partition-array-for-maximum-sum/
// title : 1043. Partition Array for Maximum Sum
// time taken : 33 m 38 s

public class PartitionArrayforMaximumSum {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int len = arr.length;
            int[] dp = new int[len+1];

            for(int i=1;i<=len;i++) {
                int max = 0, val = 0;
                int min = Math.min(i, k);

                for(int j=1;j<=min;j++) {
                    // j 구간안에서 max값 구하기
                    max = Math.max(max, arr[i-j]);
                    // val vs j 구간 바로 전 값과 max값을 j 구간만큼 곱한 값을 더한 값
                    val = Math.max(val, dp[i-j] + max*j);
                }

                dp[i] = val;
            }

            return dp[len];
        }
    }
}
