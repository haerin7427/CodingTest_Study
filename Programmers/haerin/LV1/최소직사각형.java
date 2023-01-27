// https://school.programmers.co.kr/learn/courses/30/lessons/86491
// title : 최소직사각형
// time : 6m
// type : 정수
// Created by haerin on 2023-01-27
public class 최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int wallet_height = 1;
            int wallet_width = 1;
            for(int i=0; i<sizes.length; i++){
                // int height = Math.max(sizes[i][0], sizes[i][1]); 시간이 더 오래걸림
                int height = sizes[i][0] < sizes[i][1] ? sizes[i][1] : sizes[i][0];
                int width = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1];
                
                if(height > wallet_height) {
                    wallet_height = height;
                }
                if(width > wallet_width) {
                    wallet_width = width;
                }
            }
            return wallet_height*wallet_width;
        }
    }
}