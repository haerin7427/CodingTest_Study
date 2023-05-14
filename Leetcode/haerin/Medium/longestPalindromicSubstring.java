package Leetcode.haerin.Medium;
// https://leetcode.com/problems/longest-palindromic-substring/description/
// title : 5. Longest Palindromic Substring
// type : Greedy
// time : 20m
// Created by haerin on 2023-05-14
public class longestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            String answer = new String();
            for(int len = s.length(); len > 0; len--){
                for(int idx=0; idx + len <= s.length(); idx++){
                    if(isPalindrome(s, idx, idx+len)){
                        return s.substring(idx, idx+len);
                    }
                }
            }
            return answer;
        }
        private boolean isPalindrome(String s, int a, int b){
            String str = s.substring(a,b);
            int left = 0;
            int right = str.length()-1;
    
            while(left <= right){
                if(str.charAt(left) != str.charAt(right)) return false;
                left += 1;
                right -= 1;
            }
            return true;
        }
    }
}
