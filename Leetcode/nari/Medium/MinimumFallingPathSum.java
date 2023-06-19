// https://leetcode.com/problems/minimum-falling-path-sum/
// title : 931. Minimum Falling Path Sum
// time taken : 

public class MinimumFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];
            int min = Integer.MAX_VALUE;

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    // 첫째줄인 경우, 처음 값 그대로 넣기
                    if(i == 0) dp[i][j] = matrix[i][j];
                    else {
                        // 위에 값 3개를 비교해서 최솟값 더하기
                        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                        int mid = matrix[i][j] + dp[i-1][j];
                        
                        if(j > 0) left = matrix[i][j] + dp[i-1][j-1];
                        if(j < n-1) right = matrix[i][j] + dp[i-1][j+1];

                        dp[i][j] = Math.min(mid, Math.min(left, right));
                    }

                    // 마지막 줄인 경우, 최솟값 찾기
                    if(i == n-1) min = Math.min(dp[i][j], min);
                }
            }

            return min;
        }
    }
}
