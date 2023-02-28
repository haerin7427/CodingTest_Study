// https://school.programmers.co.kr/learn/courses/30/lessons/12905
// title : 가장 큰 정사각형 찾기

public class 가장큰정사각형찾기 {
    class Solution
    {
        public int solution(int [][]board)
        {
            int answer = 0;
            int[][] map = new int[board.length+1][board[0].length+1];
            
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[0].length;j++) {
                    map[i+1][j+1] = board[i][j];
                }
            }
            
            for(int i=1;i<=board.length;i++) {
                for(int j=1;j<=board[0].length;j++) {
                    // 0이 아닌 경우
                    if(map[i][j] != 0) {
                        // (왼쪽 / 위쪽 / 왼쪽 대각선 위) 3개 숫자 중 최소 + 1
                        map[i][j] = Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1]) + 1;
                        
                        // 저장된 숫자가 가장 큰 정사각형의 한 변의 크기
                        answer = Math.max(answer, map[i][j]); 
                    }
                }
            }
            
            return answer * answer;
        }
    }
}