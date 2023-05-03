package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/1844
// title : 게임 맵 최단거리
// type : bfs
// time : 32m, 12m
// Created by haerin on 2023-02-14, 2023-05-02
import java.util.*;
public class 게임맵최단거리 {
    class Solution {
        class Location {
            int x;
            int y;
            int cnt;
            
            Location(int x, int y, int cnt){
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }
        public int solution(int[][] maps) {
            return bfs(maps);
        }
        
        public int bfs(int[][] maps){
            int[][] d = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
            boolean[][] isVisited = new boolean[maps.length][maps[0].length];
            Queue<Location> queue = new LinkedList<>();
            
            queue.offer(new Location(0,0,1));
            isVisited[0][0] = true;
            int pathCount=-1;
            
            while(!queue.isEmpty()){
                Location location = queue.remove();
                if(location.y == maps.length-1 && location.x == maps[0].length-1){
                    pathCount = location.cnt;
                    break;
                }
                
                for(int i=0; i<d.length; i++){
                    int newY = location.y + d[i][0];
                    int newX = location.x + d[i][1];
                    
                    if(newY < 0 || newY >= maps.length || newX < 0 || newX >= maps[0].length) continue;
                    if(maps[newY][newX] == 0 || isVisited[newY][newX] == true) continue;
                    queue.offer(new Location(newX,newY,location.cnt+1));
                    isVisited[newY][newX] = true;
                }
            }
            return pathCount;
        }
    }
    // 0502 2차 시도
    class Solution2 {
        class Block {
            int y;
            int x;
            int distance;
            
            Block(int y, int x, int d){
                this.y = y;
                this.x = x;
                this.distance = d;
            }
        }
        public int solution(int[][] maps) {
            return bfs(maps);
        }
        
        private int bfs(int[][] maps){
            boolean[][] isVisited = new boolean[maps.length][maps[0].length];
            int[][] move = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            int answer = -1;
            Queue<Block> queue = new LinkedList<>();
            queue.add(new Block(0,0,1));
            isVisited[0][0] = true;
            
            while(!queue.isEmpty()){
                Block now = queue.poll();
                
                if(now.y == maps.length-1 && now.x == maps[0].length-1){
                    answer = now.distance;
                    break;
                }
                
                for(int[] m : move){
                    int ny = now.y + m[0];
                    int nx = now.x + m[1];
                    
                    if(nx < 0 || ny < 0 || nx >= maps[0].length || ny >= maps.length) continue;
                    if(maps[ny][nx] == 0 || isVisited[ny][nx]) continue;
                    
                    isVisited[ny][nx] = true;
                    queue.add(new Block(ny,nx,now.distance+1));
                }
            }
            
            return answer;
        }
    }
}
