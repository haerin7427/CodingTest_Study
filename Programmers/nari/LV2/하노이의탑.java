// https://school.programmers.co.kr/learn/courses/30/lessons/12946
// title : 하노이의 탑

import java.util.*;

public class 하노이의탑 {
    class Solution {
        ArrayList<int[]> list = new ArrayList<>();
        
        public int[][] solution(int n) {
            hanoi(n, 1, 3, 2);
            
            int[][] answer = new int[list.size()][2];
            
            for(int i=0;i<list.size();i++) {
                int[] h = list.get(i);
                
                answer[i][0] = h[0];
                answer[i][1] = h[1];  
            }

            return answer;
        }
        
        void hanoi(int n, int start, int end, int path) {
            int[] move = {start, end};
            
            if(n == 1) list.add(move);
            else {
                // 가장 큰 원판을 제외한 나머지 2번으로 이동
                hanoi(n-1, start, path, end);
                // 가장 큰 원판을 1번에서 3번으로 이동
                list.add(move);
                // n-1 하노이의 탑을 다시 반복
                hanoi(n-1, path, end, start);
            }
        }
    }
}