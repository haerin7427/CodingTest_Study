package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// title : 미로 탈출
// type : BFS
// time : 25m
// Created by haerin on 2023-03-09
import java.util.*;
public class 미로탈출 {
    class Solution {
        public int[][] d = new int[][]{{1,0}, {0,-1},{-1,0},{0,1}};
        class Point {
            int y;
            int x;
            int len;
            Point(int y, int x, int len){
                this.y = y;
                this.x = x;
                this.len = len;
            }
        }
        public int solution(String[] maps) {
            int first = findWay('S', 'L', maps);
            int second = findWay('L', 'E', maps);
    
            return first == -1 || second == -1 ? -1 : first+second;
        }
        
        public int findWay (char start, char end, String[] maps){
            boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
            Queue<Point> q = new LinkedList<>();
            for(int y=0; y<maps.length; y++){
                for(int x=0; x<maps[0].length(); x++){
                    if(maps[y].charAt(x) == start){
                        q.add(new Point(y,x,0));
                        isVisited[y][x] = true;
                        break;
                    }
                }
            }
            
            while(!q.isEmpty()){
                Point now = q.remove();
                
                for(int[] move : d){
                    int ny = now.y+move[0];
                    int nx = now.x+move[1];
                    
                    if(ny<0 || ny >= maps.length || nx < 0 || nx >= maps[0].length()) continue;
                    if(maps[ny].charAt(nx) == 'X' || isVisited[ny][nx] == true) continue;
                    
                    if(maps[ny].charAt(nx) == end){
                        return now.len+1;
                    }
                    
                    q.add(new Point(ny, nx, now.len+1));
                    isVisited[ny][nx] = true;
                }
            }
            
            return -1;
        }
    }
}
