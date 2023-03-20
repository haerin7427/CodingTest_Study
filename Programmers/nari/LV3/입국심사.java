// https://school.programmers.co.kr/learn/courses/30/lessons/43238
// title : 입국심사

import java.util.*;

public class 입국심사 {
    class Solution {
        public long solution(int n, int[] times) {
            long answer = Long.MAX_VALUE;
            
            Arrays.sort(times);
            
            long left = times[0];
            // 가장 오래 걸리는 시간 = n명 전원이 가장 오래 걸리는 심사대로 가는 경우
            long right = (long) n * times[times.length - 1];
            
            while(left <= right) {
                long mid = (left + right) / 2;
                // 총 심사한 인원
                long sum = 0;
                
                // 빨리 심사하는 심사관 순으로 심사처리
                for(int time : times) { 
                    sum += mid / time;
                }
                
                // 심사할 인원보다 심사처리 못함 -> 시간 더 필요
                if(sum < n) left = mid + 1;
                // 심사할 인원보다 심사처리 많이함 -> 시간을 줄여서 더 최고 경우의 시간을 만든다.
                else { 
                    right = mid - 1;
                    // 최솟값
                    answer = Math.min(answer, mid);
                }
            }
            
            return answer;
        }
    }
}