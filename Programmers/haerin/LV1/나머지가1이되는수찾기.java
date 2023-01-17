// https://school.programmers.co.kr/learn/courses/30/lessons/87389
// title : 나머지가 1이 되는 수 찾기
// time : 1m
// type : 정수 처리
// Created by haerin on 2023/01/16
public class 나머지가1이되는수찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for(int i=2; i<n; i++) {
                if(n%i==1) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}
