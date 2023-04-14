package Programmers.haerin.LV3;
import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/87694
// title : 아이템 줍기
// type : BFS
// time : 20m
// Created by haerin on 2023-04-13
public class 아이템줍기 {
    class Solution {
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            boolean[][] board = makeBoard(rectangle);
            
            int answer = bfs(board, rectangle, characterX*2, characterY*2, itemX*2, itemY*2);
            return answer;
        }
        
        private int bfs(boolean[][] board, int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{characterX, characterY, 0});
            board[characterY][characterX] = false;
            int distance = -2;
            
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                int d = now[2];
                
                if(x == itemX && y == itemY){
                    distance = d;
                    break;
                }
                
                if(board[y+1][x] == true) {
                    board[y+1][x] = false;
                    queue.add(new int[]{x, y+1, d+1});
                }
                if(board[y][x+1]==true) {
                    board[y][x+1] = false;
                    queue.add(new int[]{x+1, y, d+1});
                }
                if(board[y-1][x]==true)  {
                    board[y-1][x] = false;
                    queue.add(new int[]{x, y-1, d+1});
                }
                if(board[y][x-1]==true)  {
                    board[y][x-1] = false;
                    queue.add(new int[]{x-1, y, d+1});
                }
            }
            
            return distance / 2;
            
        }
    
        
        private boolean[][] makeBoard(int[][] rectangle){
            boolean[][] board = new boolean[52*2][52*2];
            // 1. 직사각형 모두 true 표시
            for(int[] data:rectangle){
                //1.테두리 포함해서 직사각형 모두 true채우기
                for(int i=data[1]*2;i<=data[3]*2;i++){
                  for(int j=data[0]*2;j<=data[2]*2;j++){
                        board[i][j]=true;
                      
                  }  
                }
            }
            // 2. 직사각형의 테두리를 제외하고 false로 표시
            for(int[] data:rectangle){
                for(int i=data[1]*2+1;i<data[3]*2;i++){
                  for(int j=data[0]*2+1;j<data[2]*2;j++){
                        board[i][j]=false;
                  }  
                }
            }
            return board;
        }
    }
}
