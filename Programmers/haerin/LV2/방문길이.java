package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/49994
// title : 방문 길이
// type : ...
// time : 31m
// Created by haerin on 2023-02-11
import java.util.*;
public class 방문길이 {
    class Solution {
        public int solution(String dirs) {
            int[] now = new int[]{0,0}; // (y,x) 좌표
            Set<String> checkSet = new HashSet<>();
            for(char direction : dirs.toCharArray()){
                int[] next = new int[]{now[0], now[1]};
                if(direction == 'U'){
                    next[0] += 1;
                }else if(direction == 'D'){
                    next[0] -= 1;
                }else if(direction == 'R'){
                    next[1] += 1;
                }else{
                    next[1] -= 1;
                }
                
                if(Math.abs(next[0]) > 5 || Math.abs(next[1]) > 5) continue;
                
                
                if(direction == 'U' || direction == 'D'){
                    String s = Math.min(now[0], next[0])+","+ now[1]+","+ Math.max(now[0], next[0])+","+now[1];
                    checkSet.add(s);
                }else{
                    String s = now[0]+ ","+Math.min(now[1], next[1])+","+ now[0]+","+ Math.max(now[1], next[1]);
                    checkSet.add(s);
                }
                now[0] = next[0];
                now[1] = next[1];
            }
            return checkSet.size();
        }
    }
}
