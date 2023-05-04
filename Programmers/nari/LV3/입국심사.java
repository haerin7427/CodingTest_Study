// https://school.programmers.co.kr/learn/courses/30/lessons/43238
// title : 입국심사

import java.util.*;

public class 입국심사 {
    class Solution1 {
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

    // right 생성할 때, n 앞에 (long) type 변환 안해주면 에러
    class Solution2 {
        public long solution(int n, int[] times) {
            // 모든 사람이 심사를 받는데 걸리는 시간의 최솟값
            long answer = Long.MAX_VALUE;
            int len = times.length;
            
            Arrays.sort(times);
            // 1명의 제일 적은 시간 ~ n명의 제일 많은 시간 = 모든 경우의 시간
            long left = times[0], right = (long) n * times[len-1];
            
            while(left <= right) {
                long mid = (left + right) / 2;
                long people = 0;
                
                // 중간 시간동안 해당 심사관이 몇명을 심사할 수 있는지
                for(int t : times) {
                    people += mid / t;
                }
                
                // 모든 심사관들이 심사할 수 있는 사람의 수가 기다리는 사람보다 적을 경우 -> 시간 증가
                if(people < n) left = mid + 1;
                else {
                    // 같거나 큰 경우 -> 시간 감소
                    right = mid - 1;
                    answer = Math.min(answer, mid);
                }
            }
            
            return answer;
        }
    }
}