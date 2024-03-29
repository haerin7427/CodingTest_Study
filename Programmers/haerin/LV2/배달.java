package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12978
// title : 배달
// type : 플로이드 와샬 알고리즘
// time : ..., 10m
// Created by haerin on 2023-02-24, 2023-05-01
public class 배달 {
    // 정점과 정점 사이의 최소거리 구하기
    class Solution {
        public int solution(int N, int[][] road, int K) {
            // 최대 거리인 500001로 마을 사이 거리 초기화
            int[][] distance = new int[N+1][N+1];
            for(int y=1; y<distance.length; y++){
                for(int x=1; x<distance.length; x++){
                    if(y == x){
                        continue;
                    }
                    distance[y][x] = 500001;
                }
            }
            // 최대 거리인 500001 보다 가까운 거리 재설정
            for(int[] info : road){
                if(distance[info[0]][info[1]]<info[2]){
                    continue;
                }
                distance[info[0]][info[1]] = info[2];
                distance[info[1]][info[0]] = info[2];
            }
            // 마을 사이 최소 거리 계산
            for(int i=1; i<distance.length; i++) {
                for(int y=1; y<distance.length; y++) {
                    for(int x=1; x<distance.length; x++) {
                        if(distance[y][x] > distance[y][i] + distance[i][x])
                            distance[y][x] = distance[y][i] + distance[i][x];
                    }
                }
            }
            // 마을1에서 거리가 K이하인 마을 수 구하기 (본인 마을 포함)
            int answer = 0;
            for(int i=1; i<distance[1].length; i++) {
                if(distance[1][i] <= K)
                    answer += 1;
            }
            return answer;
        }
    }
    class Solution2 {
        public int solution(int N, int[][] road, int K) {
            int[][] graph = new int[N+1][N+1];
            for(int y=1; y<=N; y++){
                for(int x=1; x<=N; x++){
                    if(x != y) graph[y][x] = 500001;
                }
            }
            for(int[] r : road){
                graph[r[0]][r[1]] = Math.min(graph[r[0]][r[1]], r[2]);
                graph[r[1]][r[0]] = Math.min(graph[r[1]][r[0]], r[2]);
            }
            for(int k=1; k<=N; k++){
                for(int y=1; y<=N; y++){
                    for(int x=1; x<=N; x++){
                        if(y == k || x == k) continue;
                        graph[y][x] = Math.min(graph[y][x], graph[y][k] + graph[k][x]);
    
                    }
                }
            }
            
            int answer = 0;
            for(int i=1; i<=N; i++){
                if(graph[1][i] <= K){
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
