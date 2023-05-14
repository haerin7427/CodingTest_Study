// https://leetcode.com/problems/longest-palindromic-substring/
// title : 5. Longest Palindromic Substring
// time taken : 33 m 38 s

public class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();

            // 최대 길이부터
            for(int i=len;i>0;i--) {
                for(int j=0;j<len;j++) {
                    if(len-j < i) break;

                    // 구간 : j부터 j+i-1까지
                    // 길이가 짝수인 경우, 홀수인 경우 각각
                    int idx1 = (i/2 - 1) + j;
                    int idx2 = i%2 == 0 ? (i/2) + j : (i/2 + 1) + j;

                    while(idx1 >= 0 && idx2 < len && s.charAt(idx1) == s.charAt(idx2)) {
                        idx1--;
                        idx2++;
                    }

                    idx1++;

                    if(idx2 - idx1 == i) return s.substring(idx1, idx2);
                }            
            }

            return s;
        }
    }
}
