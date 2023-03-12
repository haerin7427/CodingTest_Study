package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/72413
// title : 합승 택시 요금
// type : 플로이드-워셜 알고리즘
// time : 40m
// Created by haerin on 2023-03-12
import java.util.*;
public class 합승택시요금 {
    class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
           int[][] map = new int[n+1][n+1];
            
            for (int i = 0; i <= n; i++) {
                Arrays.fill(map[i], 20000001); // 200 * 100000 + 1
                map[i][i] = 0;
            }
            
            for(int[] f : fares){
                map[f[0]][f[1]] = f[2];
                map[f[1]][f[0]] = f[2];
            }
            
            for(int r=1; r<=n; r++){
                for(int y=1; y<=n; y++){
                    for(int x=1; x<=n; x++){
                        map[y][x] = Math.min(map[y][x], map[y][r] + map[r][x]);
                    }
                }
            }
    
            int answer = map[s][a] + map[s][b];
            for(int r=1; r<=n; r++){
                if(s == r) continue;
                answer = Math.min(answer, map[s][r] + map[r][a] + map[r][b]);
            }
            return answer;
        }
    }
}
