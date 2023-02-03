// https://school.programmers.co.kr/learn/courses/30/lessons/12924
// title : 숫자의 표현

public class 숫자의표현 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            
            for(int i=1;i<=n;i++) {
                int num = 0;
                
                for(int j=i;j<=n;j++) {
                    num += j;
                    
                    if(num == n) {
                        answer++;
                        break;
                    }
                    else if(num > n) break;
                }
            }
            
            return answer;
        }
    }
}