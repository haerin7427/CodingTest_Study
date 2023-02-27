// https://school.programmers.co.kr/learn/courses/30/lessons/131704
// title : 택배상자

import java.util.*;

public class 택배상자 {
    // Stack만 사용
    class Solution1 {
        public int solution(int[] order) {
            int answer = 0;
            // LIFO = 가장 마지막에 삽입된 자료가 가장 먼저 삭제
            Stack<Integer> stack = new Stack<>();
            int box = 1, idx = 0;
            
            while(true) {
                // 가장 마지막에 삽입된 자료가 담아야하는 order 번호일 경우
                if(!stack.isEmpty() && stack.peek() == order[idx]) {
                    answer++;
                    stack.pop();
                    idx++;
                }
                
                // break을 제일 처음 if문에 작성했더니 stack이 empty되기 전에 break;
                // 현재 box 번호가 order 보다 많아질 경우, 더이상 실을 수 없다고 판단
                else if(box > order.length) break;
                
                // 현재 box 번호가 담아야하는 order 번호일 경우
                else if(box == order[idx]) {
                    answer++;
                    box++;
                    idx++;
                }
                
                // 나머지 경우, 보조 컴테이너 벨트에 보관
                else stack.push(box++);
            }
            
            return answer;
        }
    }

    // Stack과 Queue 사용
    class Solution2 {
        public int solution(int[] order) {
            // 보조 컨테이너 벨트
            Stack<Integer> stack = new Stack<>();
            // 트럭
            Queue<Integer> queue = new LinkedList<>();
            int idx = 0;
            
            for(int i=1;i<=order.length;i++) {
                stack.add(i);

                while(!stack.isEmpty()) {
                    if(stack.peek() == order[idx]) {
                        queue.offer(stack.pop());
                        idx++;
                    }
                    else break;
                }
            }
            
            return queue.size();
        }
    }
}