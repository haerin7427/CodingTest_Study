// https://leetcode.com/problems/word-break/
// title : 139. Word Break
// time taken : 

public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length();
            boolean[] dp = new boolean[len];

            for(int i=0;i<len;i++) {
                for(int j=0;j<=i;j++) {
                    if((j==0 || dp[j-1]==true) && wordDict.contains(s.substring(j, i+1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[len-1];
        }
    }
}
