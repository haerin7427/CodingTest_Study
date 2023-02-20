package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12913
// title : 땅따먹기
// type : DP
// time : 28m, 8m
// Created by haerin on 2023-02-11, 2023-02-19
public class 땅따먹기 {
    class Solution {
        int solution(int[][] land) {
            for(int y=1; y<land.length; y++){
                for(int x=0; x<land[0].length; x++) {
                    int max = 0;
                    for(int i=0; i<land[0].length; i++) {
                        if(x == i) continue;
                        if(max < land[y-1][i]){
                            max = land[y-1][i];
                        }
                    }
                    land[y][x] += max;
                }
            }
            
            int bestScore = 0;
            for(int score : land[land.length-1]){
                if(bestScore < score)
                    bestScore = score;
            }
            return bestScore;
        }
    }
    // 다시 풀기
    class Solution2 {
        int solution(int[][] land) {        
            for(int y = 1; y<land.length; y++){
                for(int x = 0; x < land[0].length; x++){
                    int max = 0;
                    for(int i=0; i<land[0].length; i++){
                        if(i == x) continue;
                        if(max < land[y-1][i]){
                            max = land[y-1][i];
                        }
                    }
                    land[y][x] += max;
                }
            }
            
            int answer = 0;
            for(int num : land[land.length -1]){
                if(answer < num){
                    answer = num; 
                }
            }
            return answer;
        }
    }
}
