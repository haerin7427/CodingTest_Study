package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/43238
// title : 입국심사
// type : 이분탐색
// time : 14m
// Created by haerin on 2023-03-21
import java.util.*;
public class 입국심사 {
    class Solution {
        public long solution(int n, int[] times) {
            Arrays.sort(times);
            long answer = 0;
            long left = times[0]; // 심사를 진행하는 데 가장 적은 시간(분)
            long right = (long) n * times[times.length - 1]; // 최악의 시간(분)
            while(left <= right){
                long mid = (left + right) / 2; // 중간 시간
                long sum = 0;
                for(int time : times){
                    sum += mid/time; // 중간시간을 기준으로 각 심사관이 심사할 수 있는 사람의 수의 합
                }
    
                if(sum >= n){ // n명 이상이 심사받을 수 있는 경우 -> 시간 줄이기
                    right = mid-1;
                    answer = mid;
                }else{ // n명이 심사 받지 못하는 경우 -> 시간 필요
                    left = mid+1;
                }
            }
            return answer;
        }
    }
}
