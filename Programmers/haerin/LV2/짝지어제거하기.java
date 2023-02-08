package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12973
// title : 짝지어 제거하기
// type : Stack
// time : 20m
// Created by haerin on 2023-02-08
import java.util.*;
public class 짝지어제거하기 {
    // 정확성 테스트 통과, 효율성 테스트 시간초과로 실패
    class Solution {
        public int solution(String s)
        {
            List<Character> list = new ArrayList<>();
            for(char c : s.toCharArray()){
                list.add(c);
            }
            
            int idx = 1;
            while(idx<list.size()){
                if(idx >0 && list.get(idx) == list.get(idx-1)){
                    list.remove(idx);
                    list.remove(idx-1);
                    idx -= 2;
                }
                idx += 1;
            }
            return list.size()==0 ? 1 : 0;
        }
    }
    class Solution2 {
        public int solution(String s)
        {
            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()) {
                if(stack.isEmpty()) {
                    stack.push(c);
                }else if(stack.peek() == c){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            return stack.isEmpty() ? 1 : 0;
        }
    }
}
