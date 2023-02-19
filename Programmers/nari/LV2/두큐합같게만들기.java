// https://school.programmers.co.kr/learn/courses/30/lessons/118667
// title : 두 큐 합 같게 만들기

import java.util.*;

public class 두큐합같게만들기 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            long sum1 = 0, sum2 = 0;
            
            // queue1과 queue2의 길이는 같다.
            for(int i=0;i<queue1.length;i++){
                sum1 += queue1[i];
                sum2 += queue2[i];

                q1.add(queue1[i]);
                q2.add(queue2[i]);
            }
            
            // 두 개의 큐 중 합계 낮은 쪽에 더해주는 방식의 그리디 알고리즘
            while(sum1 != sum2) {
                answer++;

                if(sum1 > sum2) {
                    sum1 -= q1.peek();
                    sum2 += q1.peek();
                    q2.add(q1.poll());
                } 
                else {
                    sum1 += q2.peek();
                    sum2 -= q2.peek();
                    q1.offer(q2.poll());
                }

                // 두 개의 큐를 전부 돌았는데도 해결되지 않는 경우
                if(answer > (queue1.length + queue2.length) * 2) return -1;
            }
            
            return answer;
        }
    }
}