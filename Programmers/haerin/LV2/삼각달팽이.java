package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/68645
// title : 삼각달팽이
// type : 수
// time : 23m
// Created by haerin on 2023-02-23
public class 삼각달팽이 {
    class Solution {
        public int[] solution(int n) {
            int num = n * (n+1) / 2;
            int[] answer = new int[num];
            int[][] board = new int[n][n];
            
            int y=0, x=0, r=0;
            int[][] d = new int[][]{{1,0},{0,1},{-1,-1}};
            for(int i=1; i<= num; i++){
                board[y][x] = i;
            
                int ny = y+d[r][0];
                int nx = x+d[r][1];
                if(nx<0 || nx>=n || ny<0 || ny>=n || board[ny][nx]>0) {
                    r = (r+1)%3;
                    ny = y+d[r][0];
                    nx = x+d[r][1];
                }
                y = ny;
                x = nx;
            }
            int idx=0;
            for(int row=0; row<n; row++){
                for(int col=0; col<=row; col++){
                    answer[idx++] = board[row][col];
                }
            }
            
            return answer;
        }
    }
}
