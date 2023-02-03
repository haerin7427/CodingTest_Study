package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
// title : 카펫
// type : 완전탐색
// time : 8m
// Created by haerin on 2023-02-03
public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            for(int i=1; i<= Math.sqrt(yellow); i++){
                if(yellow % i != 0) continue;
                
                int yellowHeight = i;
                int yellowWidth = yellow / yellowHeight;
                
                if((yellowWidth+2) * (yellowHeight+2) - yellow == brown) {
                    answer[0] = yellowWidth+2;
                    answer[1] = yellowHeight+2;
                }
            }
            return answer;
        }
    }
}
