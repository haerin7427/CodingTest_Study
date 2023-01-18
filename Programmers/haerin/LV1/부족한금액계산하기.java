// https://school.programmers.co.kr/learn/courses/30/lessons/82612
// title : 부족한 금액 계산하기
// time : 11m
// type : long 타입 계산
// Created by haerin on 2023/01/17
public class 부족한금액계산하기 {
    class Solution {
        public long solution(int price, int money, int count) {
            // 첫째항 a부터 n항까지 등차가 d인 등차수열의 함 구하기 n{2a + (n-1)d}/2
            long fare = (long)count * (2*price + price*(count-1)) / 2;
            long answer = fare <= money ? 0 : fare - money;
    
            return answer;
        }
    }
}
