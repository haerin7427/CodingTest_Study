// https://school.programmers.co.kr/learn/courses/30/lessons/12912
// title : 두 정수 사이의 합

public class 두정수사이의합 {
    class Solution1 {
        public long solution(int a, int b) {
            long answer = 0;
            int min = a<b ? a : b;
            int max = a<b ? b : a;
            
            for(int i=min;i<=max;i++) {
                answer += i;
            }
            
            return answer;
        }
    }

    // 등차수열의 합 공식 -> (a1+an)/2 * n
    // 테스트 케이스의 평균 속도도 1보다 훨씬 빠르다
    class Solution2 {
        public long solution(int a, int b) {
            long min = Math.min(a, b);
            long max = Math.max(b, a);
            
            return (max - min + 1) * (min + max) / 2;
        }
    }
}