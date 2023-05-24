package Leetcode.haerin.Medium;
// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
// title : 1277. Count Square Submatrices with All Ones
// type : ...
// time : 21m
// Created by haerin on 2023-05-24
public class countSquareSubmatricesWithAllOnes {
    class Solution {
        public int countSquares(int[][] matrix) {
            boolean[][] board = new boolean[matrix.length][matrix[0].length];
            int limit = Math.min(matrix.length, matrix[0].length);
            int answer = 0;
            for(int l=1; l<=limit; l++){
                for(int y=0; y<=matrix.length-l; y++){
                    for(int x=0; x<=matrix[0].length-l; x++){
                        if(board[y][x] || matrix[y][x] == 0) continue;
                        if(isOne(matrix, y, x, l)){
                            answer += 1;
                        }else{
                            board[y][x] = true;
                        }
                    }
                }
            }
            return answer;
        }
    
        public boolean isOne(int[][] matrix, int y, int x, int len){
            for(int i=y; i<y+len; i++){
                for(int j=x; j<x+len; j++){
                    if(matrix[i][j] == 0){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
