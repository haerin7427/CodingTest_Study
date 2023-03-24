package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12979
// title : 기지국 설치
// type : 구현
// time : 19m
// Created by haerin on 2023-03-24
public class 기지국설치 {
    class Solution {
        public int solution(int n, int[] stations, int w) {
            int sum = 0;
            int range = 1 + 2*w;
            int startPoint = 1;
            int endPoint = 0;
            for(int station : stations){
                endPoint = station - w -1;
                
                if(startPoint <= endPoint){
                    int len = endPoint - startPoint + 1;
                    
                    sum += len / range;
                    if(len % range != 0){
                        sum += 1;
                    }
                }
                startPoint = station + w + 1;
            }
            
            endPoint = n;
            if(startPoint <= endPoint){
                int len = endPoint - startPoint + 1;
    
                sum += len / range;
                if(len % range != 0){
                    sum += 1;
                }
            }
    
            return sum;
        }
    }
}
