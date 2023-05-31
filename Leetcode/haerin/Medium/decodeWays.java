package Leetcode.haerin.Medium;
// https://leetcode.com/problems/decode-ways/description/
// title : 91. Decode Ways
// type : DP
// time : 18m
// Creaeted by haerin on 2023-05-31
public class decodeWays {
    class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[s.length()+1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for(int i=2; i<dp.length; i++){
                if(s.charAt(i-1) != '0') {
                    dp[i] = dp[i-1];
                }
                if(s.charAt(i-2) != '0' && Integer.parseInt(s.substring(i-2, i)) <= 26) {
                    dp[i] += dp[i-2];
                }
            }
            return dp[s.length()];
        }
    }
}
