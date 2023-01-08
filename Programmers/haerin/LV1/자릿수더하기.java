// https://school.programmers.co.kr/learn/courses/30/lessons/12931
// title : 자릿수더하기
// time : 2m
public class 자릿수더하기 {
    // 평균적으로 solution2가 속도가 빠름, 동일 테스트 케이스 기준 solution : 평균 0.03ms 이상, solution2 : 평균 약 0.02ms
    public class Solution {
        public int solution(int n) {
            int answer = 0;
    
            String number = Integer.toString(n);
            for(char num : number.toCharArray()) {
                answer += num - '0';
            }
    
            return answer;
        }
    }
 
    public class Solution2 {
        public int solution(int n) {
            int answer = 0;
    
            while(n > 9) {
                answer += n%10;
                n = n/10;
            }
    
            return answer + n;
        }
    }
}
