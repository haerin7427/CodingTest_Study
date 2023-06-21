package Leetcode.haerin.Medium;
// https://leetcode.com/problems/construct-smallest-number-from-di-string/
// title : 2375. Construct Smallest Number From DI String
// type : stack
// time : 15m
// created by haerin on 2023-06-20
public class constructSmallestNumberFromDIString {
    class Solution {
        public String smallestNumber(String pattern) {
            
            StringBuilder sb = new StringBuilder();
            StringBuilder tmp = new StringBuilder();
            char ch = '1';
            for(int i=0; i<pattern.length(); i++) {
                char cur = pattern.charAt(i);
                tmp.append(ch++);
                if(cur == 'I'){
                    sb.append(tmp.reverse());
                    tmp = new StringBuilder();
                }
            }
            tmp.append(ch++);
            sb.append(tmp.reverse());
            return sb.toString();
        }
        
    }
}
