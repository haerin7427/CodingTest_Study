package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/142085
// title : 디펜스 게임
// type : PriorityQueue
// time : 41m
// Created by haerin on 2023-03-08
import java.util.*;
public class 디펜스게임 {
    // 시간 초과 발생
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            Stack<Integer> enemyStack = new Stack<>();
            for(int i=enemy.length-1; i>=0; i--){
                enemyStack.push(enemy[i]);
            }
            int answer = dfs(enemyStack, k, 1, n);
            return answer;
        }
        
        private int dfs(Stack<Integer> stack, int k, int round, int n){
            // 더 이상 게임 진행이 불가능 한 경우 : 1. 모든 라운드 막아냄, 2.현재 라운드 막기 불가
            if(stack.isEmpty() || (n < stack.peek() && k == 0)){
                return round-1;
            }
            
            // 현재 라운드 막기 가능
            int nowEnemy = stack.pop();
            int ans = round;
            // 이번 라운드를 막기 위해 병사를 소모한 경우
            if(n >= nowEnemy){
                ans = Math.max(ans, dfs(stack, k, round+1, n-nowEnemy));
            }
            // 이번 라운드를 막기 위해 무적권을 사용한 경우
            if(k > 0){
                ans = Math.max(ans, dfs(stack, k-1, round+1, n));
            }    
            stack.push(nowEnemy);  
            return ans;
        }
    }
    // 통과!
    class Solution2 {
        public int solution(int n, int k, int[] enemy) {
            int answer = enemy.length;
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
            int myTeam = n;
            int card = k;
            for(int i=0; i<enemy.length; i++){
                myTeam -= enemy[i];
                pq.add(enemy[i]);
                
                while(myTeam < 0 && card > 0 && !pq.isEmpty()){
                    myTeam += pq.poll();
                    card -= 1;
                }
                
                if(myTeam < 0){
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}