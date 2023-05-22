package Leetcode.haerin.Easy;
// https://leetcode.com/problems/fibonacci-number/description/
// title : 509. Fibonacci Number
// type : dp
// time : 3m
// Created by haerin on 2023-05-22
public class fibonacciNumber {
    class Solution {
        public int fib(int n) {
            if(n < 2) return n;
            int[] fib = new int[n+1];
            fib[0] = 0; fib[1] = 1;
            for(int i=2; i<=n;i++){
                fib[i] = fib[i-1] + fib[i-2];
            }
            return fib[n];
        }
    }
}
