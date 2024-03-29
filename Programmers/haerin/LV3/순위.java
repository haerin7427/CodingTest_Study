package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/49191
// title : 순위
// type : 플로이드 와샬
// time : 18m, 15m
// Created by haerin on 2023-03-31, 2023-05-05
public class 순위 {
    class Solution {
        public int solution(int n, int[][] results) {
            int[][] board = new int[n+1][n+1];
            for(int[] r : results){
                board[r[0]][r[1]] = 1;
                board[r[1]][r[0]] = -1;
            }
            
            for(int y=1; y<=n; y++){
                for(int x=1; x<=n; x++){
                    for(int k=1; k<=n; k++){
                        if(board[y][k] == 1 && board[k][x] == 1){
                            board[y][x] = 1;
                            board[x][y] = -1;
                        }
                        if(board[y][k] == -1 && board[k][x] == -1){
                            board[y][x] = -1;
                            board[x][y] = 1;
                        }
                    }
                }
            }
            
            int answer = 0;
            for(int[] b : board){
                int cnt = 0;
                for(int i=1; i<=n; i++){
                    if(b[i] == 0){
                        cnt += 1;
                    }
                }
                if(cnt == 1) answer += 1;
            }
            return answer;
        }
    }
    // 0505 2차시도
    class Solution2 {
        public int solution(int n, int[][] results) {
            int[][] record = new int[n+1][n+1]; // 1 : 승리, -1 : 패배
            for(int[] r : results){
                record[r[0]][r[1]] = 1;
                record[r[1]][r[0]] = -1;
            }
            
            for(int y=1; y<=n; y++){
                for(int x=1; x<=n; x++){
                    for(int k=1; k<=n; k++){
                        if(record[y][k] == 1 && record[k][x] == 1){
                            record[y][x] = 1;
                            record[x][y] = -1;
                        }else if(record[y][k] == -1 && record[k][x] == -1){
                            record[x][y] = 1;
                            record[y][x] = -1;
                        }
                    }
                }
            }
            int answer = 0;
            for(int y = 1; y <= n; y++){
                for(int x=1; x<=n; x++){
                    if(x == y) continue;
                    if(record[y][x] == 0){
                        answer -= 1;
                        break;
                    }
                }
                answer += 1;
            }
            return answer;
        }
    }
}
