package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/60063
// title : 블록 이동하기
// type : 구현
// time : ...
// Created by haerin on 2023-04-16
import java.util.*;
public class 블록이동하기 {
    class Solution {
        public int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        public int[][] dx = new int[][]{{0,1},{0,-1}};
        public int[][] dy = new int[][]{{1,0},{-1,0}};
        class Robot{
            int y1, x1, y2, x2, time;
            Robot(int y1, int x1, int y2, int x2, int time){
                this.y1 = y1;
                this.x1 = x1;
                this.y2 = y2;
                this.x2 = x2;
                this.time = time;
            }
        }
        public int solution(int[][] board) {
            int answer = 0;
            int N = board.length-1;
            boolean[][][][] isChecked = new boolean[N+1][N+1][N+1][N+1];
            
            Queue<Robot> queue = new LinkedList<>();
            queue.add(new Robot(0,0,0,1,0));
            isChecked[0][0][0][1] = true;
            
            while(!queue.isEmpty()){
                Robot cur = queue.poll();
                
                if( (cur.x1 == N && cur.y1 == N) || (cur.x2 == N && cur.y2 == N)) {
                    answer = cur.time;
                    break;
                }
                
                // 이동하기
                for(int[] move : d){
                    int ny1 = cur.y1 + move[0];
                    int nx1 = cur.x1 + move[1];
                    int ny2 = cur.y2 + move[0];
                    int nx2 = cur.x2 + move[1];
                    
                    if(ny1 < 0 || nx1 < 0 || ny2 < 0 || nx2 < 0) continue;
                    if(ny1 > N || nx1 > N || ny2 > N || nx2 > N) continue;
                    if(board[ny1][nx1] == 1 || board[ny2][nx2] == 1) continue;
                    if(isChecked[ny1][nx1][ny2][nx2]) continue;
                                    
                    queue.add(new Robot(ny1,nx1,ny2,nx2,cur.time+1));
                    isChecked[ny1][nx1][ny2][nx2] = true;
                }
                
                // 회전하기
                int y1 = cur.y1;
                int x1 = cur.x1;
                int y2 = cur.y2;
                int x2 = cur.x2;
                
                if(y1 == y2){
                    // 가로 구조
                    if(y1 < N && board[y1+1][x1] == 0 && board[y2+1][x2] == 0 && !isChecked[y1][x1][y1+1][x1]){
                        queue.add(new Robot(y1,x1,y1+1,x1,cur.time+1));
                        isChecked[y1][x1][y1+1][x1] = true;
                    }
                    if(y1 < N && board[y1+1][x1] == 0 && board[y2+1][x2] == 0 && !isChecked[y2][x2][y2+1][x2]){
                        queue.add(new Robot(y2,x2,y2+1,x2,cur.time+1));
                        isChecked[y2][x2][y2+1][x2] = true;
                    }
                    
                    if(y1 > 0 && board[y1-1][x1] == 0 && board[y2-1][x2] == 0 && !isChecked[y1-1][x1][y1][x1]){
                        queue.add(new Robot(y1-1,x1,y1,x1,cur.time+1));
                        isChecked[y1-1][x1][y1][x1] = true;
                    }
                    if(y1 > 0 && board[y1-1][x1] == 0 && board[y2-1][x2] == 0 && !isChecked[y2-1][x2][y2][x2]){
                        queue.add(new Robot(y2-1,x2,y2,x2,cur.time+1));
                        isChecked[y2-1][x2][y2][x2] = true;
                    }
                    
                }else{
                    if(x1 < N && board[y1][x1+1] == 0 && board[y2][x2+1] == 0 && !isChecked[y1][x1][y1][x1+1]){
                        queue.add(new Robot(y1,x1,y1,x1+1,cur.time+1));
                        isChecked[y1][x1][y1][x1+1] = true;
                    }
                    if(x1 < N && board[y1][x1+1] == 0 && board[y2][x2+1] == 0 && !isChecked[y2][x2][y2][x2+1]){
                        queue.add(new Robot(y2,x2,y2,x2+1,cur.time+1));
                        isChecked[y2][x2][y2][x2+1] = true;
                    }
                    if(x1 > 0 && board[y1][x1-1] == 0 && board[y2][x2-1] == 0 && !isChecked[y1][x1-1][y1][x1]){
                        queue.add(new Robot(y1,x1-1,y1,x1,cur.time+1));
                        isChecked[y1][x1-1][y1][x1] = true;
                    }
                    if(x1 > 0 && board[y1][x1-1] == 0 && board[y2][x2-1] == 0 && !isChecked[y2][x2-1][y2][x2]){
                        queue.add(new Robot(y2,x2-1,y2,x2,cur.time+1));
                        isChecked[y2][x2-1][y2][x2] = true;
                    }
                }
                
            }
            
            return answer;
        }
    }
}
