// https://school.programmers.co.kr/learn/courses/30/lessons/134240
// title : 푸드 파이터 대회
// type : 문자열
// time : 4m
// Created by haerin on 2023-01-30
public class 푸드파이터대회 {
    class Solution {
        public String solution(int[] food) {
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<food.length; i++){
                // int result = food[i] / 2;
                // sb.append(String.valueOf(i).repeat(result));
                for(int j=0; j<food[i]/2; j++){
                    sb.append(i);
                }
            }
            String answer = sb.toString()+"0"+sb.reverse().toString();
            return answer;
        }
    }
}
