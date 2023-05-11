package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/43105
// title : 정수삼각형
// type : DP
// time : 5m, 3m
// Created by haerin on 2023-03-15, 2023-05-11
public class 정수삼각형 {
    class Solution {
        public int solution(int[][] triangle) {
            for(int y=triangle.length-2; y>=0; y--){
                for(int x=0; x<triangle[y].length;x++){
                    triangle[y][x] += Math.max(triangle[y+1][x], triangle[y+1][x+1]);
                }
            }
            return triangle[0][0];
        }
    }
    // 0511 : 2차 시도
    class Solution2 {
        public int solution(int[][] triangle) {
            for(int y=triangle.length-2; y>=0; y--){
                for(int x=0; x<triangle[y].length; x++){
                    triangle[y][x] += Math.max(triangle[y+1][x], triangle[y+1][x+1]);
                }
            }
            return triangle[0][0];
        }
    }
}
