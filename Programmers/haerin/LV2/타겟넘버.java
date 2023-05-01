package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
// title : 타겟 넘버
// type : DFS
// time : 23m, 7m
// Created by haerin on 2023-02-16, 2023-05-01
public class 타겟넘버 {
    class Solution {
        public int solution(int[] numbers, int target) {
            int answer = dfs(numbers, target, 0, -1);
            return answer;
        }
        
        private int dfs(int[] numbers, int target, int sum, int currIdx){
            int ans = 0;
            if(currIdx == numbers.length-1){
                if(sum == target){
                    ans += 1;
                }
            }else{
                ans += dfs(numbers, target, sum+numbers[currIdx+1], currIdx+1);
                ans += dfs(numbers, target, sum-numbers[currIdx+1], currIdx+1);
            }
            return ans;
        }
    }
    class Solution2 {
        private int answer = 0;
        private int N;
        private int T;
        private int[] nums;
        public int solution(int[] numbers, int target) {
            N = numbers.length;
            T = target;
            nums = numbers;
            dfs(0,0);
            return answer;
        }
        
        private void dfs(int idx, int num){
            if(idx == N){
                if(num == T){
                    answer += 1;
                }
                return;
            }
            dfs(idx+1, num + nums[idx]);
            dfs(idx+1, num - nums[idx]);
        }
    }
}
