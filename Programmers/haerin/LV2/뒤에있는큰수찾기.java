package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/154539
// title : 뒤에 있는 큰 수 찾기
// type : Stack
// time : 26m
// Created by haerin on 2023-02-21
import java.util.*;
public class 뒤에있는큰수찾기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> s = new Stack<>();
            
            answer[numbers.length-1] = -1;
            s.push(numbers[numbers.length-1]);
            
            for(int i=numbers.length-2; i>=0; i--){
                boolean flag = true;
                while(numbers[i] >= s.peek()){
                    s.pop();
                    if(s.empty()){
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                    answer[i] = s.peek();
                }else{
                    answer[i] = -1;
                }
                s.push(numbers[i]);
            }
            return answer;
        }
    }
}
