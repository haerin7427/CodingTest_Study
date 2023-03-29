package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/169199
// title : 리코쳇 로봇
// type : BFS
// time : 40m
// Created by haerin on 2023-03-28
import java.util.*;;
public class 리코쳇로봇 {
    class Solution {
        public int[][] d = new int[][]{{0,1}, {1,0},{0,-1},{-1,0}};
        public int solution(String[] board) {
            int y=-1, x=-1;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length(); j++){
                    if(board[i].charAt(j) == 'R'){
                        y = i;
                        x = j;
                        break;
                    }
                }
                if(x != -1 && y != -1){
                    break;
                }
            }
            
            boolean[][] isVisited = new boolean[board.length][board[0].length()];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{y,x,0});
            isVisited[y][x] = true;
            
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                
                if(board[now[0]].charAt(now[1]) == 'G'){
                    return now[2];
                }
    
                for(int[] move : d){
                    int cy = now[0];
                    int cx = now[1];
                    while(true){
                        int ny = cy+move[0];
                        int nx = cx+move[1];
                        
                        if(ny>=board.length || ny < 0 || nx >= board[0].length() || nx <0) break;
                        if(board[ny].charAt(nx) == 'D') break;
                        
                        cy += move[0];
                        cx += move[1];
                    }
                                    
                    if(isVisited[cy][cx]) continue;
                    isVisited[cy][cx] = true;
                    
                    queue.add(new int[]{cy,cx, now[2]+1});
                }
            }
            return -1;
        }
    }
}