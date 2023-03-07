package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/150369#
// title : 택배 배달과 수거하기
// type : Greedy & Stack
// time : 42m
// Created by haerin on 2023-03-07
import java.util.*;
public class 택배배달과수거하기 {
    class Solution {
        class House {
            int location;
            int box;
            
            House(int l, int b){
                this.location = l;
                this.box = b;
            }
        }
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            Stack<House> deliverStack = new Stack<>();
            Stack<House> pickUpStack = new Stack<>();
            for(int i=0; i<n; i++){
                if(deliveries[i] > 0){
                    deliverStack.push(new House(i+1, deliveries[i]));
                }
                
                if(pickups[i] > 0){
                    pickUpStack.push(new House(i+1, pickups[i]));
                }
            }
            
            long answer = 0;
            while(!deliverStack.isEmpty() || !pickUpStack.isEmpty()){
                
                int distance = 0;
                if(deliverStack.isEmpty()){
                    distance = moveBox(cap, pickUpStack);
                }else if(pickUpStack.isEmpty()){
                    distance = moveBox(cap, deliverStack);
                }else{
                    distance = Math.max(moveBox(cap, deliverStack), moveBox(cap, pickUpStack));
                }
                answer += 2 * distance;
            }
            return answer;
        }
        
        private int moveBox(int cap, Stack<House> stack) {
            int cnt = 0;
            int d = stack.peek().location;
            while(!stack.isEmpty() && stack.peek().box + cnt <= cap){
                cnt += stack.pop().box;
            }
            if(cnt < cap && !stack.isEmpty()){
                House h = stack.pop();
                h.box -= (cap - cnt);
                stack.push(h);
                cnt = cap;
            }
            return d;
        }
    }
}
