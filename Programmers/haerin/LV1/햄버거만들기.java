// https://school.programmers.co.kr/learn/courses/30/lessons/133502
// title : 햄버거 만들기
// type : 
// time : help
// Created by haerin on 2023-01-31
import java.util.*;
public class 햄버거만들기 {
    class Solution {
        public int solution(int[] ingredient) {
            Stack<Integer> stack = new Stack<>();
            int answer = 0;
            for(int food : ingredient) {
                if(food == 1 && stack.size() >= 3 && stack.lastIndexOf(3) == stack.size()-1 && stack.lastIndexOf(2) == stack.size()-2 && stack.lastIndexOf(1) == stack.size()-3){
                    answer+=1;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }else {
                    stack.push(food);
                }
            }
            return answer;
        }
    }
    class Solution2 {
        public int solution(int[] ingredient) {
            int[] stack = new int[ingredient.length];
            int sp = 0;
            int answer = 0;
            for (int i : ingredient) {
                stack[sp++] = i;
                if (sp >= 4 && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1) {
                    sp -= 4;
                    answer++;
                }
            }
            return answer;
        }
    }
}
