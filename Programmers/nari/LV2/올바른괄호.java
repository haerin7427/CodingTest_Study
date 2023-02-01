// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// title : 올바른 괄호

import java.util.*;

public class 올바른괄호 {
    // ArrayList 사용
    class Solution1 {
        boolean solution(String s) {
            ArrayList<Character> list = new ArrayList<Character>();
            int idx = 0;

            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                
                if(idx != 0 && list.get(idx-1) == '(' && c == ')') {
                    list.remove(idx-1);
                    idx -= 1;
                }
                else {
                    list.add(c);
                    idx++;
                }
            }

            return list.size()==0 ? true : false;
        }
    }

    // Stack 사용 -> 1보다 느림
    // 중간 break 조건이 없으면, 시간 초과
    class Solution2 {
        boolean solution(String s) {
            boolean answer = true;
            Stack<Integer> stack = new Stack<>();

            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                
                if(c == '(') stack.push(1);
                else if(c == ')') {
                    if(stack.isEmpty()) {
                        answer = false;
                        break;
                    } 
                    else stack.pop();
                }
            }
            
            if(!stack.isEmpty()) answer = false;

            return answer;
        }
    }
}