package Leetcode.haerin.Easy;
// https://leetcode.com/problems/n-th-tribonacci-number/description/
// title : 1137. N-th Tribonacci Number
// type : DP
// time : 3m
// Created by haerin on 2023-05-24
public class nThTribonacciNumber {
    class Solution {
        public int tribonacci(int n) {
            if(n<2){
                return n;
            }else if(n==2){
                return 1;
            }
            int[] tri = new int[n+1];
            tri[0] = 0; tri[1] = 1; tri[2] = 1;
            for(int i=3;i<=n; i++){
                tri[i] = tri[i-3] + tri[i-2] + tri[i-1];
            }
            return tri[n];
        }
    }
}
