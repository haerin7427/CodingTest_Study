// https://school.programmers.co.kr/learn/courses/30/lessons/42587
// title : 프린터

import java.util.*;

public class 프린터 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            // 높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            // 낮은 숫자가 우선 순위일 경우
            // PriorityQueue<Integer> queue = new PriorityQueue<>();
            
            // add() / offer() 둘다 사용 가능
            for(int i : priorities) {
                queue.add(i);
            }
            
            // 우선순위 큐가 비워질 때까지 반복
            while(!queue.isEmpty()){
                for(int i=0;i<priorities.length;i++){
                    if(queue.peek() == priorities[i] ){
                        queue.poll();
                        answer++;
                        
                        if(location == i) return answer;
                    }
                }   
            }
            
            return answer;
        }
    }
}