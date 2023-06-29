package Leetcode.haerin.Easy;
// https://leetcode.com/problems/is-subsequence/
// title : 392. Is Subsequence
// time : 3m
// type : ...
// created by haerin on 2023-06-27
public class isSubsequence {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length() == 0) return true;
            int target = 0;
            for(int i=0; i<t.length(); i++){
                if(s.charAt(target) == t.charAt(i)){
                    if(target == s.length()-1) {
                        return true;
                    } else {
                        target += 1;
                    }
                }
            }
            return false;
        }
    }
}
