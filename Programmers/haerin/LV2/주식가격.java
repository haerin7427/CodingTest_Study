package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42584
// title : 주식가격
// type : 완전탐색
// time : 10m
// Created by haerin on 2023-02-22
public class 주식가격 {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            for(int i=0; i<prices.length; i++){
                answer[i] = prices.length - i - 1;
                for(int j=i+1; j<prices.length; j++){
                    if(prices[i] > prices[j]){
                        answer[i] = j - i;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
