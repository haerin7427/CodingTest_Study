// https://school.programmers.co.kr/learn/courses/30/lessons/12923
// title : 숫자 블록

public class 숫자블록 {
    class Solution {
        public int[] solution(long begin, long end) {
            int b = (int)begin, e = (int)end;
            int[] answer = new int[e-b+1];
            int idx = 0;
            
            // 시작 구간이 1일 경우
            if(b == 1) {
                answer[idx++] = 0;
                b++;
            }

            for(int i=b;i<=e;i++) {
                // 소수는 1이기 때문에
                int value = 1;

                for(int j=2;j<=Math.sqrt(i);j++){
                    // 소수가 아닐 경우
                    if(i%j == 0) {
                        value = i/j;
                        
                        // 블럭은 10000000(천만)까지기 때문에
                        if(value <= 10000000) break;
                        else value = j;
                    }
                }

                answer[idx++] = value;
            }
            
            return answer;
        }
    }
}