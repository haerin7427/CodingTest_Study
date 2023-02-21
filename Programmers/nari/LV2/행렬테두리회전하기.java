// https://school.programmers.co.kr/learn/courses/30/lessons/77485
// title : 행렬 테두리 회전하기

public class 행렬테두리회전하기 {
    class Solution {
        int[][] matrix;
        
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            matrix = new int[rows][columns];
            int cnt = 1;
            
            // 행렬
            for(int i=0;i<rows;i++) {
                for(int j=0;j<columns;j++){
                    matrix[i][j] = cnt++;
                }
            }
            
            for(int i=0;i<queries.length;i++) {
                // 회전하면서 가장 작은 숫자 찾아 return
                answer[i] = rotate(queries[i]);
            }
            
            return answer;
        }
        
        int rotate(int[] query) {
            int row1 = query[0]-1, col1 = query[1]-1, row2 = query[2]-1, col2 = query[3]-1;
            
            // 시작 위치 값
            int start = matrix[row1][col1];
            int min = start;
            
            // 좌
            for(int i=row1;i<row2;i++) {
                matrix[i][col1] = matrix[i+1][col1];
                
                if(min > matrix[i][col1]) min = matrix[i][col1];
            }
            
            // 하
            for(int i=col1;i<col2;i++) {
                matrix[row2][i] = matrix[row2][i+1];
                
                if(min > matrix[row2][i]) min = matrix[row2][i];
            }
            
            // 우
            for(int i=row2;i>row1;i--) {
                matrix[i][col2] = matrix[i-1][col2];
                
                if(min > matrix[i][col2]) min = matrix[i][col2];
            }
            
            // 상
            for(int i=col2;i>col1;i--) {
                matrix[row1][i] = matrix[row1][i-1];
                
                if(min > matrix[row1][i]) min = matrix[row1][i];
            }
            
            matrix[row1][col1+1] = start;
            
            return min;
        }
    }
}