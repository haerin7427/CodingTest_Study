// https://school.programmers.co.kr/learn/courses/30/lessons/12922
// title : 수박수박수박수박수박수?

public class 수박수박수박수박수박수 {
    // 테스트 케이스 16개 기준 평균 속도 5.64ms
    class Solution1 {
        public String solution(int n) {
            String answer = "";
            
            for(int i=0;i<n/2;i++) {
                answer += "수박";
            }
            
            if(n%2 != 0) answer += "수";
            
            return answer;
        }
    }

    // 테스트 케이스 16개 기준 평균 속도 1.43ms
    class Solution2 {
        public String solution(int n) {
            return "수박".repeat(n/2) + (n%2 != 0 ? "수" : "");
        }
    }
}