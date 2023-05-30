package Leetcode.haerin.Medium;
// https://leetcode.com/problems/unique-paths-ii/description/
// title : 63. Unique Paths II
// type : DP
// time : 8m
// Created by haerin on 2023-05-29
public class uniquePaths2 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            for(int y=0; y<dp.length; y++){
                for(int x=0; x<dp[0].length; x++){
                    if(obstacleGrid[y][x] == 1){
                        dp[y][x] = 0;
                    }else if(x == 0 || y == 0){
                        if(x == 0 && y == 0){
                            dp[y][x] = 1;
                        }else if(x == 0 && dp[y-1][x] == 0) {
                            dp[y][x] = 0;
                        }else if(y == 0 && dp[y][x-1] == 0) {
                            dp[y][x] = 0;
                        }else {
                            dp[y][x] = 1;
                        }
                        
                    }else {
                        dp[y][x] = dp[y-1][x] + dp[y][x-1];
                    }
                }
            }
            return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
        }
    }
}
