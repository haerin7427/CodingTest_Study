// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// title : 크레인 인형뽑기 게임

import java.util.*;

public class 크레인인형뽑기게임 {
    // list 사용 - 시간은 비슷
    class Solution1 {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            for(int i=0;i<moves.length;i++) {
                for(int j=0;j<board.length;j++) {
                    int num = board[j][moves[i]-1];
                    
                    if(num == 0) continue;
                    else {
                        int size = list.size()-1;
                        
                        if(size < 0 || num != list.get(size)) list.add(num);
                        else {
                            list.remove(size);
                            answer += 2;
                        }
                        
                        board[j][moves[i]-1] = 0;
                        
                        break;
                    }
                }
            }
            
            return answer;
        }
    }

    // stack 사용 - 시간은 비슷
    class Solution2 {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            
            for(int move : moves) {
                for(int j=0;j<board.length;j++) {
                    if(board[j][move-1] != 0) {
                        if(stack.isEmpty()) {
                            stack.push(board[j][move-1]);
                            board[j][move-1] = 0;
                            break;
                        }
                        
                        if(board[j][move-1] == stack.peek()) {
                            stack.pop();
                            answer += 2;
                        } else
                            stack.push(board[j][move-1]);
                        
                        board[j][move-1] = 0;
                        break;
                    }
                }
            }
            
            return answer;
        }
    }
}