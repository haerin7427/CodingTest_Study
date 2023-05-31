package Leetcode.haerin.Medium;
// https://leetcode.com/problems/minimum-path-sum/description/
// title : 64. Minimum Path Sum
// type : DP
// time : 4m
// created by haerin on 2023-05-30
public class minimumPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            for(int y = 0; y<grid.length; y++){
                for(int x=0; x<grid[0].length; x++){
                    if(y==0 && x == 0) continue;
                    if(y == 0){
                        grid[y][x] += grid[y][x-1];
                    }else if(x == 0) {
                        grid[y][x] += grid[y-1][x];
                    }else{
                        grid[y][x] += Math.min(grid[y][x-1],grid[y-1][x]);
                    }
                }
            }
            return grid[grid.length-1][grid[0].length-1];
        }
    }
}
