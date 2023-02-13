// https://school.programmers.co.kr/learn/courses/30/lessons/17679
// title : [1차] 프렌즈4블록

public class 프렌즈4블록 {
    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] c = new char[m][n];
            
            for(int i=0;i<m;++i) {
                c[i] = board[i].toCharArray();
            }
            
            // 지워지는 블록이 없을 때까지
            while(true) {
                // 지워진 블록 갯수 return
                int cnt = checkBlock(m, n, c);
                // 지워진 블록이 없다면 완료
                if(cnt == 0) break;
                // 갯수 더해주기
                answer += cnt;
                
                // 지워진 위치 위에 블록이 있다면 떨어지도록
                dropBlock(m, n, c);
            }
            
            return answer;
        }
        
        void dropBlock(int m, int n, char[][] board) {
            // 열은 동일하고, 행 위치만 바뀐다.
            for(int a=0;a<n;a++) {
                for(int b=m-1;b>=0;b--) {
                    if(board[b][a] == ' ') {
                        for(int x=b-1;x>=0;x--) {
                            if(board[x][a] != ' ') {
                                board[b][a] = board[x][a];
                                board[x][a] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        int checkBlock(int m, int n, char[][] board) {
            int cnt = 0;
            boolean[][] isChecked = new boolean[m][n];
            
            for(int i=0;i<m-1;i++) {
                for(int j=0;j<n-1;j++) {
                    // 이미 제거된 블록이면, continue
                    if(board[i][j] == ' ') continue;
                    
                    // 4개가 되는지 체크
                    checkFour(board, isChecked, i, j);
                }
            }
            
            // true인 위치의 블록 지우기 = 공백(' ')
            // 갯수 count
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(isChecked[i][j]) {
                        cnt++;
                        board[i][j] = ' ';
                    }
                }
            }
            
            // count된 갯수 return
            return cnt;
        }
        
        void checkFour(char[][] board, boolean[][] isChecked, int i, int j) {
            char block = board[i][j];
            
            // 같은 블록이 4개인지 체크
            for(int a=i;a<i+2;a++) {
                for(int b=j;b<j+2;b++) {
                    // 블록이랑 다른 경우, 바로 return
                    if(board[a][b] != block) return;
                }
            }
            
            // 4개 모두 동일하다면, 해당 위치 true로 변경
            for(int a=i;a<i+2;a++) {
                for(int b=j;b<j+2;b++) {
                    isChecked[a][b] = true;
                }
            }
        }
    }
}