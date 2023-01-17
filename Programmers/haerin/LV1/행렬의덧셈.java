// https://school.programmers.co.kr/learn/courses/30/lessons/12950
// title : 행렬의 덧셈
// time : 4m
// type : 행렬
// Created by haerin on 2023/01/17
public class 행렬의덧셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr1[0].length];
            for(int y=0; y < arr1.length; y++) {
                for(int x=0; x < arr1[0].length; x++) {
                    answer[y][x] = arr1[y][x] + arr2[y][x];
                }
            }
            return answer;
        }
    }
    class Solution2 {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            for(int y=0; y < arr1.length; y++) {
                for(int x=0; x < arr1[0].length; x++) {
                    arr1[y][x] += arr2[y][x];
                }
            }
            return arr1;
        }
    }
}
