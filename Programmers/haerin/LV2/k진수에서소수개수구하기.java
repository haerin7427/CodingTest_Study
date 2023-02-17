package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/92335
// title : k진수에서 소수 개수 구하기
// type : 
// time : 18m
// Created by haerin on 2023-02-17
public class k진수에서소수개수구하기 {
    class Solution {
        public int solution(int n, int k) {
            String[] str = Integer.toString(n, k).replaceAll("0"," ").split(" ");
            
            int answer = 0;
            for(String s : str){
                if(s.equals("")) continue;
                if(isPrime(Long.parseLong(s))){
                    answer += 1;
                }
            }
            return answer;
        }
        
        public boolean isPrime(long number){
            if(number == 1) return false;
            
            for(long i=2; i<=Math.sqrt(number); i++){
                if(number % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}
