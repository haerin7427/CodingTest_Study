package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/150365
// title : 미로 탈출 명령어
// type : dfs
// time : 1h
// Created by haerin on 2023-04-11
public class 미로탈출명령어 {
    class Solution {
        int[][] d = new int[][]{{1,0},{0,-1},{0,1},{-1,0}};
        char[] direction = new char[]{'d','l','r','u'};
        String answer = new String("z");
        char[] load;
        int K;
        int R;
        int C;
        int N;
        int M;
        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            load = new char[k];
            K = k;
            R = r-1;
            C = c-1;
            N = n; 
            M = m;
            dfs(k,x-1,y-1);
            return answer.equals("z") ? "impossible" : answer;
        }
    
        public boolean dfs(int k, int r, int c){
            if(k == 0){
                if(R == r && C == c){
                    answer = new String(load);
                    return true;
                }
                return false;
            }
            
            int distance = Math.abs(R-r) + Math.abs(C-c);  
            if((distance%2) != (k%2) || (distance > k)) return false;
    
            for(int i=0; i<direction.length; i++){
                int nr = r + d[i][0];
                int nc = c + d[i][1];
    
                if(nc < 0 || nr < 0 || nc >= M || nr >= N) continue;
                load[K-k] = direction[i];
                if(dfs(k-1, nr, nc)) return true;
            }
            return false;
        }
    }
}
