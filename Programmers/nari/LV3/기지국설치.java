// https://school.programmers.co.kr/learn/courses/30/lessons/12979
// title : 기지국 설치

public class 기지국설치 {
    class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            // 현재 아파트 위치
            int location = 1;
            // stations 인덱스
            int idx = 0;
            
            // location은 현재 아파트 위치기 때문에 n개를 넘을 수 없음
            while(location <= n) {
                // 설치된 기지국 전부를 지나지 않았고,
                // 현재 아파트 위치가 설치된 기지국의 범위 사이에 존재할 경우
                if(idx < stations.length && stations[idx]-w <= location && location <= stations[idx]+w) {
                    // 설치된 기지국의 범위보다 +1 위치로 이동
                    location = stations[idx] + w + 1;
                    idx++;
                }
                else {
                    // w - location - w
                    location += 2 * w + 1;
                    // 기지국 설치
                    answer++;
                }
            }

            return answer;
        }
    }
}