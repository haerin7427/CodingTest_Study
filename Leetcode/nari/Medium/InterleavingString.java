// https://leetcode.com/problems/interleaving-string/
// title : 97. Interleaving String
// time taken : 33 m 38 s

public class InterleavingString {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
            boolean dp[] = new boolean[len2+1];

            if(len1 + len2 != len3) return false;

            for(int i=0;i<=len1;i++) {
                for(int j=0;j<=len2;j++) {
                    if(i == 0 && j == 0) dp[j] = true;
                    else if(i == 0) dp[j] = dp[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                    else if(j == 0) dp[j] = dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                    else dp[j] = (dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }

            return dp[len2];
        }
    }
}
