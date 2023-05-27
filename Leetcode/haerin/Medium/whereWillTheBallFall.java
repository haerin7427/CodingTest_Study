package Leetcode.haerin.Medium;
// https://leetcode.com/problems/where-will-the-ball-fall/description/
// title : 1706. Where Will the Ball Fall
// type : ...
// time : 15m
// Creatd by haerin on 2023-05-26
public class whereWillTheBallFall {
    class Solution {
        public int[] findBall(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] ans = new int[n];
    
            for(int i=0; i<n; i++){
                int r = 0, c = i;
    
                while(r < m) {
                    int cur = grid[r][c];
                    c += cur; // 이웃 셀의 값이 같아야 한다!
    
                    if(c < 0 || c >= n || grid[r][c] != cur){
                        c = -1;
                        break;
                    }
                    r += 1;
                }
                ans[i] = c;
            }
            return ans;
        }
    }
}
