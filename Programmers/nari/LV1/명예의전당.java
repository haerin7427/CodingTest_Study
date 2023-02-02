// https://school.programmers.co.kr/learn/courses/30/lessons/138477
// title : 명예의 전당 (1)

import java.util.*;

public class 명예의전당 {
    // ArrayList 사용
    class Solution1 {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            ArrayList<Integer> list = new ArrayList<>();
            int[] top = new int[k];
            int idx = 0;
            
            for(int i=0;i<score.length;i++) {
                if(list.size() < k) list.add(score[i]);
                else {
                    Collections.sort(list);
                    if(score[i] >= list.get(0))  list.set(0, score[i]);
                }
                
                Collections.sort(list);
                answer[i] = list.get(0);
            }
            
            return answer;
        }
    }

    // PriorityQueue 사용
    class Solution2 {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            
            for(int i=0;i<score.length;i++) {
                queue.add(score[i]);
                
                // .remove() : 첫번째 값 제거. 비어있다면 예외 발생
                // .poll() : 첫번째 값을 반환하고 제거. 비어있다면 null
                if(queue.size() > k) queue.poll();

                // .element() : 첫번째 값을 반환만 하고 제거 하지는 않는다. 비어있다면 예외 발생
                // .peek() : 첫번째 값을 반환만 하고 제거하지 않는다. 비어있다면 null
                answer[i] = queue.peek();
            }
            
            return answer;
        }
    }
}