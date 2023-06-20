// https://leetcode.com/problems/palindromic-substrings/
// title : 647. Palindromic Substrings
// time taken : 

public class PalindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            int len = s.length();
            int cnt = len;

            for(int i=2;i<=len;i++) {
                for(int j=0;j<=len-i;j++) {
                    String substr = s.substring(j, j+i);

                    if(check(substr)) cnt++;
                }
            }

            return cnt;
        }

        private boolean check(String s) {
            int left = 0, right = s.length()-1;
            
            while(left < right) {
                if(s.charAt(left) != s.charAt(right)) return false;

                left++;
                right--;
            }
            
            return true;
        }
    }
}
