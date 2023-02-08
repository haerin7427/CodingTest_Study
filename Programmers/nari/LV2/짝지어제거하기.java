// https://school.programmers.co.kr/learn/courses/30/lessons/12973
// title : 짝지어 제거하기

import java.util.*;

public class 짝지어제거하기 {
    class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack<>();

            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                
                if(stack.size() > 0 && stack.peek() == c) stack.pop();
                else stack.push(c);
            }

            return stack.size()==0 ? 1 : 0;
        }
    }
}