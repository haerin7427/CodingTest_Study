package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/1829
// title : 카카오프렌즈 컬러링북
// type : dfs
// time : 24m
// Created by haerin on 2023-03-08
public class 카카오프렌즈컬러링북 {
    class Solution {
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            boolean[][] isVisted = new boolean[m][n];
            
            for(int y=0; y<picture.length; y++){
                for(int x=0; x<picture[0].length; x++){
                    if(picture[y][x] > 0 && isVisted[y][x] == false){
                        numberOfArea += 1;
                        int area = dfs(picture,isVisted, x, y);
                        if(area > maxSizeOfOneArea){
                            maxSizeOfOneArea = area;
                        }
                    }
                    
                }
            }
            
            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }
        
        private int dfs(int[][] picture, boolean[][] isVisted, int x, int y){
            isVisted[y][x] = true;
            
            int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
            int cnt=1;
            for(int[] move : d){
                int ny = y+move[0];
                int nx = x+move[1];
                
                if(ny >= picture.length || ny < 0 || nx >= picture[0].length || nx < 0) continue;
                if(picture[ny][nx] != picture[y][x] || isVisted[ny][nx] == true) continue;
                cnt += dfs(picture, isVisted, nx, ny);
            }
            return cnt;
        }
    }
}
