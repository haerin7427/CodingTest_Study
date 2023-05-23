package Leetcode.haerin.Easy;
// https://leetcode.com/problems/divisor-game/description/
// title : 1025. Divisor Game
// type : Greedy
// time : 7m
// Created by haerin on 23-05-23
public class divisorGame {
    class Solution {
        public boolean divisorGame(int n) {
            boolean isAlice = true;
            while(true){
                boolean flag = false;
    
                for(int x=1; x<n; x++){
                    if(n % x == 0){
                        flag = true;
                        n -= x;
                        break;
                    }
                }
    
                if(!flag){
                    if(isAlice) return false; 
                    break;
                }
    
                isAlice = isAlice ? false : true;
                
            }
            return true;
        }
    }
}
