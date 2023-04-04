package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/76503
// title : 모두 0으로 만들기
// type : tree dfs
// time : 50m
// Created by haerin on 2023-04-03
import java.util.*;
public class 모두영으로만들기 {
    class Solution {
        private long cnt = 0;
        private List<List<Integer>> tree;
        private boolean[] isVisited;
        private long[] weight;
        public long solution(int[] a, int[][] edges) {
            long sum = 0;
            for(int i=0; i<a.length; i++){
                sum += a[i];
            }
            if(sum != 0) return -1;
    
            isVisited = new boolean[edges.length+1];
            tree = new ArrayList<>();
            for(int i=0; i<edges.length+1; i++){
                tree.add(new ArrayList<Integer>());
            }
            for(int[] e : edges){
                tree.get(e[0]).add(e[1]);
                tree.get(e[1]).add(e[0]);
            }
            weight = new long[a.length];
            for(int i=0; i<weight.length; i++){
                weight[i] = a[i];
            }
            
            dfs(0, 0);
            return cnt;
        }
        
        public void dfs(int node, int parent){
            isVisited[node] = true;
            for(int i=0; i<tree.get(node).size(); i++){
                if(isVisited[tree.get(node).get(i)]) continue;
                dfs(tree.get(node).get(i), node);
            }
            if(weight[node] != 0){
                cnt += Math.abs(weight[node]);
                weight[parent] += weight[node];
            }
        }
    }
}
