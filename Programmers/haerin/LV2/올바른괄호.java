package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// title : 올바른 괄호
// type : 문자열 & STACK
// time : 10m
// Created by haerin on 23-02-01
import java.util.*;
public class 올바른괄호 {
    class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();
        
            for(char c : s.toCharArray()){
                if(c == '('){
                    stack.push(c);
                } else {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }

            return stack.isEmpty() ? true : false;
        }
    }
}
