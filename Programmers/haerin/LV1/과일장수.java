// https://school.programmers.co.kr/learn/courses/30/lessons/135808
// title : 과일장수
// type : 정렬
// time : 3m
// Created by haerin on 23-02-01
import java.util.*;
public class 과일장수 {
    class Solution {
        public int solution(int k, int m, int[] score) {
            Arrays.sort(score);
            int answer = 0;
            for(int i = score.length - m; i>=0; i-=m) {
                answer += score[i]*m;
            }
            return answer;
        }
    }
}
