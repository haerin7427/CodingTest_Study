package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/68646
// title : 풍선 터트리기
// type : DP
// time : 35m
// Created by haerin on 2023-04-02
public class 풍선터트리기 {
    class Solution {
        public int solution(int[] a) {
            int[] leftMin = new int[a.length];
            int[] rightMin = new int[a.length];
            leftMin[0] = a[0];
            for(int i=1; i<leftMin.length; i++){
                leftMin[i] = Math.min(leftMin[i-1], a[i-1]);
            }
            rightMin[rightMin.length-1] = a[a.length-1];
            for(int i=rightMin.length-2; i>=0; i--){
                rightMin[i] = Math.min(rightMin[i+1], a[i+1]);
            }
            
            int answer = 2;
            for(int i=1; i<a.length-1; i++){
                if(leftMin[i] < a[i] && rightMin[i] < a[i])
                    continue;
                answer += 1;
            }
            return answer;
        }
    }
}
