// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
// title : 1277. Count Square Submatrices with All Ones
// time taken : 21 m 56 s

public class CountSquareSubmatriceswithAllOnes {
    class Solution {
        // 0 1 1 1
        // 1 1 1 1
        // 0 1 1 1

        // 0 1 1 1
        // 1 1 2 2
        // 0 1 2 3
        public int countSquares(int[][] matrix) {
            int cnt = 0;
            int len1 = matrix.length, len2 = matrix[0].length;

            for(int i=0;i<len1;i++) {
                for(int j=0;j<len2;j++) {
                    if(matrix[i][j] > 0 && i > 0 && j > 0) {
                        // 현재 위치 -> 위, 왼, 왼대각선위 에서 가장 작은 수
                        int min = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                        matrix[i][j] = min + 1;
                    }

                    cnt += matrix[i][j];
                }
            }

            return cnt;
        }
    }
}
