// https://school.programmers.co.kr/learn/courses/30/lessons/1838
// title : 몸짱 트레이너 라이언의 고민

// 브루트 포스(brute force) -> 발생할 수 있는 모든 경우의 수를 전부 탐색

import java.util.*;

public class 몸짱트레이너라이언의고민 {
    class Solution {
        public int solution(int n, int m, int[][] timetable) {
            // 600 <= t1 < t2 <= 1,320 -> -600해서 0 ~ 720까지
            int[] people = new int[721];
            // 모든 손님 중에서 제일 처음 입식 시간, 제일 나중 퇴실 시간
            int start = Integer.MAX_VALUE, end = 0;
            
            for(int[] t : timetable) {
                // 손님 입실 시간 ~ 퇴실 시간까지 count
                for(int i=t[0]-600;i<=t[1]-600;i++) {
                    people[i]++;
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            
            // 가장 많이 겹치는 회원 수
            int max = 0;
            
            for(int i=start;i<=end;i++) {
                max = Math.max(max, people[i]);
            }
            
            // 가장 많이 겹치는 회원 수가 1보다 작거나 같은 경우 
            // 손님 간에 이용 시간이 한 번도 겹치지 않는다고 판단
            if(max <= 1) return 0;
            
            // 락커 간 거리는 맨해튼 거리를 따르기 때문에 최대 거리는 2 * n - 2
            int maxDist = 2 * n - 2;
            
            // 손님들 사이 거리
            for(int i=maxDist;i>0;i--) {
                // 시작 좌표는 돌아가면서 확인
                for(int x=0;x<n;x++) {
                    for(int y=0;y<n;y++) {
                        ArrayList<int[]> list = new ArrayList<>();
                        
                        // 락커 배정
                        list.add(new int[]{x, y});

                        for(int x2=x;x2<n;x2++) {
                            for(int y2=0;y2<n;y2++) {
                                if(x2 == x && y2 <= y) continue;

                                // 배정된 각 락커 간의 거리가 해당 거리 이상인지 확인 -> 가능하다면 락커 배정
                                if(check(new int[]{x2, y2}, i, list)) list.add(new int[]{x2, y2});

                                // 배정된 락커 수가 가장 많이 겹치는 회원 수와 일치할 경우
                                if(list.size() == max) return i;
                            }
                        }
                    }
                }
            }
            
            return 0;
        }
        
        public boolean check(int[] cur, int maxDist, ArrayList<int[]> people) {
            for(int[] p : people) {
                // 현재 좌표 위치와 배정된 락커의 위치의 차 절댓값이 maxDist 이상인지 확인
                int dist = Math.abs(p[0] - cur[0]) + Math.abs(p[1] - cur[1]);

                if(dist < maxDist) return false;
            }

            return true;
        }
}
}