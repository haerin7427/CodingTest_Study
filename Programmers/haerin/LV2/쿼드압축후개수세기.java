package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/68936
// title : 쿼드압축 후 개수 세기
// type : 백트랙킹
// time : 17m
// Created by haerin on 2023-03-10
public class 쿼드압축후개수세기 {
    class Solution {
        public int[] solution(int[][] arr) {
            compress(arr, arr.length, 0, 0);
            int[] answer = new int[2];
            for(int y=0; y<arr.length; y++){
                for(int x=0; x<arr[0].length; x++){
                    if(arr[y][x] == 0){
                        answer[0] += 1;
                    }else if(arr[y][x] == 1){
                        answer[1] += 1;
                    }
                }
            }
            return answer;
        }
        
        public void compress(int[][] arr, int len, int y, int x){
            
            if(len == 1 || isPossible(arr, len, y, x)){
                return;
            }
            
            compress(arr, len/2, y, x);
            compress(arr, len/2, y, x+len/2);
            compress(arr, len/2, y+len/2, x);
            compress(arr, len/2, y+len/2, x+len/2);
        }
        
        public boolean isPossible(int[][] arr, int len, int y, int x){
            int pattern = arr[y][x];
            for(int row=y; row<y+len; row++){
                for(int col=x; col<x+len; col++){
                    if(arr[row][col] != pattern){
                        return false;
                    }
                }
            }
            
            for(int row=y; row<y+len; row++){
                for(int col=x; col<x+len; col++){
                    arr[row][col] = -1;
                }
            }
            arr[y][x] = pattern;
            return true;
        }
    }
}
