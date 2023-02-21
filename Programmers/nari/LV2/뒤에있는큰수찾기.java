// https://school.programmers.co.kr/learn/courses/30/lessons/154539
// title : 뒤에 있는 큰 수 찾기
// 주식가격.java 문제와 매우 흡사

import java.util.*;

public class 뒤에있는큰수찾기 {
    // int[] 사용
    // 테스트 케이스 20~23 시간 초과
    class Solution1 {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            boolean check = false;
            
            for(int i=0;i<numbers.length;i++) {
                for(int j=i+1;j<numbers.length;j++) {
                    if(numbers[i] < numbers[j]) {
                        answer[i] = numbers[j];
                        check = true;
                        break;
                    }
                }
                
                if(check) check = false;
                else answer[i] = -1;
            }
            
            return answer;
        }
    }

    // Stack 사용
    class Solution2 {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>();
            
            for(int i=0;i<numbers.length;i++) {
                // 현재 숫자가 이전 숫자보다 클 경우
                while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                    answer[stack.pop()] = numbers[i];
                }
                
                // stack에 index 저장
                stack.push(i);
            }
            
            while(!stack.isEmpty()) {
                answer[stack.pop()] = -1;
            }
            
            return answer;
        }
    }
}