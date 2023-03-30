package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/1832
// title : 보행자 천국
// type : DP
// time : 30m
// Created by haerin on 2023-03-30
public class 보행자천국 {
    class Solution {
        int MOD = 20170805;
        public int solution(int m, int n, int[][] cityMap) {
            int[][][] dp = new int[m+1][n+1][2]; // [][][0] : 세로 방향으로 들어온 경우, [][][1] : 가로방향
            dp[0][0][0] = 1;
            
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if (cityMap[i][j] == 0) {
                        dp[i + 1][j][0] += (dp[i][j][0] + dp[i][j][1]) % MOD;
                        dp[i][j + 1][1] += (dp[i][j][0] + dp[i][j][1]) % MOD;
                    } else if (cityMap[i][j] == 2) {
                        dp[i + 1][j][0] += dp[i][j][0] % MOD;
                        dp[i][j + 1][1] += dp[i][j][1] % MOD;
                    }
                }
            }
            
            return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
        }
    }
}
