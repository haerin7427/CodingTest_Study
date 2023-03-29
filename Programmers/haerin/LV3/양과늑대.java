package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/92343
// title : 양과 늑대
// type : DFS
// time : 22m
// Created by haerin on 2023-03-28
import java.util.*;
public class 양과늑대 {
    class Solution {
        private int cntSheep;
        public int solution(int[] info, int[][] edges) {
            Map<Integer, List<Integer>> nodes = new HashMap<>();
            for(int[] e : edges){
                if(!nodes.containsKey(e[0])){
                    nodes.put(e[0], new ArrayList<>());
                }
                nodes.get(e[0]).add(e[1]);
            }
            List<Integer> list = new ArrayList<>();
            list.add(0); // 루트 노드는 항상 0
            dfs(0,0,0,list,info,nodes);
            return cntSheep;
        }
        public void dfs(int idx, int s, int w, List<Integer> list, int[] info, Map<Integer, List<Integer>> nodes) {
            if(info[idx]==0) {
                s+=1;
            }else {
                w+=1;
            }
            if(s<=w) return;
            
            cntSheep = Math.max(cntSheep, s);
            
            List<Integer> next = new ArrayList<>();
            next.addAll(list);
            if(nodes.containsKey(idx)) {
                next.addAll(nodes.get(idx));
            }
            next.remove(Integer.valueOf(idx));
            
            for(int n : next) {
                dfs(n, s, w, next, info, nodes);
            }
        }
    }
}
