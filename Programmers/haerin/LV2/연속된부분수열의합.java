package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/178870
// title : 연속된 부분 수열의 합
// type : 투 포인터
// time : 28m
// Created by haerin on 2023-04-18
public class 연속된부분수열의합 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int N = sequence.length;
            int left = 0, right = N;
            int sum = 0;
            
            for(int L=0, R=0; L < N; L++){
                while(R < N && sum < k) {
                    sum += sequence[R++];
                }
                
                if(sum == k) {
                    int range = R - L - 1;
                    if((right - left) > range) {
                        left = L;
                        right = R - 1;
                    }
                }
                
                sum -= sequence[L];
            }
            
            
            return new int[]{left, right};
        }
    }
}
