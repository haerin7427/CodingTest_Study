package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/49189
// title : 가장 먼 노드
// type : bfs
// time : 21m
// Created by haerin on 2023-03-16
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
}
