// https://leetcode.com/problems/triangle/
// title : 120. Triangle
// time taken : 

import java.util.*;

public class Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int len = triangle.size();
            int[][] dp = new int[len][len];
            int min = Integer.MAX_VALUE;

            dp[0][0] = triangle.get(0).get(0);

            for(int i=1;i<len;i++) {
                // triangle[i][j] <= 10^4
                Arrays.fill(dp[i], 10001);

                dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);

                for(int j=1;j<i;j++) {
                    dp[i][j] = Math.min(dp[i-1][j-1]+triangle.get(i).get(j), dp[i-1][j]+triangle.get(i).get(j));
                }

                dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
            }

            for(int i : dp[len-1]) {
                if(min > i) min = i;
            }

            return min;
        }
    }
}
