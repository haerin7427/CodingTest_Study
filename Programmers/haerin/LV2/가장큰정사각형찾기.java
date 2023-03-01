package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12905
// title : 가장 큰 정사각형 찾기
// type : DP
// time : 33m
// Created by haerin on 2023-02-28
public class 가장큰정사각형찾기 {
    // 효율성 테스트 결과 : 시간초과
    class Solution {
        public int solution(int [][]board) {
            int max = 0;
            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[0].length; x++){
                    int sum = getSquare(board, y, x);
                    if(max < sum){
                        max = sum;
                    }
                }
            }
            return max;
        }
        
        private int getSquare(int [][]board, int y, int x) {
            int max = Math.min(board.length-y, board[0].length-x);
            int ans = 0;
            for(int l=1; l<=max; l++){
                boolean flag = true;
                for(int row=y; row<y+l; row++){
                    for(int col=x; col<x+l; col++){
                        if(board[row][col] == 0){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag){
                        break;
                    }
                }
                if(flag && ans < l*l){
                    ans = l*l;
                }
            }
            return ans;
        }
    }
    // 정확성, 효율성 테스트 모두 통과
    class Solution2 {
        public int solution(int [][]board) {
            int maxLen = 0;
            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[0].length; x++){
                    if(board[y][x] == 0) continue;
                    
                    if(y>0 && x>0){
                        int min = Math.min(board[y-1][x], board[y-1][x-1]);
                        min = Math.min(min, board[y][x-1]);
                        board[y][x] = min+1;
                    }
                    if(maxLen < board[y][x]){
                        maxLen = board[y][x];
                    }
                }
            }
            return maxLen*maxLen;
        }

    }
}
