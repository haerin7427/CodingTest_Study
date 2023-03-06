// https://school.programmers.co.kr/learn/courses/30/lessons/12952
// title : N-Queen

public class NQueen {
    class Solution {
        int[] board;
        int answer = 0;
        
        public int solution(int n) {
            board = new int[n];
            
            dfs(0, n);
            
            return answer;
        }
        
        void dfs(int depth, int n) {
            if(depth == n) {
                answer++;
                return;
            }
            
            // 열만큼 반복
            for(int i=0;i<n;i++) {
                board[depth] = i;
                
                if(check(depth)) dfs(depth+1, n);
            }	
        }
        
        boolean check(int col) {
            for(int i=0;i<col;i++) {
                //행에 queen이 있는 경우
                if(board[i] == board[col]) return false;
        
                //대각선에 queen이 있는 경우
                else if(Math.abs(col-i) == Math.abs(board[col]-board[i])) return false;
            }
            
            return true;
        }
    }
}