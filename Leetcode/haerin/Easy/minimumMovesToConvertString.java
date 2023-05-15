package Leetcode.haerin.Easy;
// https://leetcode.com/problems/minimum-moves-to-convert-string/description/
// title : 2027. Minimum Moves to Convert String
// type : Greedy
// time : 10m
// Created by haerin on 2023-05-15
public class minimumMovesToConvertString {
    class Solution {
        public int minimumMoves(String s) {
            int answer = 0;
            int end = -1;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == 'X' && i > end){
                    answer += 1;
                    end = i + 2;
                }
            }
            return answer;
        }
    }
}
