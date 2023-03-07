package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12952
// title : N-Queen
// type : 백트랙킹
// time : 23m
// Created by haerin on 2023-03-07
public class NQueen {
    class Solution {
        private int count = 0;
    
        public int solution(int n) {
            int[] map = new int[n]; // 배열의 인덱스는 퀸이 놓인 체스판 행, 배열의 값은 체스판 열
            backtracking(n, 0, map);
            return count;
        }
    
        public void backtracking(int n, int rowIndex, int[] map) {
            if (n == rowIndex) {
                count++;
            } else {
                for (int i = 0; i < n; i++) {
                    map[rowIndex] = i;
                    if (check(map, rowIndex)) backtracking(n, rowIndex + 1, map);
                }
            }
        }
    
        public boolean check(int[] map, int rowIndex) {
            for (int i = 0; i < rowIndex; i++) {
                if (map[i] == map[rowIndex]) return false;
                if (Math.abs(map[i] - map[rowIndex]) == Math.abs(i - rowIndex)) return false;
            }
    
            return true;
        }
    }
}
