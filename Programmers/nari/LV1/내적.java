// https://school.programmers.co.kr/learn/courses/30/lessons/70128
// title : 내적

import java.util.stream.IntStream;

public class 내적 {
    // 테스트 케이스 9개 기준 평균 속도 0.03ms
    class Solution1 {
        public int solution(int[] a, int[] b) {
            int answer = 0;
            
            for(int i=0;i<a.length;i++) {
                answer += a[i] * b[i];
            }
            
            return answer;
        }
    }

    // 테스트 케이스 9개 기준 평균 속도 2.45ms
    class Solution2 {
        public int solution(int[] a, int[] b) {
            return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
        }
    }
}