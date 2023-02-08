package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/76502
// title : 괄호 회전하기
// type : 문자열 & Stack
// time : 21m
// Created by haerin on 2023-02-08
import java.util.*;;
public class 괄호회전하기 {
    class Solution {
        public int solution(String s) {
            LinkedList<Character> list = new LinkedList<>();
            for(char c : s.toCharArray()) {
                list.add(c);
            }
            int answer = 0;
            for(int i=0; i<s.length(); i++){
                boolean flag = true;
                Stack<Character> stack = new Stack<>();
                for(int j=0; j<list.size(); j++) {
                    if(list.get(j) == ']' || list.get(j) == ')' || list.get(j) == '}'){
                        if(stack.isEmpty()){
                            flag = false;
                            break;
                        }else if((stack.peek() == '[' && list.get(j) == ']') || (stack.peek() == '(' && list.get(j) == ')') || (stack.peek() == '{' && list.get(j) == '}')){
                            stack.pop();
                        }else {
                            flag = false;
                            break;
                        }
                    }else{
                        stack.push(list.get(j));
                    }
                }
                
                if(flag && stack.isEmpty()) {
                    answer += 1;
                }
                list.addLast(list.getFirst());
                list.removeFirst();
            }
            
            return answer;
        }
    }
    // 조건을 더 간소화함 때문에 속도는 Solution1이 더 나음
    class Solution2 {
        public int solution(String s) {
            LinkedList<Character> list = new LinkedList<>();
            for(char c : s.toCharArray()) {
                list.add(c);
            }
            
            Stack<Character> stack = new Stack<>();
            int answer = 0;
            for(int i=0; i<s.length(); i++){
                stack.clear();
                for(int j=0; j<list.size(); j++) {
                    if(stack.isEmpty()){
                        stack.push(list.get(j));
                    }else if(stack.peek() == '[' && list.get(j) == ']'){
                        stack.pop();
                    }else if(stack.peek() == '(' && list.get(j) == ')'){
                        stack.pop();
                    }else if(stack.peek() == '{' && list.get(j) == '}'){
                        stack.pop();
                    }else {
                        stack.push(list.get(j));
                    }
                }
                
                if(stack.isEmpty()) {
                    answer += 1;
                }
                list.addLast(list.getFirst());
                list.removeFirst();
            }
            
            return answer;
        }
    }
}
