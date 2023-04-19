package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12942
// title : 최적의 행렬곱셈
// type : DP
// time : ...
// Created by haerin on 2023-04-18
public class 최적의행렬곱셈 {
    class Solution {
        public int solution(int[][] matrix_sizes) {
            int length = matrix_sizes.length;
            int[][] dp = new int[length][length];
            
            for(int i = 0; i < length; i++){
                for(int j = 0; j < length; j++){
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            
            for(int i = 0; i < length; i++){
                for(int j = 0; j < length-i; j++){
                    int a = j;
                    int b = j+i;
                    if(a == b) dp[a][b] = 0;
                    else{
                        for(int k = a; k < b; k++){
                            dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k+1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                        }
                    }
                }
            }
            
            return dp[0][length-1];
        }
    }
}
