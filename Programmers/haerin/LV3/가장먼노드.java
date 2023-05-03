package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/49189
// title : 가장 먼 노드
// type : bfs
// time : 21m, 20m
// Created by haerin on 2023-03-16, 2023-05-02
import java.util.*;
public class 가장먼노드 {
    class Solution {
        public int solution(int n, int[][] edge) {
            int[] distance = new int[n+1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++)
                graph.add(new ArrayList<>());
            for (int i = 0; i < edge.length; i++) {
                graph.get(edge[i][0]).add(edge[i][1]);
                graph.get(edge[i][1]).add(edge[i][0]);
            }
            boolean[] isVisited = new boolean[n+1];
            isVisited[1] = true;
            Queue<Integer> bfs = new LinkedList<>();
            bfs.add(1);
            while (bfs.size() != 0) { 
                int nowNode = bfs.poll();
                ArrayList<Integer> node = graph.get(nowNode);
                for(int i = 0; i < node.size(); i++) {
                    if (isVisited[node.get(i)] == false) {
                        bfs.add(node.get(i));
                        isVisited[node.get(i)] = true;
                        distance[node.get(i)] = distance[nowNode] + 1; 
                    }      
                }  
            }
            int max = distance[1];
            for(int d : distance){
                if(max < d)
                    max = d;
            }
            
            int answer = 0;
            for(int d : distance){
                if(max ==  d)
                    answer += 1;
            }
            return answer;
        }
    }
    // 2차 시도
    class Solution2 {
        class Node {
            int num;
            int distance;
            Node(int n, int d){
                this.num = n;
                this.distance = d;
            }
        }
        public int solution(int n, int[][] edge) {
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0; i<=n; i++){
                list.add(new ArrayList<>());
            }
            for(int[] e : edge){
                int n1 = e[0];
                int n2 = e[1];
                list.get(n1).add(n2);
                list.get(n2).add(n1);
            }
            
            int[] distance = new int[n+1];
            int max = move(list, distance);
            int cnt = 0;
            for(int a : distance){
                if(a == max){
                    cnt += 1;
                }
            }
            return cnt;
        }
        
        public int move(List<List<Integer>> list, int[] distance){
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, 0));
            
            boolean[] visited = new boolean[list.size()];
            visited[1] = true;
            int max = 0;
            while(!queue.isEmpty()){
                Node now = queue.poll();
                
                for(int i=0; i<list.get(now.num).size(); i++){
                    if(visited[list.get(now.num).get(i)]) continue;
                    max = Math.max(max, now.distance+1);
                    visited[list.get(now.num).get(i)] = true;
                    distance[list.get(now.num).get(i)] = now.distance+1;
                    queue.add(new Node(list.get(now.num).get(i), now.distance+1));
                }
            }
            return max;
        }
    }
}
