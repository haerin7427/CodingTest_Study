package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/12979
// title : 기지국 설치
// type : 구현 (Greedy)
// time : 19m, 13m
// Created by haerin on 2023-03-24, 2023-05-11
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

    class Solution2 {
        public int solution(int n, int[] stations, int w) {
            
            int sPoint = 1;
            int answer = 0;
            for(int station : stations){
                int ePoint = station - w - 1;
                if(sPoint <= ePoint) {
                    int len = ePoint - sPoint + 1;
                    answer += len / (2*w+1);
                    if(len % (2*w+1) != 0) {
                        answer += 1;
                    }
                }
                sPoint = station + w + 1;
            }
            
            if(sPoint <= n){
                int len = n - sPoint + 1;
                answer += len / (2*w+1);
                if(len % (2*w+1) != 0) {
                    answer += 1;
                }
            }
            
            
    
            return answer;
        }
    }
}
