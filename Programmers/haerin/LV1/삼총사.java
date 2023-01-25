// https://school.programmers.co.kr/learn/courses/30/lessons/131705
// title : 삼총사
// type : 정수
// time : 3m
// Created by haerin on 2023-01-24
public class 삼총사 {
    class Solution {
        public int solution(int[] number) {
            int answer = 0;
            for(int x=0; x<number.length-2; x++) {
                for(int y=x+1; y<number.length-1; y++) {
                    for(int z=y+1; z<number.length; z++) {
                        if(number[x] + number[y] + number[z] == 0) {
                            answer += 1;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
