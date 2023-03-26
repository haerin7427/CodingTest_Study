package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/67259
// title : 경주로 건설
// type : bfs
// time : 20m
// Created by haerin on 2023-03-25
import java.util.*;
public class 경주로건설 {
    class Solution {
        public int solution(int[][] board) {
            int[][] d = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            int N = board.length;
            int[][][] map = new int[N][N][2]; // [][][0] : 세로 이동, [][][1] : 가로 이동 
            
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    map[y][x][0] = Integer.MAX_VALUE;
                    map[y][x][1] = Integer.MAX_VALUE;
                }
            }
            
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0,0});
            queue.add(new int[]{0,0,1});
            map[0][0][0] = 0;
            map[0][0][1] = 0;
            
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                
                for(int[] move : d){
                    int ny = cur[0] + move[0];
                    int nx = cur[1] + move[1];
                    int nc = map[cur[0]][cur[1]][cur[2]] + (cur[2]+Math.abs(move[0]) % 2 == 1 ? 100 : 600);
                    int nd = move[0] % 2 != 0 ? 0 : 1;
                    
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                    if(board[ny][nx] == 1) continue;
                    if(map[ny][nx][nd] <= nc) continue;
    
                    map[ny][nx][nd] = nc;
                    queue.add(new int[]{ny, nx, nd});
                    
                }
            }
            
            
            int answer = Math.min(map[N-1][N-1][0], map[N-1][N-1][1]);;
            return answer;
        }
    }
}
