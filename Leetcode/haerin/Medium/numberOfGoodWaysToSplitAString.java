package Leetcode.haerin.Medium;
// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/
// title : 1525. Number of Good Ways to Split a String
// type : HashMap
// time : 10m
// Created by haerin on 2023-06-07
import java.util.*;
public class numberOfGoodWaysToSplitAString {
    class Solution {
        public int numSplits(String s) {
            Map<Character, Integer> rightMap = new HashMap<>();
            Map<Character, Integer> leftMap = new HashMap<>();
    
            for(char word : s.toCharArray()){
                rightMap.put(word, rightMap.getOrDefault(word, 0)+1);
            }
    
            int answer = 0;
            for(int i=0; i<s.length()-1; i++) {
                char word = s.charAt(i);
                leftMap.put(word, leftMap.getOrDefault(word, 0)+1);
                if(rightMap.get(word) > 1){
                    rightMap.put(word, rightMap.get(word)-1);
                }else{
                    rightMap.remove(word);
                }
    
                if(leftMap.size() == rightMap.size()){
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
