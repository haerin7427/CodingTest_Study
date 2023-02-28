package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/148653
// title : 마법의 엘리베이터
// type : 구현
// time : 57m
// Created by haerin on 2023-02-28
public class 마법의엘리베이터 {
    // 실패 -> 5일 때 경우의 수를 생각하지 못함
    class Solution {
        public int solution(int storey) {
            int answer = 0;
            int p = Integer.toString(storey).length()-1;
            int move = storey;
            
            while(move != 0){
                int r = (int)(Math.abs(move) % Math.pow(10,p));
                
                if(r > Math.pow(10,p)/2){
                    answer += Math.abs(move) / Math.pow(10,p) + 1;
                    move = (int)Math.abs(Math.pow(10,p) - r);
                }else{
                    answer += Math.abs(move) / Math.pow(10,p);
                    move = r;
                }
                System.out.println(answer);
                p -= 1;
            }
            return answer;
        }
    }
    // 통과
    class Solution2 {
        public int solution(int storey) {
            int answer = 0;
            char[] arr = Integer.toString(storey).toCharArray();
            
            while(storey > 0){
                int r = storey % 10;
                
                if(r > 5){
                    storey = (int)Math.ceil(storey*0.1);
                    answer += 10 - r;
                }else if(r < 5){
                    storey /= 10;
                    answer += r;
                }else{
                    if(storey >= 10 && storey % 100 >= 50){
                        storey = (int)Math.ceil(storey*0.1);
                        answer += 10 - r;
                    }else{
                        storey /= 10;
                        answer += r;
                    }
                }
            }
    
            return answer;
        }
    }
}
