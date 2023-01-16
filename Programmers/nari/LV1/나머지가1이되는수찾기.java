// https://school.programmers.co.kr/learn/courses/30/lessons/87389
// title : 나머지가 1이 되는 수 찾기

public class 나머지가1이되는수찾기 {
    // 테스트 1 〉 9.49ms
    // 테스트 케이스 10개 기준 평균 속도 0.02ms (테스트 1 제외)
    class Solution {
        public int solution(int n) {
            int answer = 0;
            
            for(int i=2;i<=n;i++) {
                if(n%i == 1) {
                    answer = i;
                    break;
                }
            }
            
            return answer;
        }
    }
}