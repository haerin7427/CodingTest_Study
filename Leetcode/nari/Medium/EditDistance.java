// https://leetcode.com/problems/edit-distance/
// title : 72. Edit Distance
// time taken : 

public class EditDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length(), len2 = word2.length();

            if(len1 == 0) return len2;
            if(len2 == 0) return len1;

            int[][] dp = new int[len1+1][len2+1];

            for(int i=0;i<=len1;i++) {
                dp[i][0] = i;
            }

            for(int i=1;i<=len2;i++) {
                dp[0][i] = i;
            }

            for(int i=1;i<=len1;i++) {
                for(int j=1;j<=len2;j++) {
                    if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    // replace = dp[i-1][j-1], delete = dp[i-1][j], insert = dp[i][j-1]
                    else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }

            return dp[len1][len2];
        }
    }
}
