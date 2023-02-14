package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/84512
// title : 모음사전
// type : 완전탐색
// time : 44m
// Created by haerin on 2023-02-13
public class 모음사전 {
    class Solution {
        public int solution(String word) {
            char[] rule = new char[]{'A', 'E', 'I', 'O', 'U'};
            int answer = 0;        
            StringBuilder sb = new StringBuilder();
            
            while(!word.equals(sb.toString())){
                
                if(sb.length() < 5){
                    sb.append("A");
                }else{
                    int idx = sb.length()-1;
                    while(sb.charAt(idx) == 'U'){
                        sb.deleteCharAt(idx);
                        idx -= 1;
                        if(idx < 0) break;
                    }
                    for(int i=0; i<rule.length; i++){
                        if(rule[i] == sb.charAt(idx)){
                            sb.deleteCharAt(idx);
                            sb.append(rule[i+1]);
                            break;
                        }
                    }
                }
                answer += 1;
            }
            return answer;
        }
    }
}