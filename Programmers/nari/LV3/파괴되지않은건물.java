// https://school.programmers.co.kr/learn/courses/30/lessons/92344
// title : 파괴되지 않은 건물

public class 파괴되지않은건물 {
    class Solution {
        public int solution(int[][] board, int[][] skill) {
            int N = board.length, M = board[0].length;
            int[][] sum = new int[N+1][M+1];
            
            for(int[] s : skill) {
                int r1 = s[1], c1 = s[2];
                int r2 = s[3], c2 = s[4];
                // type이 1일 경우, 내구도 낮추고, 2일 경우, 내구도 높이기
                int degree = s[0] == 1 ? -s[5] : s[5];
    
                sum[r1][c1] += degree;
                sum[r1][c2+1] += -degree;
                sum[r2+1][c1] += -degree;
                sum[r2+1][c2+1] += degree;
            }
            
            // 효율성 -> 누적합 활용
            // 2가지 방향(상하, 좌우)에 대해 합산(현재값 += 이전값)하여 전체적인 합산
            // 상하
            for(int r=1;r<N;r++) {
                for(int c=0;c<M;c++) {
                    sum[r][c] += sum[r-1][c];
                }
            }
            
            // 좌우
            for(int c=1;c<M;c++) {
                for(int r=0;r<N;r++) {
                    sum[r][c] += sum[r][c-1];
                }
            }
            
            int answer = 0;
            
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(board[i][j] + sum[i][j] > 0) answer++;
                }
            }
            
            return answer;
        }
    }
}