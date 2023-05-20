package Leetcode.haerin.Easy;
// https://leetcode.com/problems/counting-bits/description/
// title : 338. Counting Bits
// type : 문자열
// time : 2m
// Created by haerin on 2023-05-19
public class countingBits {
    class Solution {
        public int[] countBits(int n) {
            int[] answer = new int[n+1];
            for(int i=0; i<=n; i++){
                String s = Integer.toString(i,2);
                answer[i] = s.replaceAll("[^1]","").length();
            }
            return answer;
        }
    }
}
