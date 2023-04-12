package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/118669
// title : 등산코스 정하기
// type : 다익스트라(dijkstra)
// time : 45m
// Created by haerin on 2023-04-12
import java.util.*;
public class 등산코스정하기 {
    class Solution {
        private class Node{
            int num;
            int weight;
            
            Node(int n, int w){
                this.num = n;
                this.weight = w;
            }
        }
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            List<List<Node>> graph = new ArrayList<>();
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<Node>());
            }
            for(int[] path : paths){
                int n1 = path[0];
                int n2 = path[1];
                int w = path[2];
                
                // 출입구 지점 또는 산봉우리 일 경우 단일 방향
                if(isOneWayNode(n1, gates) || isOneWayNode(n2, summits)){
                    graph.get(n1).add(new Node(n2, w));
                }else if(isOneWayNode(n2, gates) || isOneWayNode(n1, summits)){
                    graph.get(n2).add(new Node(n1, w));
                }else{
                    graph.get(n1).add(new Node(n2, w));
                    graph.get(n2).add(new Node(n1, w));
                }
            }
            
            return dijkstra(n, gates, summits, graph);
        }
        
        private int[] dijkstra(int n, int[] gates, int[] summits, List<List<Node>> graph){
            Queue<Node> queue = new LinkedList<>();
            int[] intensity = new int[n+1]; // 각 지점까지 intensity
            
            Arrays.fill(intensity, Integer.MAX_VALUE);
            
            for(int gate : gates){
                queue.add(new Node(gate, 0));
                intensity[gate] = 0;
            }
            
            while(!queue.isEmpty()){
                Node now = queue.poll();
                
                // 현재의 가중치가 저장되어 있는 가중치보다 클 경우 PASS
                // if(now.weight > intensity[now.num]) continue;
                
                for(int i=0; i<graph.get(now.num).size(); i++){
                    Node linkNode = graph.get(now.num).get(i);
                    
                    // now 노드까지의 intensity 보다 이웃한 노드의 weight가 더 클 경우 UPDATE
                    int dis = Math.max(intensity[now.num], linkNode.weight);
                    // intensity가 최소가 되도록 UPDATE
                    if (intensity[linkNode.num] > dis) {
                        intensity[linkNode.num] = dis;
                        queue.add(new Node(linkNode.num, dis));
                    }
                }
            }
            int mn = Integer.MAX_VALUE; // 산봉우리 번호
            int mw = Integer.MAX_VALUE; // 최솟값
            
            Arrays.sort(summits);
    
            for (int summit : summits) {
                if (intensity[summit] < mw) {
                    mn = summit;
                    mw = intensity[summit];
                }
            }
    
            return new int[]{mn, mw};
        }
        
        private boolean isOneWayNode(int node, int[] arr){
            for(int i=0; i<arr.length; i++){
                if(arr[i] == node){
                    return true;
                }
            }
            return false;
        }
    }
}
