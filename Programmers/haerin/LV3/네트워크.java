package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/43162
// title : 네트워크
// type : dfs
// time : 20m
// Created by haerin on 2023-03-13
public class 네트워크 {
    class Solution {
        public int solution(int n, int[][] computers) {
            boolean[] isVisited = new boolean[n];
            int answer = 0;
            for(int i=0; i<n; i++){
                if(isVisited[i]) continue;
                dfs(computers, isVisited, i);
                answer+=1;
            }
            return answer;
        }
        
        public void dfs(int[][] computers, boolean[] isVisited, int y){
            isVisited[y] = true;
            
            for(int x=0; x<computers.length; x++){
                if(computers[y][x] == 0 || isVisited[x]) continue;
                dfs(computers, isVisited, x);
            }
        }
    }
}
