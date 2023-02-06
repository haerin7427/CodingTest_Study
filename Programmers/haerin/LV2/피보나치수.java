package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12945
// title : 피보나치 수
// type : DP
// time : 5m
// Created by haerin on 2023-02-06
public class 피보나치수 {
    class Solution {
        public int solution(int n) {
            int[] f = new int[n+1];
            f[0] = 0; f[1] = 1;
            for(int i=2; i<f.length; i++){
                f[i] = (f[i-1] + f[i-2]) % 1234567;
            }
            return f[n];
        }
    }
}
