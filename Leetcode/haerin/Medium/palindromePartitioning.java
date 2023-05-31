package Leetcode.haerin.Medium;
// https://leetcode.com/problems/palindrome-partitioning/description/
// title : 131. Palindrome Partitioning
// type : Backtracking
// time : 24m
// Created by haerin on 2023-05-31
import java.util.*;
public class palindromePartitioning {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> answer = new ArrayList<>();
            helper(s, 0, new ArrayList<>(), answer);
            return answer;
        }
    
        private void helper (String s, int idx, List<String> tmp, List<List<String>> answer){
            if(s.isEmpty()) {
                answer.add(new ArrayList<>(tmp));
                return;
            }
    
            for(int i=0; i<s.length(); i++){
                String cur = s.substring(0, i+1);
                if(isPalindrome(cur)){
                    tmp.add(cur);
                    helper(s.substring(i+1), idx+1, tmp, answer);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
        private boolean isPalindrome(String str) {
            int start = 0;
            int end = str.length() - 1;
    
            while(start <= end) {
                if(str.charAt(start++) != str.charAt(end--)) return false;
            }
            return true;
        }
    }
}
