// https://school.programmers.co.kr/learn/courses/30/lessons/42584
// title : 주식가격

import java.util.*;

public class 주식가격 {
    // Stack 사용
    class Solution1 {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Stack<Integer> stack = new Stack<>();
            
            for(int i=0;i<prices.length;i++) {
                // 가격이 떨어진 경우
                while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    // 초 시점 = 이전 index와 현재 index의 차이
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                
                stack.push(i);
            }
            
            // 가격이 떨어지지 않은 경우
            while(!stack.isEmpty()) {
                answer[stack.peek()] = prices.length - stack.peek() - 1;
                stack.pop();
            }
            
            return answer;
        }
    }

    // int[] 사용
    // Stack을 사용했을 때보다 훨씬 빠르다.
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            
            for(int i=0;i<prices.length;i++) {
                for(int j=i+1;j<prices.length;j++) {
                    answer[i]++;
                    
                    if(prices[i] > prices[j]) break;
                }
            }
            
            return answer;
        }
    }
}