package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/154540
// title : 무인도 여행
// type : dfs
// time : 25m
// Created by haerin on 2023-02-27
import java.util.*;
public class 무인도여행 {
    class Solution {
        public int[] solution(String[] maps) {
            int[][] board = changeToIntBoard(maps);
            boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
            List<Integer> ans = new ArrayList<>();
            
            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[0].length; x++){
                    if(board[y][x]>0 && !isVisited[y][x]){
                        List<Integer> list = new ArrayList<>();
                        dfs(board, isVisited, y, x, list);
                        
                        int sum = 0;
                        for(int num : list){
                            sum += num;
                        }
                        ans.add(sum);
                    }
                }
            }
            
            if(ans.size() == 0){
                return new int[]{-1};
            }
            
            Collections.sort(ans);
            int[] answer = new int[ans.size()];
            int idx=0;
            for(int n : ans){
                answer[idx++] = n;
            }
            return answer;

        }
        
        private void dfs(int[][] board, boolean[][] isVisited, int y, int x, List<Integer> list){
            list.add(board[y][x]);
            isVisited[y][x] = true;
            
            int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
            for(int i=0; i<d.length; i++){
                int ny = y+d[i][0];
                int nx = x+d[i][1];
                if(ny >= board.length || ny < 0 || nx >= board[0].length || nx < 0) continue;
                if(board[ny][nx] < 1 || isVisited[ny][nx]) continue;
                
                dfs(board, isVisited, ny, nx, list);
            }
            
            
        }
        
        private int[][] changeToIntBoard(String[] maps){
            int[][] board = new int[maps.length][maps[0].length()];
            for(int y=0; y<maps.length; y++){
                char[] arr = maps[y].toCharArray();
                for(int x=0; x<arr.length; x++){
                    if(maps[y].charAt(x) == 'X'){
                        board[y][x] = -1;
                    }else {
                        board[y][x] = maps[y].charAt(x) - '0';
                    }
                }
            }
            return board;
        }
    }
    // 지나간 숫자 저장하는 list 없이 합 계산
    class Solution2 {
        public int[] solution(String[] maps) {
            int[][] board = changeToIntBoard(maps);
            boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
            List<Integer> ans = new ArrayList<>();
            
            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[0].length; x++){
                    if(board[y][x]>0 && !isVisited[y][x]){                    
                        int sum = dfs(board, isVisited, y, x);
                        ans.add(sum);
                    }
                }
            }
            
            if(ans.size() == 0){
                return new int[]{-1};
            }
            
            Collections.sort(ans);
            int[] answer = new int[ans.size()];
            int idx=0;
            for(int n : ans){
                answer[idx++] = n;
            }
            return answer;
    
        }
        
        private int dfs(int[][] board, boolean[][] isVisited, int y, int x){
            isVisited[y][x] = true;
            int ans = board[y][x];
            
            int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
            for(int i=0; i<d.length; i++){
                int ny = y+d[i][0];
                int nx = x+d[i][1];
                if(ny >= board.length || ny < 0 || nx >= board[0].length || nx < 0) continue;
                if(board[ny][nx] < 1 || isVisited[ny][nx]) continue;
                
                ans += dfs(board, isVisited, ny, nx);
            }
            return ans;
        }
        
        private int[][] changeToIntBoard(String[] maps){
            int[][] board = new int[maps.length][maps[0].length()];
            for(int y=0; y<maps.length; y++){
                char[] arr = maps[y].toCharArray();
                for(int x=0; x<arr.length; x++){
                    if(maps[y].charAt(x) == 'X'){
                        board[y][x] = -1;
                    }else {
                        board[y][x] = maps[y].charAt(x) - '0';
                    }
                }
            }
            return board;
        }
    }
}
