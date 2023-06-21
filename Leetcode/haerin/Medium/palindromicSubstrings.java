package Leetcode.haerin.Medium;
// https://leetcode.com/problems/palindromic-substrings/description/
// title : 647. Palindromic Substrings
// type : ...
// time : 8m
// created by haerin on 2023-06-20
public class palindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            int cnt = 0;
            for(int start = 0; start < s.length(); start++){
                for(int end = start+1; end <=s.length(); end++){
                    if(isPalindromic(s.substring(start, end))){
                        cnt += 1;
                    }
                }
            }
            return cnt;
        }
    
        private boolean isPalindromic(String s) {
            for(int i=0; i<s.length()/2; i++){
                int a = s.length() - 1 - i;
                if(s.charAt(i) != s.charAt(a)){
                    return false;
                }
            }
            return true;
        }
    }
}
