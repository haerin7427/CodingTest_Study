package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12907
// title : 거스름돈
// type : DP
// time : 30m
// Created by haerin on 2023-03-27
public class 거스름돈 {
    class Solution {
        public int solution(int n, int[] money) {
            int[][] dp = new int[money.length+1][n+1];
            for(int i = 1; i < money.length+1; i++){ // 사용할 수 있는 동전의 최대 금액의 index
                for(int j = 0; j < n+1; j++){ // 만들어야 하는 거스름돈 금액
                    if(j == 0)
                        dp[i][j] = 1;
                    else {
                        // 사용할 수 있는 최대 동전 값보다 거스름돈의 금액이 작은 경우
                        if(j < money[i-1])
                            dp[i][j] = dp[i-1][j];
                        else
                            dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]]) % 1000000007;
                    }
                }
            }
            return dp[money.length][n];
        }
    }
}
