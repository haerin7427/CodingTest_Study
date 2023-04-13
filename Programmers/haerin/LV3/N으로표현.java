package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42895
// title : N으로표현
// type : DFS
// time : 25m
// Creatd by haerin on 2023-04-13
public class N으로표현 {
    class Solution {
        private int min = Integer.MAX_VALUE;
        
        public int solution(int N, int number) {
            dfs(0, N, number, 0);
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        // depth : N 사용횟수, current : 현재 숫자
        public void dfs(int depth, int N, int number, int current) {
            if (depth > 8) { // 문제 제한 사항 : 최대 사용 횟수 = 8
                return;
            }
            
            if (number == current) {
                min = Math.min(depth, min);
                return;
            }
            
            int temp = 0;
                
            for (int i = 0; i < 8; i++) {
                if (depth + i < 8) {
                    temp = temp * 10 + N; // N, NN, NNN 등 반복문을 통해 사용

                    // 사칙 연산을 통해 모든 케이스 확인
                    dfs(depth + i + 1, N, number, current + temp);
                    dfs(depth + i + 1, N, number, current - temp);
                    dfs(depth + i + 1, N, number, current / temp);
                    dfs(depth + i + 1, N, number, current * temp);     
                }      
            }
        }
    }
}
