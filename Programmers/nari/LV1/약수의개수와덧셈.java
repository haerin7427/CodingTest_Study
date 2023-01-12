// https://school.programmers.co.kr/learn/courses/30/lessons/77884
// title : 약수의 개수와 덧셈

public class 약수의개수와덧셈 {
    // 테스트 케이스 7개 기준 평균 속도 0.23ms
    class Solution1 {
        public int solution(int left, int right) {
            int answer = 0;
            
            for(int i=left;i<=right;i++) {
                int divisors = 0;
                
                for(int j=1;j<=Math.sqrt(i);j++){
                    if(i % j == 0) {
                        divisors++;
                        if(i / j != j) divisors++;
                    }
                }
                
                if(divisors % 2 == 0) answer += i;
                else answer -= i;
            }
            
            return answer;
        }
    }

    // 테스트 케이스 7개 기준 평균 속도 0.07ms
    class Solution2 {
        public int solution(int left, int right) {
            int answer = 0;
            
            for(int i=left;i<=right;i++) {
                // 제곱수인 경우 약수의 개수가 홀수
                if (i % Math.sqrt(i) == 0) answer -= i;
                // 제곱수가 아닌 경우 약수의 개수가 짝수
                else answer += i;
            }
            
            return answer;
        }
    }
}