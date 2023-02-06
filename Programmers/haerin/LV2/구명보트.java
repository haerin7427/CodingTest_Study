package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42885
// title : 구명보트
// type : Greedy
// time : 4m
// Created by haerin on 2023-02-06
import java.util.*;
public class 구명보트 {
    class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            int answer = 0;
            int maxI = people.length-1, minI = 0;
            while(minI < maxI) {
                if(people[minI] + people[maxI] <= limit) {
                    minI += 1;
                }
                maxI -= 1;
                answer += 1;
            }
            if(minI == maxI) answer += 1;
            return answer;
        }
    }
}
