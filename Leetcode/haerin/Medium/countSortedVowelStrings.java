package Leetcode.haerin.Medium;
// https://leetcode.com/problems/count-sorted-vowel-strings/description/
// title : 1641. Count Sorted Vowel Strings
// type : dp
// time : 22m
// Created by haerin on 2023-05-23
import java.util.*;
public class countSortedVowelStrings {
    class Solution {
        public int countVowelStrings(int n) {
            // n : 1 -> 1 + 1 + 1 + 1 + 1
            // n : 2 -> (1 + 1 + 1 + 1 + 1) + (1 + 1 + 1 + 1) + (1 + 1 + 1) + (1 + 1) + 1 = 5 + 4 + 3 + 2 + 1
            // n : 3 -> (5 + 4 + 3 + 2 + 1) + (4+3+2+1) + (3+2+1) + (2+1) + 1
            if(n == 1) return 5;
            int[][] dp = new int[n+1][6];
            Arrays.fill(dp[1], 1);
            dp[1][0] = 5;
    
            for(int i=2; i<=n; i++){
                int sum = dp[i-1][0];
                dp[i][1] = dp[i-1][0];
                for(int j=2; j<=5; j++){
                    dp[i][j] = (dp[i][j-1] - dp[i-1][j-1]);
                    sum += dp[i][j];
                }
                dp[i][0] = sum;
            }
            return dp[n][0];
        }
    }
    // 2번째 방법 (memory면에서 앞에 것 보다 나음)
    class Solution2 {
        public int countVowelStrings(int n) {
            int a=1,e=1,i=1,o=1,u=1;
            for(int j=2; j<=n; j++){
                a = a + e + i + o + u;
                e = e + i + o + u;
                i = i + o + u;
                o = o + u;
            }
            return a + e + i + o + u;
        }
    }
}
