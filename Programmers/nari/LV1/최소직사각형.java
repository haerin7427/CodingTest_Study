// https://school.programmers.co.kr/learn/courses/30/lessons/86491
// title : 최소직사각형

import java.util.*;

public class 최소직사각형 {
    class Solution1 {
        public int solution(int[][] sizes) {
            int[] max = new int[sizes.length];
            int[] min = new int[sizes.length];
            
            for(int i=0;i<sizes.length;i++) {
                if(sizes[i][0] > sizes[i][1]) {
                    max[i] = sizes[i][0];
                    min[i] = sizes[i][1];
                }
                else {
                    max[i] = sizes[i][1];
                    min[i] = sizes[i][0];
                }
            }
            
            Arrays.sort(max);
            Arrays.sort(min);
            
            return max[max.length-1] * min[min.length-1];
        }
    }

    // 1보다 훨씬 빠름
    class Solution2 {
        public int solution(int[][] sizes) {
            int max = 0, min = 0;
            
            for(int[] s : sizes) {
                max = Math.max(max, Math.max(s[0], s[1]));
                min = Math.max(min, Math.min(s[0], s[1]));
            }
            
            return max * min;
        }
    }
}