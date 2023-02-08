package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12953
// title : N개의 최소공배수
// type : 정수
// time : 9m
// Created by haerin on 2023-02-08
public class N개의최소공배수 {
    class Solution {
        public int solution(int[] arr) {
            int max = arr[0];
            for(int n : arr) {
                if(max < n) {
                    max = n;
                }
            }
            
            int answer = -1;
            int num = max;
            while(answer < 0) {
                Boolean flag = true;
                for(int n : arr) {
                    if(num % n != 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    answer = num;
                }
                num += 1;
            }
            return answer;
        }
    }
}
