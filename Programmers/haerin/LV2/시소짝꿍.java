package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/152996
// title : 시소 짝꿍
// type : 완전탐색
// time : 20m
// Created by haerin on 2023-03-07
import java.util.*;
public class 시소짝꿍 {
    class Solution {
        public long solution(int[] weights) {
            Arrays.sort(weights);
            long answer = 0;
            int cnt = 0;
            for(int i=0; i<weights.length-1; i++){
                if(i>0 && weights[i] == weights[i-1]){
                    answer += (--cnt);
                    continue;
                }
                cnt = 0;
                for(int j=i+1; j<weights.length; j++){
                    if(weights[i] == weights[j] || 4*weights[i] == 2*weights[j] || 3*weights[i] == 2*weights[j] || 4*weights[i] == 3*weights[j]){
                        cnt += 1;
                    }
                }
                answer += cnt;
            }
            return answer;
        }
    }
}
