// https://school.programmers.co.kr/learn/courses/30/lessons/42884
// title : 단속카메라

import java.util.*;

public class 단속카메라 {
    class Solution {
        public int solution(int[][] routes) {
            int answer = 0;
            // 차량이 고속도로에서 나간 지점 
            int spot = Integer.MIN_VALUE;
            
            // 차량이 고속도로에서 나간 지점을 기준으로 오름차순 정렬
            Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
            
            for(int[] route : routes) {
                // "현재 차량 진입 지점"이 "이전 차량 진출 지점"을 지나친 이후인 경우
                if(spot < route[0]) {
                    // 지점 이동
                    spot = route[1];
                    answer++;
                }
            }
            
            return answer;
        }
    }
}