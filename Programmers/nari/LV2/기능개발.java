// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// title : 기능개발

import java.util.*;

public class 기능개발 {
    // Queue 활용
    class Solution1 {
        public int[] solution(int[] progresses, int[] speeds) {
            // 자바에서 Queue는 LinkedList를 활용하여 생성
            Queue<Integer> queue = new LinkedList<>();
            
            for(int i=0;i<progresses.length;i++) {
                int day = 0;
                int progress = progresses[i];
                
                while(progress < 100) {
                    progress += speeds[i];
                    day++;
                }
                
                queue.add(day);
            }
            
            ArrayList<Integer> list = new ArrayList<>();
            int maxDay = queue.poll();
            int cnt = 1;
            
            while(queue.size() != 0) {
                if(queue.peek() > maxDay) {
                    list.add(cnt);
                    maxDay = queue.poll();
                    cnt = 1;
                }
                else {
                    queue.poll();
                    cnt++;
                }
            }
            list.add(cnt);
            
            int[] answer = new int[list.size()];
            
            for(int i=0;i<list.size();i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    // "작업의 개수는 100개 이하" 라는 조건을 이용해서 배열 활용
    class Solution2 {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] temp = new int[100];
            int day = -1;
            
            for(int i = 0; i < progresses.length; i++){
                while(progresses[i] + (speeds[i] * day) < 100){
                    day++;
                }
                temp[day]++;
            }
            int cnt = 0;
            
            for(int n : temp){
                if(n != 0) cnt++;
            }
            
            int[] answer = new int[cnt];
            
            cnt = 0;
            for(int n : temp){
                if(n != 0) answer[cnt++] = n;
            }
            
            return answer;
        }
    }
}