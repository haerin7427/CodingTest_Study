// https://leetcode.com/problems/construct-smallest-number-from-di-string/
// title : 2375. Construct Smallest Number From DI String
// time taken : 

public class ConstructSmallestNumberFromDIString {
    class Solution {
        public String smallestNumber(String pattern) {
            int len = pattern.length();
            StringBuilder sb = new StringBuilder(), stack = new StringBuilder();
            char ch = '1';

            for(int i=0;i<len;i++) {
                char cur = pattern.charAt(i);
                stack.append(ch++);

                if(cur == 'I') {
                    sb.append(stack.reverse());
                    stack = new StringBuilder();
                }
            }

            stack.append(ch++);
            sb.append(stack.reverse());

            return sb.toString();
        }
    }
}
