package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12923#
// title : 숫자 블록
// type : 구현
// time : 1h 초과
// Created by haerin on 2023-03-09
public class 숫자블록 {
    // 효율성 테스트 : 시간초과
    class Solution {
        public int[] solution(long begin, long end) {
            int[] answer = new int[(int)(end-begin+1)];
            int b = (int) begin;
            int e = (int) end;
    
            for(int num=b; num<e+1; num++){
                answer[num - b] = 1;
                for(int i=2; i<num; i++){
                    if(num % i == 0 && num / i <= 10000000){
                        answer[num - b] = num / i;
                        break;
                    }
                }
            }
            if(b == 1){
                answer[0] = 0;
            }
            return answer;
        }
    }
    // 효율성 테스트 통과
    class Solution2 {
        public int[] solution(long begin, long end) {
            int[] answer = new int[(int)(end-begin+1)];
            int b = (int) begin;
            int e = (int) end;
    
            for(int num=b; num<e+1; num++){
                int value = 1;
                for(int i=2; i<=Math.sqrt(num); i++){
                    if(num % i == 0){
                        if(num / i > 10000000){
                            value = i;
                        }else{
                            value = num / i;
                            break;
                        }
                    }
                }
                answer[num - b] = value;
            }

            if(b == 1){
                answer[0] = 0;
            }
            return answer;
        }
    }
}
