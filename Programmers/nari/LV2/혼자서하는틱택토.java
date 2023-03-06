// https://school.programmers.co.kr/learn/courses/30/lessons/160585
// title : 혼자서 하는 틱택토

public class 혼자서하는틱택토 {
    class Solution {
        public int solution(String[] board) {
            int answer = 1;
            // 게임판
            char[][] gameBoard = new char[3][3];
            // o의 갯수, x의 갯수
            int o = 0, x = 0;
            
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    gameBoard[i][j] = board[i].charAt(j);
                    
                    // o와 x 갯수 각각 count
                    if(gameBoard[i][j] == 'O') o++;
                    if(gameBoard[i][j] == 'X') x++;
                }
            }
            
            // answer를 1로 초기화 해뒀기 때문에 0일 경우만 찾아주기
            // 1) O의 개수 < X의 개수 : o가 선공이기 때문에 o는 x보다 크다.
            // 2) O의 개수 > X의 개수 + 1 : 한 턴씩 번갈아가기 때문에 o는 x보다 2이상 클 수 없다.
            // 3) O 줄의 개수 + X 줄의 개수 > 1
            //    (단, O 줄의 개수가 2개이며 X 줄의 개수가 0개일 때 
            //     O의 개수 - X의 개수 = 1 인 경우엔 정상적입니다.
            //     예시
            //      OXO
            //      XOX 가운데 O가 마지막에 들어온 경우 O 줄이 2개가 되면서 끝납니다.)
            //      OXO
            //    : bingo는 1개가 나오면 끝인데, bingo가 2개 이상 나올 경우
            // 4) O 줄의 개수 = 1 그리고 O의 개수 = X의 개수
            //    : o가 선공 + bingo인데 x의 갯수와 같을 경우 (x가 한개 적어야 함)
            // 5) X 줄의 개수 = 1 그리고 O의 개수 > X의 개수
            //    : x bingo인데 o의 갯수가 클 경우 (둘의 갯수는 같아야 함)
    
            
            if(o < x || o > x+1) return 0;
            
            int oBingo = 0, xBingo = 0;
            for(int i=0;i<3;i++) {
                // 1개의 행이 전부 'O'일 경우, o bingo
                if('O' == gameBoard[i][0] && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) oBingo++;
                // 1개의 행이 전부 'X'일 경우, x bingo
                else if('X' == gameBoard[i][0] && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) xBingo++;
                
                // 1개의 열이 전부 'O'일 경우, o bingo
                if('O' == gameBoard[0][i] && gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i]) oBingo++;
                // 1개의 열이 전부 'X'일 경우, x bingo
                else if('X' == gameBoard[0][i] && gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i]) xBingo++;
            }
            
            // 대각선
            if('O' == gameBoard[0][0] && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) oBingo++;
            if('O' == gameBoard[0][2] && gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) oBingo++;
            if('X' == gameBoard[0][0] && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) xBingo++;
            if('X' == gameBoard[0][2] && gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) xBingo++;

            if(oBingo+xBingo > 1 && o-x != 1) return 0;
            if(oBingo == 1 && o == x) return 0;
            if(xBingo == 1 && o > x) return 0;
            
            return answer;
        }
    }
}