// https://school.programmers.co.kr/learn/courses/30/lessons/42627
// title : 디스크 컨트롤러

import java.util.*;

public class 디스크컨트롤러 {
    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0, idx = 0;
            // 수행되고난 직후의 시간
            int end = 0;
            // 수행된 작업 갯수
            int count = 0; 
            
            // 작업이 요청되는 시간 기준으로 오름차순 정렬
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
            
            // 작업의 소요시간 기준으로 오름차순 정렬되는 우선순위 큐
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            
            while(count < jobs.length) {
                // 하나의 작업이 처리되는 시점(end)까지 들어온 모든 작업의 요청을 판단
                while(idx < jobs.length && jobs[idx][0] <= end) {
                    queue.add(jobs[idx++]);
                }
                
                // 큐가 비어있는 경우, 작업 처리(end) 이후에 다시 요청이 들어온다는 의미
                if(queue.isEmpty()) end = jobs[idx][0];
                
                // 작업 처리 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
                else {
                    int[] temp = queue.poll();
                    answer += temp[1] + end - temp[0];
                    end += temp[1];
                    count++;
                }
            }
            
            return answer/jobs.length;
        }
    }

    class Solution2 {
        public int solution(int[][] jobs) {
            int answer = 0;
            int len = jobs.length;
            int cnt = 0, idx = 0, time = 0;
            
            // 0번(요청 시점)을 기준으로 정해진 시간 안에 존재하는 경우, 모두 queue에 담기
            // 정해진 시간 = 1번(소요시간) 누적 값
            // queue에 담기면 1번을 기준으로 정렬
            // queue에 담긴 값 poll하면서 걸린 시간 answer에 더하기
            
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            
            while(cnt < len) {
                while(idx < len && jobs[idx][0] <= time) {
                    queue.add(jobs[idx++]);
                }
                
                if(queue.isEmpty()) time = jobs[idx][0];
                else {
                    int[] work = queue.poll();
                    answer += work[1] + time - work[0];
                    time += work[1];
                    cnt++;
                }
            }
            
            // 평균 시간 구하기
            return answer/len;
        }
    }
}