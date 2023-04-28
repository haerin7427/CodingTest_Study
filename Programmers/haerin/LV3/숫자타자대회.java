package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/136797
// title : 숫자 타자 대회
// type : DP
// time : 20m
// Created by haerin on 2023-04-27
import java.util.*;
public class 숫자타자대회 {
    class Solution {
        // private char[] board = new char[]{'1','2','3','4','5','6','7','8','9','*','0','#'};
        public int solution(String numbers) {        
            int answer = 0;
            int left = 3;
            int right = 5;
            for(char num : numbers.toCharArray()){
                int key = 10;
                if(num >= '1' && num <= '9'){
                    key = num - '1';
                }
                int leftW = getWeight(left, key);
                int rightW = getWeight(right, key);
                
                if(leftW < rightW){
                    left = key;
                    answer += leftW;
                }else{
                    right = key;
                    answer += rightW;
                }
                
                
            }
            
            return answer;
        }
        
        private int getWeight(int hand, int key){
            int hy = hand / 3;
            int hx = hand % 3;
            int ky = key / 3;
            int kx = key % 3;
            
            if(hx == kx && hy == ky){
                return 0;
            }else if(hx == kx){
                return Math.abs(hy-ky)*2;
            }else if(hy == ky){
                return Math.abs(hx-kx)*2;
            }else{
                int min = Math.min(Math.abs(hx-kx), Math.abs(hy-ky));
                int max = Math.min(Math.abs(hx-kx), Math.abs(hy-ky));
                return min*3 + (max-min)*2;
            }
        }
    }
    class Solution2 {
        // cost[i][j] : 번호 i에서 번호 j를 누르는 데 드는 가중치
        public int[][] cost = {
            { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
            { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
            { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
            { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
            { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
            { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
            { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
            { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
            { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
            { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
        };
    
        public int[][][] dp; //dp[ind][left][right]
        public String arr;
        public int len;
        
        public int solve(int idx, int L, int R) {
            // 모든 번호를 눌렀을 경우
            if (idx == len) {
                return 0;
            }
            if (dp[idx][L][R] != -1) return dp[idx][L][R];
            
            int num = arr.charAt(idx) - '0';
            int result = Integer.MAX_VALUE;
            
            //왼쪽 손가락으로 움직였을 경우
            if (num != R) result = Math.min(solve(idx+1, num, R) + cost[L][num], result);
            
            //오른 손가락으로 움직였을 경우
            if (num != L) result = Math.min(solve(idx+1, L, num) + cost[R][num], result);
            return dp[idx][L][R] = result;
        }
        
        public int solution(String numbers) {
            arr = numbers;
            len = numbers.length();
            //초기화 
            dp = new int[len + 1][10][10];
            for (int i = 0; i < len + 1; i++) {
                for (int j = 0; j < 10; j++)
                    Arrays.fill(dp[i][j], -1);
            }
            // 초기화 누를 번호 인덱스 0, left : 4, right 5
            return solve(0, 4, 6);
        }
    }
}
