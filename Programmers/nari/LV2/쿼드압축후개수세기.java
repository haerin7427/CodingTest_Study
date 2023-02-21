// https://school.programmers.co.kr/learn/courses/30/lessons/68936
// title : 쿼드압축 후 개수 세기

public class 쿼드압축후개수세기 {
    class Solution {
        int[] answer = new int[2];
        
        public int[] solution(int[][] arr) {
            // 시작점, 끝점
            quad(0, 0, arr.length, arr);
            
            return answer;
        }
        
        void quad(int row, int col, int len, int[][] arr) {
            // 모두 같은 값인 경우
            if(isSame(row, col, len, arr)) {
                answer[arr[row][col]]++;
                return;
            }
            
            // 배열을 4등분해서 다시 탐색
            quad(row, col, len/2, arr);
            quad(row + len/2, col, len/2, arr);
            quad(row, col + len/2, len/2, arr);
            quad(row + len/2, col + len/2, len/2, arr);
        }
        
        boolean isSame(int row, int col, int len, int[][] arr) {
            for(int i=row;i<row+len;i++) {
                for(int j=col;j<col+len;j++) {
                    if(arr[row][col] != arr[i][j]) return false;
                }
            }
            
            return true;
        }
    }
}