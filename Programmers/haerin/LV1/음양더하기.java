// https://school.programmers.co.kr/learn/courses/30/lessons/76501
// title : 음양 더하기
// time : 2m
// type : 정수
// Created by haerin on 2023-01-20
public class 음양더하기 {
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for(int i=0; i<absolutes.length; i++){
                answer += absolutes[i] * (signs[i] ? 1 : -1);
            }
            return answer;
        }
    }
}
