package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/86052
// title : 빛의 경로 사이클
// type : dfs
// time : 36m
// Created by haerin on 2023-03-09
import java.util.*;
public class 빛의경로사이클 {
    class Solution {
        public int[][] move ={{1,0}, {0, -1}, {-1, 0}, {0,1}};
        public int[] solution(String[] grid) {
            List<Integer> answer = new ArrayList<>();
            boolean[][][] isVisited = new boolean[grid.length][grid[0].length()][4];
            
            for(int y=0; y<isVisited.length; y++){
                for(int x=0; x<isVisited[0].length; x++){
                    for(int d=0; d<isVisited[0][0].length; d++){
                        if(!isVisited[y][x][d]){
                            answer.add(makeCycle(grid, isVisited, y, x, d));
                        }
                    }
                }
            }
            return answer.stream().sorted().mapToInt(i -> i).toArray();
        }
        
        private int makeCycle(String[] grid, boolean[][][] isVisited, int y, int x, int d) {
            // d 방향 순서 : 0(아래), 1(왼쪽), 2(위), 3(오른쪽)
            int moveDistance = 0;
            
            while(true){
                if(isVisited[y][x][d]){
                    break;
                }
                
                isVisited[y][x][d] = true;
                moveDistance += 1;
                
                if(grid[y].charAt(x) == 'L'){ 
                    d = (d+3) % 4;
                }else if(grid[y].charAt(x) == 'R'){
                    d = (d+1) % 4;
                }
                
                y = (y + move[d][0] + grid.length) % grid.length;
                x = (x + move[d][1] + grid[0].length()) % grid[0].length();
            }
            return moveDistance;
        }
    }
}
