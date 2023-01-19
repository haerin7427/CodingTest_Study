// https://school.programmers.co.kr/learn/courses/30/lessons/12935
// title : 제일 작은 수 제거하기
// time : 4m
// type : 배열
// Created by haerin on 2023-01-19
public class 제일작은수제거하기 {
    // 0.190ms
    class Solution {
        public int[] solution(int[] arr) {
            if(arr.length == 1) return new int[]{-1};
    
            int[] answer = new int[arr.length-1];
            int min = arr[0];
            for(int num : arr) {
                if(min > num) {
                    min = num;
                }
            }
            int idx=0;
            for(int num : arr) {
                if(num != min) {
                    answer[idx++] = num;
                }
            }
            return answer;
        }
    }
}
