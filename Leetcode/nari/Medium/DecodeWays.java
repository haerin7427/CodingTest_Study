// https://leetcode.com/problems/decode-ways/
// title : 91. Decode Ways
// time taken : 33 m 38 s

public class DecodeWays {
    class Solution {
        public int numDecodings(String s) {
            int len = s.length();
            int[] dp = new int[len+1];

            dp[0] = 1;
            // 0이 아닌 경우, 1개의 숫자로 변환 가능
            dp[1] = s.charAt(0) == '0' ? 0 : 1;

            for(int i=2;i<=len;i++) {
                // i-1 위치에 문자가 0이 아닌 경우, 1개의 숫자로 변환 가능
                if(s.charAt(i-1) != '0') dp[i] += dp[i-1];

                // i-2 위치부터 2자리 수가 10 이상 26 이하인 경우, 숫자 변환 가능
                int num = Integer.valueOf(s.substring(i-2, i));
                if(10 <= num && num <= 26) dp[i] += dp[i-2];
            }

            return dp[len];
        }
    }
}
