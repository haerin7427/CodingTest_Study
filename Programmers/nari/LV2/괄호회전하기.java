// https://school.programmers.co.kr/learn/courses/30/lessons/76502
// title : 괄호 회전하기

import java.util.*;

public class 괄호회전하기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            
            for(int i=0;i<s.length();i++) {
                // 회전하기
                StringBuilder sb = new StringBuilder(s);
                String subString = sb.substring(0, i);
                sb.delete(0,i);
                sb.append(subString);
                
                Stack<Character> stack = new Stack<>();

                for(int j=0;j<sb.length();j++) {
                    char c = sb.charAt(j);
                    
                    if(stack.size() == 0) stack.push(c);
                    else if(stack.peek() == ']' || stack.peek() == '}' || stack.peek() == ')') break;
                    else if(stack.peek() == '[' && c == ']') stack.pop();
                    else if(stack.peek() == '{' && c == '}') stack.pop();
                    else if(stack.peek() == '(' && c == ')') stack.pop();
                    else stack.push(c);
                }
                
                if(stack.isEmpty()) answer++;
            }
            
            return answer;
        }
    }
}