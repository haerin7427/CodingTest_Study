package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/181187#
// title : 두 원 사이의 정수 쌍
// type : 수학
// time : 15m
// Created by haerin on 2023-04-19
public class 두원사이의정수쌍 {
    class Solution {
        public long solution(int r1, int r2) {
            long answer = (r2 - r1 + 1) * 4;
            long oneAns = 0;
            
            for(int x = 1; x < r2; x++){
                // y^2 = r^2 - x^2
                long powY = (long)r1*r1 - (long)x*x;
                long minY = (long) Math.sqrt(powY);
                if(powY != minY*minY){
                    minY += 1;
                }
                
                if(minY == 0){
                    minY += 1;
                }
                
                long maxY = (long)Math.sqrt((long)r2*r2 - (long)x*x);
                oneAns += (maxY-minY+1);
            }
            return answer + oneAns * 4;
        }
    }
}
