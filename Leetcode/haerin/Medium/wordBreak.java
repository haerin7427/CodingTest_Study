package Leetcode.haerin.Medium;
// https://leetcode.com/problems/word-break/description/
// title : 139. Word Break
// type : DP
// time : 15m
// created by haerin on 2023-06-01
import java.util.*;
public class wordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length()];
            // dp[i]는 s.substring(0,i+1)이 true/false 저장
    
            for(int i=0; i<dp.length; i++) {
                for(int j=0; j<=i; j++) {
                    if( (j==0 || dp[j-1]) && wordDict.contains(s.substring(j, i+1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()-1];
        }
    }
}
