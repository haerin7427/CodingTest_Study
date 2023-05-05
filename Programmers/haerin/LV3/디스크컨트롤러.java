package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42627#
// title : 디스크 컨트롤러
// type : Heap
// time : 35m, 26m
// Created by haerin on 2023-03-13, 2023-05-05
import java.util.*;
public class 디스크컨트롤러 {
    class Solution {
        public int solution(int[][] jobs) {
            // jobs 배열 요청시간 오름차순 정렬
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
            // 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            
            int idx = 0; // 작업물 인덱스
            int count = 0; // 수행한 작업 갯수
            int time = 0; // 새 작업 가능 시각
            int sum = 0;
            while(count < jobs.length){
                while (idx<jobs.length && jobs[idx][0] <= time){
                    pq.add(jobs[idx++]);
                }
    
                // 비어있다면 지금 시작 가능한 작업이 없으므로, 시간을 남은 작업물 중 제일 빠른 요청 시각으로 변경
                if(pq.isEmpty()){
                    time = jobs[idx][0];
                }else{
                    int[] tmp = pq.poll();
                    sum += (time - tmp[0]) + tmp[1];
                    time += tmp[1];
                    count++;
                }
            }
    
            return sum / jobs.length;
        }
    }
    // 0505 2차시도
    class Solution2 {
        class Work {
            int requiredTime;
            int workingTime;
            
            Work(int r, int w){
                this.requiredTime = r;
                this.workingTime = w;
            }
        }
        public int solution(int[][] jobs) {
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
            Queue<Work> queue = new LinkedList<>();
            PriorityQueue<Work> pq = new PriorityQueue<>((o1, o2) -> o1.workingTime - o2.workingTime);
            for(int[] job : jobs){
                queue.add(new Work(job[0], job[1]));
            }
            
            int time = 0;
            int sum = 0;
            int count = 0;
            int N = jobs.length;
            
            while(count < N){
                while(!queue.isEmpty() && queue.peek().requiredTime <= time){
                    pq.add(queue.poll());
                }
                
                if(pq.isEmpty() && !queue.isEmpty()){
                    time = queue.peek().requiredTime;
                }else if(!pq.isEmpty()){
                    Work work = pq.poll();
                    sum += (time - work.requiredTime) + work.workingTime;
                    time += work.workingTime;
                    count += 1;
                }
            }
            
            int answer = sum / jobs.length;
            return answer;
        }
    }
}
