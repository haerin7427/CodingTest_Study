// https://school.programmers.co.kr/learn/courses/30/lessons/17678
// title : [1차] 셔틀버스

import java.util.*;

public class 셔틀버스 {
    class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            // 크루가 대기열에 도착하는 시각
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            
            // 크루가 대기열에 도착하는 시각을 분 단위로 변환
            for(String time : timetable) {
                String[] times = time.split(":");
                int hour = Integer.parseInt(times[0]) * 60;
                int minute = Integer.parseInt(times[1]);

                queue.add(hour + minute);
            }
            
            // 셔틀 운행 시작 시간, 콘이 탈 수 있는 시간 
            int start = 9 * 60, corn = 0;
            // 셔틀에 탄 크루 인원
            int total = 0;
            
            for(int i=0;i<n;i++) {
                total = 0;    
                
                while(!queue.isEmpty()) {
                    int current = queue.peek();
                    
                    // 출발 시간보다 작고, 최대 탈 수 있는 인원보다 작을 경우
                    if(current <= start && total < m) {
                        queue.poll();
                        total++;
                        // 현재 크루보다 1분 먼저 도착하는 것
                        // == 가장 마지막으로 도착해서 해당 버스에 탈 수 있는 시간
                        corn = current - 1;
                    } 
                    else break;
                }
                
                // 셔틀 운행 -> 운행 간격만큼 더해주기
                start += t;
            }
            
            // 마지막 셔틀 버스에 탄 인원이 m보다 작은 경우,
            // 해당 셔틀 버스에 콘이 탈 수 있기 때문에 for문 마지막에 더해준 t를 빼준다.
            if(total < m) corn = start - t;
            
            String hour = String.format("%02d", corn / 60);
            String minute = String.format("%02d", corn % 60);
            
            return hour + ":" + minute;
        }
    }
}