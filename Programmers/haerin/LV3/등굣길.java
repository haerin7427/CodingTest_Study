package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42898
// title : 등굣길
// type : DP
// time : 20m, 15m
// Created by haerin on 2023-03-16, 2023-05-11
public class 등굣길 {
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int mod = 1000000007;
            int[][] map = new int[n+1][m+1];
            for(int[] p : puddles){
                map[p[1]][p[0]] = -1;
            }
            map[1][1] = 1;
            
            for(int y=1; y<=n; y++){
                for(int x=1; x<=m; x++){
                    if(map[y][x] == -1) continue;
                    if(map[y - 1][x] > 0) map[y][x] += map[y - 1][x] % mod;
                    if(map[y][x - 1] > 0) map[y][x] += map[y][x - 1] % mod;
                }
            }
            
            return map[n][m] % mod;
        }
    }
    // 2차시도 : 2023-05-11
    class Solution2 {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n+1][m+1];
            for(int[] p : puddles){
                dp[p[1]][p[0]] = -1;
            }
            for(int y=1; y<=n; y++){
                for(int x=1; x<=m; x++){
                    if(y == 1 && x == 1){
                        dp[y][x] = 1;
                    }else if(dp[y][x] == -1){
                        dp[y][x] = 0;
                    }else{
                        dp[y][x] = (dp[y-1][x] + dp[y][x-1]) % 1000000007;
                    }
                }
            }
            return dp[n][m];
        }
    }
}
