package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12946
// title : 하노이의 탑
// type : DFS
// time : 13m
// Created by haerin on 2023-02-28
import java.util.*;
public class 하노이의탑 {
    class Solution {
        public int[][] solution(int n) {
            List<int[]> list = new ArrayList<>();
            dfs(n, 1,2,3, list);
            
            int[][] answer = new int[list.size()][2];
            int idx=0;
            for(int[] ans : list){
                answer[idx++] = ans;
            }
            return answer;
        }
        
        private void dfs(int n, int start, int mid, int end, List<int[]> list){
            if(n==1){
                list.add(new int[]{start, end});
                return;
            }
            
            dfs(n-1, start, end, mid, list);
            
            list.add(new int[]{start, end});
            
            dfs(n-1, mid, start, end, list);
        }
    }
}
