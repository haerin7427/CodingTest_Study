package Leetcode.haerin.Easy;
import java.util.*;
// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
// title : 1614. Maximum Nesting Depth of the Parentheses
// time : 5m
// type : Stack
// created by haerin on 2023-06-27
public class maximumNestingDepthOfTheParentheses {
    class Solution {
        public int maxDepth(String s) {
            System.out.println(s);
            int answer = 0;
            int depth = 0;
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '('){
                    depth += 1;
                    answer = Math.max(answer,depth);
                    stack.add('(');
                }else if(s.charAt(i) == ')') {
                    while(stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                    depth -= 1;
                }else {
                    stack.add(s.charAt(i));
                }
            }
            return answer;
        }
    }
}
