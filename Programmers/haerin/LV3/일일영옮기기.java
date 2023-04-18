package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/77886
// title : 110 옮기기
// type : 구현
// time : 34m
// Created by haerin on 2023-04-13
import java.util.*;
public class 일일영옮기기 {
    class Solution {
        public String[] solution(String[] s) {
            String[] answer = new String[s.length];
            for(int i=0; i<s.length; i++){
                Stack<Character> stack = new Stack<>();

                // Step 1 : "110" 문자열 개수 찾기
                int cnt110 = count110(s[i], stack);
                if(cnt110 < 1){
                    answer[i] = s[i];
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                boolean isLastZero = true;
                
                // Stack을 사용해서 문자열 뒤에서 부터 StringBuilder에 넣기
                // 처음 나오는 0 (실제 문자열에서는 마지막에 나오는 0) 이후에 "011" 넣기
                while(!stack.isEmpty()){
                    if(stack.peek() == '1' || !isLastZero){
                        sb.append(stack.pop());
                    }else{
                        for(int j=0; j<cnt110; j++){
                            sb.append("011");
                        }
                        sb.append(stack.pop());
                        isLastZero = false;
                    }
                }
                
                if(isLastZero){
                    for(int j=0; j<cnt110; j++){
                        sb.append("011");
                    }
                }
                answer[i] = sb.reverse().toString();
            }
            
            return answer;
        }
        
        public int count110(String str, Stack<Character> stack){
            int cnt110 = 0;
            for(int i=0; i<str.length(); i++){
                stack.push(str.charAt(i));
    
                if(stack.size() < 3) continue;
    
                char first = stack.pop();
                if(first != '0'){
                    stack.push(first);
                    continue;
                }
                char second = stack.pop();
                if(second != '1'){
                    stack.push(second);
                    stack.push(first);
                    continue;
                }
                char third = stack.pop();
                if(third != '1'){
                    stack.push(third);
                    stack.push(second);
                    stack.push(first);
                    continue;
                }
                cnt110 += 1;
            }
            return cnt110;
        }
    }
}
