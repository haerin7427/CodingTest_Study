package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/17679
// title : [1차] 프렌즈4블록
// type : 구현
// time : 48m
// Created by haerin on 2023-02-13
import java.util.*;
public class 프렌즈사블록 {
    class Solution {
        public int solution(int m, int n, String[] board) {
            char[][] charBoard = new char[m][n];
            int idx = 0;
            for(String s : board){
                charBoard[idx++] = s.toCharArray();
            }
            
            int answer = 0;
            while(true) {
                int cnt = checkBlock(charBoard);
                if(cnt == 0) break;
                answer += cnt;
            }
            return answer;
        }
        // 전체 보드에서 지울 수 있는 블록이 있는 지 확인
        public int checkBlock(char[][] board){
            boolean[][] isRemove = new boolean[board.length][board[0].length];
            int cnt=0;
            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[0].length; x++){
                    if(board[y][x] != '/' && checkFour(board, y,x)){
                        cnt += checkRemoveBlock(isRemove, y, x);
                    }
                }
            }
            removeBlock(board, isRemove);
            return cnt;
        }
        // 지워진 블록 제거하고 새로 보드 생성
        public void removeBlock(char[][] board, boolean[][] isRemove){
            for(int x=0; x<board[0].length; x++){
                Stack<Character> stack = new Stack<>();
                int cnt=0;
                for(int y=board.length-1; y>=0; y--){
                    if(!isRemove[y][x]){
                        stack.push(board[y][x]);
                    }else{
                        cnt += 1;
                    }
                }
                for(int i=0; i<cnt; i++){
                    stack.push('/');
                }
                
                for(int y=0; y<board.length; y++){
                    board[y][x] = stack.pop();
                }
            }
        }
        // 지울 수 있는 블록 표시
        public int checkRemoveBlock(boolean[][] board, int y, int x) {
            int[][] d = new int[][]{{0,0},{1,0}, {1,1}, {0,1}};
            int cnt = 0;
            for(int i=0; i<d.length; i++){
                if(!board[y+d[i][0]][x+d[i][1]]){
                    cnt += 1;
                    board[y+d[i][0]][x+d[i][1]] = true;
                }
            }
            return cnt;
        }
        // 주어진 블록을 기준으로 같은 모양의 블럭이 2*2 형태로 붙어 있는 지 확인 
        public boolean checkFour(char[][] board, int y, int x) {
            if(y+1 >= board.length || x+1 >= board[0].length){
                return false;
            }
            
            int[][] d = new int[][]{{1,0}, {1,1}, {0,1}};
            for(int i=0; i<d.length; i++){
                if(board[y][x] != board[y+d[i][0]][x+d[i][1]])
                    return false;
            }
            return true;
        }
    }
}
