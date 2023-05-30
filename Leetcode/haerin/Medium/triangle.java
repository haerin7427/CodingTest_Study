package Leetcode.haerin.Medium;
// https://leetcode.com/problems/triangle/description/
// title : 120. Triangle
// type : DP
// time : 10m
// Created by haerin on 2023-05-30
import java.util.*;
public class triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[][] dp = new int[triangle.size()][triangle.size()];
    
            for(int y=0; y<dp.length; y++){
                for(int x=0; x<=y; x++){
                    dp[y][x] = triangle.get(y).get(x);
                }
            }
            
            for(int y=dp.length-2; y>=0; y--){
                for(int x=0; x<=y; x++){
                    dp[y][x] = Math.min(dp[y][x]+dp[y+1][x], dp[y][x]+dp[y+1][x+1]);
                }
            }
            return dp[0][0];
        }
    }
}
