package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12949
// title : 행렬의 곱셈
// type : 행렬
// time : 5m
// Created by haerin on 2023-02-09
public class 행렬의곱셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];
            int limit = arr1[0].length;
            
            for(int y=0; y<answer.length; y++){
                for(int x=0; x<answer[0].length; x++){
                    for(int i=0; i<limit; i++){
                        answer[y][x] += arr1[y][i] * arr2[i][x];
                    }
                }
            }
            return answer;
        }
    }
}
