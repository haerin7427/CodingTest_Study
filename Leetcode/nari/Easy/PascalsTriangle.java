// https://leetcode.com/problems/pascals-triangle/
// title : 118. Pascal's Triangle

import java.util.*;

public class PascalsTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<>();

            if(numRows == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(1);
                list.add(l);

                return list;
            }

            int[][] dp = new int[numRows][numRows];

            dp[0][0] = 1;
            dp[1][0] = 1;
            dp[1][1] = 1;

            for(int i=2;i<numRows;i++) {
                dp[i][0] = 1;

                for(int j=1;j<i;j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }

                dp[i][i] = 1;
            }

            for(int[] arr : dp) {
                List<Integer> l = new ArrayList<>();

                for(int i : arr) {
                    if(i == 0) break;

                    l.add(i);
                }
                
                list.add(l);
            }

            return list;
        }
    }
}
