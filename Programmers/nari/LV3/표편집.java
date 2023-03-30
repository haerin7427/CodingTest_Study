// https://school.programmers.co.kr/learn/courses/30/lessons/81303
// title : 표 편집

import java.util.*;

public class 표편집 {
    class Solution {
        public String solution(int n, int k, String[] cmd) {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            // 현재 표의 행 개수
            int size = n;
            
            for(String c : cmd) {
                switch(c.charAt(0)) {
                    case 'U':
                        // 위에 있는 행
                        k -= Integer.valueOf(c.substring(2));
                        break;
                    case 'D':
                        // 아래에 있는 행
                        k += Integer.valueOf(c.substring(2));
                        break;
                    case 'C':
                        stack.push(k);
                        size--;
                        // 삭제된 행이 가장 마지막 행인 경우, 바로 윗 행 선택
                        if(k == size) k--;
                        break;
                    case 'Z':
                        int val = stack.pop();
                        // 현재 선택된 행의 위치보다 복구된 행의 위치가 작은 경우, 현재 행의 위치 +1
                        if(val <= k) k++;
                        size++;
                        break;
                }
            }
            
            for(int i=0;i<size;i++) {
                sb.append('O');
            }
            
            while(!stack.isEmpty()) {
                sb.insert(stack.pop().intValue(), 'X');
            }
            
            return sb.toString();
        }
    }
}