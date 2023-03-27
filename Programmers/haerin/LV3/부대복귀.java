package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/132266
// title : 부대복귀
// type : 다익스트라
// time : 24m
// Created by haerin on 2023-03-27
import java.util.*;
public class 부대복귀 {
    // 플로이드-워셜 알고리즘
    class Solution {
        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[][] board = new int[n][n];
            for(int y=0; y<n; y++){
                Arrays.fill(board[y], Integer.MAX_VALUE);
            }
            for(int[] r : roads){
                board[r[0]-1][r[1]-1] = 1;
                board[r[1]-1][r[0]-1] = 1;
            }
            for(int i=0; i<n; i++){
                board[i][i] = 0;
            }
            for(int k =0; k<n; k++){
                for(int y=0; y<n; y++){
                    for(int x=y; x<n; x++){
                        if(board[y][k] != Integer.MAX_VALUE && board[k][x] != Integer.MAX_VALUE){
                            board[y][x] = Math.min(board[y][x], board[y][k] + board[k][x]);
                            board[x][y] = Math.min(board[y][x], board[y][k] + board[k][x]);
                        }
                            
                    }
                }
            }
            
            int[] answer = new int[sources.length];
            int idx = 0;
            for(int source : sources){
                if(board[source-1][destination-1] == Integer.MAX_VALUE){
                    answer[idx] = -1;
                }else{
                    answer[idx] = board[source-1][destination-1];
                }
                idx += 1;
            }
            return answer;
        }
    }
    // 다익스트라
    class Solution2 {
        private List<List<Integer>> graph;
        private int[] dis;
        private  int MAX = Integer.MAX_VALUE;
    
        public  int[] solution(int n, int[][] roads, int[] sources, int destination) {
    
            graph = new ArrayList<>();
            for(int i=0; i<n+1; i++) graph.add(new ArrayList<>());
    
            for (int[] road : roads) {
                int s = road[0];
                int e = road[1];
    
                graph.get(s).add(e);
                graph.get(e).add(s);
            }
    
            dis = new int[n+1];
            Arrays.fill(dis, MAX);
            dijkstra(destination);
    
            int[] ans = new int[sources.length];
            for (int i = 0; i < sources.length; i++) {
                ans[i] = (dis[sources[i]] < MAX) ? dis[sources[i]] : -1;
            }
            return ans;
        }
    
        private  void dijkstra(int destination) {
            Queue<Integer> qu = new LinkedList<>();
            qu.add(destination);
            dis[destination] = 0;
    
            while (!qu.isEmpty()){
                int cn = qu.poll();
    
                for(int i=0; i<graph.get(cn).size(); i++){
                    int nn = graph.get(cn).get(i);
                    if(dis[nn] > dis[cn]+1){
                        dis[nn] = dis[cn]+1;
                        qu.add(nn);
                    }
                }
            }
        }
    }
}
