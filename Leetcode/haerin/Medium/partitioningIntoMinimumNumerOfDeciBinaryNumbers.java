package Leetcode.haerin.Medium;
// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/
// title : 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
// type : Greedy
// time : 5m
// Created by haerin on 2023-05-23
public class partitioningIntoMinimumNumerOfDeciBinaryNumbers {
    class Solution {
        public int minPartitions(String n) {
            int max = 0;
            for(char c : n.toCharArray()){
                int num = c - '0';
                if(max < num){
                    max = num;
                }
            }
            return max;
        }
    }
}
