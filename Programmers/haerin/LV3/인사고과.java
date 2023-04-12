package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/152995
// title : 인사고과
// type : 구현
// time : 24m
// Created by haerin on 2023-04-11
import java.util.*;
public class 인사고과 {
    class Solution {
        public int solution(int[][] scores) {
            int[] wanHo = scores[0];
            // 근무 태도 점수 기준 내림차순, 동일할 경우 동료 평가 점수로 오름차순
            Arrays.sort(scores, (a,b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            List<int[]> rankList = new ArrayList<>();
            int maxWorkerScore = 0; // 최대 동료 평가 점수
            for(int[] score : scores){
                // 동료 평가 점수가 나보다 높은 사람이 있으면 탈락 대상
                if(score[1] < maxWorkerScore){
                    if(wanHo.equals(score))
                        return -1;
                }else{
                    rankList.add(score);
                    maxWorkerScore = Math.max(maxWorkerScore, score[1]);
                }
            }
            
            int rank=0;
            Collections.sort(rankList, (a,b) -> (b[0]+b[1])-(a[0]+a[1]));
            for(int[] s : rankList){
                rank += 1;
                if(s.equals(wanHo)){
                    break;
                }
            }
            return rank;
        }
    }
}
