// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// title : 크레인 인형뽑기 게임
// type : 정수
// time : 12m
// Created by haerin on 2023-01-25
import java.util.Stack;
public class 크레인인형뽑기게임 {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            Stack<Integer> basket = new Stack<>();
            int answer = 0;
            for(int i=0; i<moves.length; i++) {
                int x = moves[i]-1;
                for(int y=0; y<board.length; y++) {
                    if(board[y][x] != 0) {
                        if(!basket.empty() && board[y][x] == basket.peek()) {
                            basket.pop();
                            answer += 2;
                        }else {
                            basket.push(board[y][x]);
                        }
                        board[y][x] = 0;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
