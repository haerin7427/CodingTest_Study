package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/87391
// title : 공 이동 시뮬레이션
// type : 구현
// Created by haerin on 2023-04-21
public class 공이동시뮬레이션 {
    // 시간초과
    class Solution {
        int[][] d = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int N, M, X, Y;
        public long solution(int n, int m, int x, int y, int[][] queries) {
            N = n;
            M = m;
            X = y;
            Y = x;
            
            long answer = 0;
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    if(isCorrect(r,c,queries)){
                        answer += 1;
                    }
                }
            }
            return answer;
        }
        
        private boolean isCorrect(int startY, int startX, int[][] queries){
            int cx = startX;
            int cy = startY;
            for(int[] query : queries){
                cy += d[query[0]][0] * query[1];
                cx += d[query[0]][1] * query[1];
                
                if(cy >= N) {
                    cy = N-1;
                }else if(cy < 0) {
                    cy = 0;
                }
                if(cx >= M) {
                    cx = M-1;
                }else if(cx < 0) {
                    cx = 0;
                }
            }
            
            return cy == Y && cx == X ? true : false;
        }
    }
    // 통과
    class Solution2 {
        class Range {
            long start;
            long end;
            Range (int s, int e){
                this.start = s;
                this.end = e;
            }
        }
        public long solution(int n, int m, int x, int y, int[][] queries) {
            // 쿼리를 도착지에서 부터 반대로 시작하며
            // 가능한 범위를 설정한다.

            Range row = new Range(x, x);
            Range col = new Range(y, y);
            
            for(int i=queries.length-1; i>=0; i--){
                int direction = queries[i][0];
                int distance = queries[i][1];
                
                if(direction == 0){
                    if(col.start > 0){
                        col.start += distance;
                    }
                    col.end = Math.min(m-1, col.end+distance);
                }else if(direction == 1){
                    if(col.end < m-1){
                        col.end -= distance;
                    }
                    col.start = Math.max(0, col.start-distance);
                    
                }else if(direction == 2){
                    if(row.start > 0){
                        row.start += distance;
                    }
                    row.end = Math.min(n-1, row.end+distance);
                }else{
                    if(row.end < n-1){
                        row.end -= distance;
                    }
                    row.start = Math.max(0, row.start-distance);
                }
                
                if(row.start>=n || row.end<0 || col.start>=m || col.end<0) return 0;
            }
            return (row.end - row.start + 1) * (col.end - col.start + 1);
        }
    }
}
