// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// title : 1614. Maximum Nesting Depth of the Parentheses
// time taken : 

public class MaximumNestingDepthoftheParentheses {
    class Solution {
        public int maxDepth(String s) {
            int cnt = 0, max = 0;
            int len = s.length();

            for(int i=0;i<len;i++) {
                char ch = s.charAt(i);

                if(ch == '(') cnt++;
                else if(ch == ')') max = Math.max(max, cnt--);
            }

            return max;
        }
    }
}
