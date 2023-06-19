package Leetcode.haerin.Medium;
// https://leetcode.com/problems/minimum-falling-path-sum/description/
// title : 931. Minimum Falling Path Sum
// type : DP
// time : 8m
// Created by haerin on 2023-06-19
public class minimumFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            for(int y=1; y<matrix.length; y++){
                for(int x=0; x<matrix[0].length; x++){
                    int origin = matrix[y][x];
                    matrix[y][x] += matrix[y-1][x];
                    if(x > 0 && matrix[y][x] > origin + matrix[y-1][x-1]) {
                        matrix[y][x] = origin + matrix[y-1][x-1];
                    }
                    if(x < matrix[0].length-1 && matrix[y][x] > origin + matrix[y-1][x+1]) {
                        matrix[y][x] = origin + matrix[y-1][x+1];
                    }
                }
            }
            int min = matrix[matrix.length-1][0];
            for(int i=1; i<matrix[0].length; i++){
                if(min > matrix[matrix.length-1][i]){
                    min = matrix[matrix.length-1][i];
                }
            }
            return min;
        }
    }
}
