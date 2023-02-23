// https://school.programmers.co.kr/learn/courses/30/lessons/68645
// title : 삼각 달팽이

public class 삼각달팽이 {
    class Solution {
        public int[] solution(int n) {
            // 등차수열 합의 일반항 공식
            // Sn = n(a1 + an) / 2
            int[] answer = new int[(n*(1+n))/2];
            
            // 정사각형에서 왼쪽, 아래쪽에 붙어있는 직각삼각형이라고 생각
            // 아래 -> 오른쪽 -> 대각선의 순서 반복
            // 아래 : row 증가
            // 오른쪽 : col 증가
            // 대각선 : row 감소, col 감소
            
            int[][] matrix = new int[n][n];
            // +1 해주고 시작하기 때문에 row = -1
            // col의 0번째는 아래로 내려가면서 채워지기때문에 0부터 시작
            int row = -1, col = 0, num = 1;
            
            for(int i=0;i<n;i++) {
                for(int j=i;j<n;j++) { 
                    // 아래
                    if(i % 3 == 0) row++;
                    // 오른쪽
                    else if(i % 3 == 1) col++;
                    // 대각선 -> i % 3 == 2
                    else {
                        row--;
                        col--;
                    }
                    
                    matrix[row][col] = num++;
                }
            }
            
            int idx = 0;
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(matrix[i][j] == 0) break;
                    
                    answer[idx++] = matrix[i][j];
                }
            }
            
            return answer;
        }
    }
}