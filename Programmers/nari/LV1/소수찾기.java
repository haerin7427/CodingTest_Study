// https://school.programmers.co.kr/learn/courses/30/lessons/12921
// title : 소수 찾기

public class 소수찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            boolean check = false;
            
            for(int i=2;i<=n;i++) {
                if(Math.sqrt(i) < 1) check = true;
                else {
                    for(int j=2;j<=Math.sqrt(i);j++) {
                        if(i%j == 0) {
                            check = true;
                            break;
                        };
                    }
                }
                
                if(!check) answer++;
                else check = false;
            }
            
            return answer;
        }
    }
}