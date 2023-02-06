// https://school.programmers.co.kr/learn/courses/30/lessons/42885
// title : 구명보트

import java.util.*;

public class 구명보트 {
    // 실패
    // 작은 수 먼저 태운다고 무조건 최소의 값이 나올 순 없다.
    class Solution1 {
        public int solution(int[] people, int limit) {
            int answer = 0;
            int cnt = 0;
            
            Arrays.sort(people);
            
            for(int i=0;i<people.length;i++) {
                cnt += people[i];
                
                if(cnt > limit) {
                    cnt = 0;
                    i -= 1;
                    answer++;
                }
                else if(cnt == limit) {
                    cnt = 0;
                    answer++;
                }
            }
            
            if(cnt < limit) answer++;
            else {
                cnt -= people[people.length-1];
                if(cnt > 0) answer++;
            }
            
            return answer;
        }
    }

    class Solution2 {
        public int solution(int[] people, int limit) {
            int answer = 0;
            int idx = 0;
            
            Arrays.sort(people);
            
            for(int i=people.length-1;i>=idx;i--) {
                if(people[i] + people[idx] <= limit) {
                    idx++;
                    answer++;
                }
                else answer++;
            }
            
            return answer;
        }
    }
}