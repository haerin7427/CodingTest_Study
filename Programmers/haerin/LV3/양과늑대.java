package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/92343
// title : 양과 늑대
// type : DFS
// time : 22m, 30m
// Created by haerin on 2023-03-28, 2023-03-30
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
    class Solution2 {
        private int maxSheep=0; // 양의 최대 개수
        public int solution(int[] info, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
            for(int i=0; i<info.length; i++){
                graph.add(new ArrayList<>()); // 노드별 자식노드 리스트
            }
            for(int[] e : edges){
                graph.get(e[0]).add(e[1]);
            }
            
            List<Integer> visitList = new ArrayList<>();
            visitList.add(0); // 시작하는 루트 노드는 항상 0
            dfs(0, 0, 0, graph, visitList, info);
            return maxSheep;
        }
        
        private void dfs(int idx, int sheepCnt, int wolfCnt, List<List<Integer>> graph, List<Integer> visitList, int[] info){
            if(info[idx] == 0){
                sheepCnt += 1; // 양 카운트
            }else{
                wolfCnt += 1; // 늑대 카운트
            }
            if(sheepCnt <= wolfCnt){ // 이 경우, 양이 모두 잡아먹히므로 제외해야하는 경우의 수 
                return;
            }
            maxSheep = Math.max(maxSheep, sheepCnt);
            
            List<Integer> next = new ArrayList<>(); // 여기서 새로 리스트를 생성하지 않으면 메모리를 공유 하므로 이전 dfs에 영향을 줌
            next.addAll(visitList); // 앞 선 리스트 복사 -> 부모 노드를 통해 되돌아 가는 경우도 카운트 해야하므로
            if(graph.get(idx).size() > 0){
                next.addAll(graph.get(idx)); // 이동할 수 있는 자식 노드 추가
            }
            next.remove(Integer.valueOf(idx)); // 자기 자신은 제외
            
            for(int n : next){
                dfs(n, sheepCnt, wolfCnt, graph, next, info);
            }
            
        }
    }
}
