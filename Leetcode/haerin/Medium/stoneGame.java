package Leetcode.haerin.Medium;
// https://leetcode.com/problems/stone-game/description/
// title : 877. Stone Game
// type : Greedy
// time : 6m
// Created by haerin on 2023-06-09
import java.util.*;
public class stoneGame {
    class Solution {
        public boolean stoneGame(int[] piles) {
            List<Integer> list = new LinkedList<>();
            for(int i=0; i<piles.length; i++){
                list.add(piles[i]);
            }
            int[] sum = new int[2]; // 0: alice, 1: bob
            int flag = 0;
            while(list.size() != 0) {
                if(list.get(0) < list.get(list.size()-1)){
                    sum[flag] += list.get(list.size()-1);
                    list.remove(list.size()-1);
                } else {
                    sum[flag] += list.get(0); 
                    list.remove(0);  
                }
            }
            return sum[0] > sum[1] ? true : false;
        }
    }
}
