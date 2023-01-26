// https://school.programmers.co.kr/learn/courses/30/lessons/68935
// title : 3진법 뒤집기

public class 3진법뒤집기 {
    // 테스트 케이스 10개 기준 평균 속도 0.06ms
    class Solution1 {
        public int solution(int n) {
            // 3진수 변환
            String str = Integer.toString(n, 3);
            
            StringBuilder sb = new StringBuilder();
            
            for(int i=str.length()-1;i>=0;i--) {
                sb.append(str.charAt(i));
            }
            
            int answer = Integer.parseInt(sb.toString(), 3);
            
            return answer;
        }
    }

    // 테스트 케이스 10개 기준 평균 속도 0.06ms
    class Solution2 {
        public int solution(int n) {
            // 3진수 변환
            String str = Integer.toString(n, 3);

            return Integer.parseInt(new StringBuilder(str).reverse().toString(), 3);
        }
    }

    // 테스트 케이스 10개 기준 평균 속도 0.04ms
    class Solution3 {
        public int solution(int n) {
            StringBuilder sb = new StringBuilder();
            
            // 3진수 변환
            while(n > 0){
                sb.append(n % 3);
                n /= 3;
            }

            return Integer.parseInt(sb.toString(), 3);
        }
    }
}