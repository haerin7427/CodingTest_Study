// https://school.programmers.co.kr/learn/courses/30/lessons/12982
// title : 예산

import java.util.*;

public class 예산 {
    class Solution1 {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);
            int answer = 1;
            int cnt = d[0];
            
            for(int i=1;i<d.length;i++) {
                if(budget <= cnt) break;
                else {
                    cnt += d[i];
                    answer++;
                }
            }
            
            return budget < cnt ? --answer : answer;
        }
    }

    class Solution2 {
        public int solution(int[] d, int budget) {
            int answer = 0;
            
            Arrays.sort(d);
            
            for (int i = 0; i < d.length; i++) {
                budget -= d[i];

                if (budget < 0) break;

                answer++;
            }

            return answer;
        }
    }
}