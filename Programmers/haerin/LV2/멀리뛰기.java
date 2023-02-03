package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12914
// title : 멀리 뛰기
// type : DP
// time : 16m
// Created by haerin on 2023-02-03
public class 멀리뛰기 {
    class Solution {
        public long solution(int n) {
            long[] arr = new long[n];
            arr[0] = 1;
            if(n>1) arr[1] = 2;
            
            for(int i=2; i<n; i++) {
                arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
            }
            return arr[n-1] ;
        }
    }
}
