package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/133500
// title : 등대
// type : dfs
// time : 20m
// Created by haerin on 2023-04-28
import java.util.*;
public class 등대 {
    class Solution {
        private int N; // 전체 노드 수
        private int result = 0; // 켜 놓을 등대 수
        public List<List<Integer>> tree = new ArrayList<>(); // 등대 사이에 뱃길 정보를 입력한 자료구조
        public int solution(int n, int[][] lighthouse) {
            N = n;
            for(int i = 0; i <= N; i++){
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < lighthouse.length; i++) {
                tree.get(lighthouse[i][0]).add(lighthouse[i][1]);
                tree.get(lighthouse[i][1]).add(lighthouse[i][0]);
            }
            dfs(1, 0);
            return result;
        }

        // return 1 : 불을 켜지 않음, return 0 : 불을 켬
        private int dfs(int cur, int before){
            // 리프 노드일 경우
            if (tree.get(cur).size() == 1 && tree.get(cur).get(0) == before){
                return 1;
            }
            
            // 리프 노드가 아닐 경우
            int childTotal = 0;
            for(int i=0; i<tree.get(cur).size(); i++){
                if(before == tree.get(cur).get(i)) continue;
                childTotal += dfs(tree.get(cur).get(i), cur);
            }
            
            
            if(childTotal == 0) {
                // 자식 노드에 불이 모두 켜져 있으므로 불을 킬 필요 없음
                return 1;
            }else{
                // 해당 노드가 불을 켜야 함
                result += 1;
                return 0;
            }
        }
    }
}
