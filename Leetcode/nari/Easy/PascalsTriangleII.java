// https://leetcode.com/problems/pascals-triangle-ii/
// title : 119. Pascal's Triangle II
// time taken : 9 m 38 s

import java.util.*;

public class PascalsTriangleII {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<>();

            if(rowIndex == 0) {
                list.add(1);

                return list;
            }
            if(rowIndex == 1) {
                list.add(1);
                list.add(1);

                return list;
            }

            int[][] dp = new int[rowIndex+1][rowIndex+1];

            dp[0][0] = 1;
            dp[1][0] = 1;
            dp[1][1] = 1;

            for(int i=2;i<=rowIndex;i++) {
                dp[i][0] = 1;

                for(int j=0;j<i;j++) {
                    dp[i][j+1] = dp[i-1][j] + dp[i-1][j+1];
                }

                dp[i][i] = 1;
            }

            for(int i : dp[rowIndex]) {
                list.add(i);
            }

            return list;
        }
    }
}
