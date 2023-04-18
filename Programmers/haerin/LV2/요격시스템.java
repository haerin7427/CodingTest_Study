package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/181188
// title : 요격 시스템
// type : 정렬
// time : 13m
// Created by haerin on 2023-04-18
import java.util.*;
public class 요격시스템 {
    class Solution {
        public int solution(int[][] targets) {
            // 폭격 미사일 종료지점 기준으로 오름차순 정렬, 종료 지점이 동일한 경우 시작 지점 오름차순 정렬
            Arrays.sort(targets, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[1] != b[1]){
                        return a[1] - b[1];
                    }else {
                        return a[0] - b[0];
                    }
                } 
            });

            // 요격 미사일 발사 횟수
            int answer = 0;
            for(int i=0; i<targets.length; i++){
                // 요격 미사일 발사 지점
                double point = targets[i][1] - 0.5;
                answer += 1;
                
                // 요격 미사일 영향을 받는 다른 폭격 미사일 조사
                while(i< targets.length-1 && point > targets[i+1][0]){
                    i += 1;
                }
            }
            return answer;
        }
    }
}
