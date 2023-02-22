package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/77485
// title : 행렬 테두리 회전하기
// type : 구현
// time : 36m
// Created by haerin on 2023-02-21
public class 행렬테두리회전하기 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[][] board = new int[rows][columns];
            int num = 1;
            for(int y=0; y<rows; y++){
                for(int x=0; x<columns; x++){
                    board[y][x] = num++;
                }
            }
            
            int[] answer = new int[queries.length];
            int idx=0;
            for(int i=0; i<queries.length; i++){
                answer[idx++] = rotateBoard(board, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
            }
            return answer;
        }
        private int rotateBoard(int[][] b, int y1, int x1, int y2, int x2){
            int[][] d = new int[][]{{0,1,x2-x1},{1,0,y2-y1},{0,-1,x2-x1},{-1,0,y2-y1}};
            int nx = x1, ny = y1;
            int newNumber = b[y1][x1];
            int cnt = newNumber;
            for(int i=0; i<d.length; i++){
                
                for(int j=0; j<d[i][2]; j++){
                    ny += d[i][0];
                    nx += d[i][1];
                    int temp = b[ny][nx];
                    b[ny][nx] = newNumber;
                    newNumber = temp;
                    if(cnt > newNumber){
                        cnt = newNumber;
                    }
                }
            }
            return cnt;
        }
    }
}
