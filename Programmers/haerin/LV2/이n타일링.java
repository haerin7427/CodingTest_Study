package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12900
// title : 2*n 타일링
// type : DP
// time : 10m
// Created by haerin on 2023-02-14
public class 이n타일링 {
    class Solution {
        public int solution(int n) {
            if(n == 1) return 1;
            if(n == 2) return 2;
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 2;
            for(int i=2; i<n; i++){
                long sum = (long)arr[i-1] + arr[i-2];
                arr[i] = (int) (sum % 1000000007);
            }
            int answer = arr[n-1];
            return answer;
        }
    }
}
