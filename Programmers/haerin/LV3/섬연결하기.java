package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42861
// title : 섬 연결하기
// type : 최소 신장 트리 -> 크루스칼 알고리즘
// time : 30m
// Created by haerin on 2023-03-16
import java.util.*;
public class 섬연결하기 {
    class Solution {
        public int solution(int n, int[][] costs) {
            int[] group = new int[n];
            for(int i=0; i<n; i++){
                group[i] = i;
            }
            Arrays.sort(costs, (a1, a2) -> a1[2]-a2[2]);
            int answer = 0;
            
            for(int[] c : costs){
                if(group[c[0]] == group[c[1]]) continue;
                
                // int g = Math.min(group[c[0]], group[c[1]]);
                // group[c[0]] = g;
                group[c[1]] = group[c[0]];
                
                answer += c[2];
            }
            for(int i=0; i<n; i++){
                System.out.println("Group"+i+" : "+group[i]);
            }
            return answer;
        }
    }
    class Solution2 {
        public int solution(int n, int[][] costs) {
            int[] group = new int[n];
            for(int i=0; i<n; i++){
                group[i] = i;
            }
            Arrays.sort(costs, (a1, a2) -> a1[2]-a2[2]);
            int answer = 0;
            
            for(int[] c : costs){
                if(find(group, c[0]) == find(group, c[1])) continue;
                union(c[0], c[1], group);
                answer += c[2];
            }
            return answer;
        }
        public int find(int[] group, int a) {
            if (group[a] == a) return a;
            else return group[a] = find(group, group[a]);
        }
        
        public void union(int a, int b, int[] group) {
            int group_a = find(group, a);
            int group_b = find(group, b);
            if (group_a != group_b) 
                group[group_b] = group_a;
        }
    }
}
