// https://school.programmers.co.kr/learn/courses/30/lessons/42628
// title : 이중우선순위큐

import java.util.*;

public class 이중우선순위큐 {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            // 오름차순
            PriorityQueue<Integer> ascQueue = new PriorityQueue<>();
            // 내림차순
            PriorityQueue<Integer> descQueue = new PriorityQueue<>(Collections.reverseOrder());
            
            for(String operation : operations) {
                String[] oper = operation.split(" ");
                String op = oper[0];
                int value = Integer.parseInt(oper[1]);
                
                // queue가 비었는데 데이터 삭제 요청할 경우, 무시
                if(ascQueue.size() < 1 && op.equals("D")) continue;
                
                // 삽입 경우
                if(op.equals("I")) {
                    ascQueue.add(value);
                    descQueue.add(value);
                }
                // 최댓값 삭제 경우, 두 개의 큐에서 모두 삭제
                else if(value == 1) {
                    int val = descQueue.poll();
                    ascQueue.remove(val);
                }
                // 최솟값 삭제 경우, 두 개의 큐에서 모두 삭제
                else {
                    int val = ascQueue.poll();
                    descQueue.remove(val);
                }
            }
            
            // 최댓값, 최솟값이 존재하는 경우
            if(ascQueue.size() > 0) {
                answer[0] = descQueue.poll();
                answer[1] = ascQueue.poll();
            }
            
            return answer;
        }
    }
}