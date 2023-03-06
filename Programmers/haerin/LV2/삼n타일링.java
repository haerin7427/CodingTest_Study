package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12902#
// title : 3 * n 타일링
// type : ...
// time : 20m
// Created by haerin on 2023-03-06
public class 삼n타일링 {
    class Solution {
        // f(n)= f(n-2)*4 - f(n-4)
        // 모듈러 분배법칙 : (A-B)%M = {(A%M) - (B%M) + M} % M
        public int solution(int n) {
            long[] num = new long[n+1];
            int mod = 1000000007;
            num[0] = 1;
            num[2] = 3;
            for(int i=4; i<=n; i++){
                num[i] = (4*num[i-2]%mod - num[i-4]%mod + mod) % mod;
            }
            return (int)num[n];
        }
    }
    
}
