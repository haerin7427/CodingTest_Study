// https://school.programmers.co.kr/learn/courses/30/lessons/86051
// title : 없는 숫자 더하기
// time : 1m
// type : 정수 계산
// Created by haerin on 2023-01-23
public class 없는숫자더하기 {
    class Solution {
        public int solution(int[] numbers) {
            int answer = 45;
            for(int num : numbers) {
                answer -= num;
            }
            return answer;
        }
    }
}
