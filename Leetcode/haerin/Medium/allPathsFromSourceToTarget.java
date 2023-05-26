package Leetcode.haerin.Medium;
// https://leetcode.com/problems/all-paths-from-source-to-target/description/
// title : 797. All Paths From Source to Target
// type : dfs
// time : 7m
// Created by haerin on 2023-05-26
import java.util.*;
public class allPathsFromSourceToTarget {
    class Solution {
        private int N;
        private boolean[] isVisited;
        private List<List<Integer>> answer = new ArrayList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            N = graph.length;
            isVisited = new boolean[N];
            List<List<Integer>> graphList = new ArrayList<>();
            for(int i=0; i<N; i++){
                graphList.add(new ArrayList<>());
            }
            for(int s=0; s<graph.length; s++){
                for(int e=0; e<graph[s].length; e++){
                    graphList.get(s).add(graph[s][e]);
                }
            }
            isVisited[0] = true;
            List<Integer> list = new ArrayList<>();
            list.add(0);
            search(graphList, list, 0);
            return answer;
        }
    
        private void search(List<List<Integer>> graphList, List<Integer> temp, int node){
            if(node == N-1){
                List<Integer> ans = new ArrayList<>();
                for(int num : temp){
                    ans.add(num);
                }
                answer.add(ans);
                return;
            }
            for(int i=0; i<graphList.get(node).size(); i++){
                if(isVisited[graphList.get(node).get(i)]) continue;
                isVisited[graphList.get(node).get(i)] = true;
                temp.add(graphList.get(node).get(i));
                search(graphList, temp, graphList.get(node).get(i));
                temp.remove(graphList.get(node).get(i));
                isVisited[graphList.get(node).get(i)] = false;
            }
        }
    }
}
