// https://school.programmers.co.kr/learn/courses/30/lessons/161988
// title : 연속 펄스 부분 수열의 합

import java.util.*;

public class 연속펄스부분수열의합 {
    // 시간 초과
    class Solution {
        public long solution(int[] sequence) {
            long answer = 0;
            int len = sequence.length;
            // sequence에 [1, -1, 1, ...], [-1, 1, -1, ...] 펄스 수열 곱한 값 저장
            int[] seq1 = new int[len], seq2 = new int[len];
            
            for(int i=0;i<len;i++) {
                // 짝수인 경우
                if(i % 2 == 0) {
                    seq1[i] = -sequence[i];
                    seq2[i] = sequence[i];
                } 
                // 홀수인 경우
                else {
                    seq1[i] = sequence[i];
                    seq2[i] = -sequence[i];
                }
            }
            
            // 연속 부분 수열 시작하는 index
            for(int i=0;i<len;i++) {
                long sum1 = 0, sum2 = 0;
                int idx = i;
                
                // 배열에서 하나씩 더해보고 max 비교
                while(idx < len) {
                    sum1 += seq1[idx];
                    sum2 += seq2[idx];
                    
                    answer = Math.max(answer, Math.max(sum1, sum2));
                    idx++;
                }
            }
            
            return answer;
        }
    }

    // DP 사용
    class Solution {
        public long solution(int[] sequence) {
            int len = sequence.length;
            // sequence에 [1, -1, 1, ...], [-1, 1, -1, ...] 펄스 수열 곱한 값 저장
            long[] dp1 = new long[len];
            long[] dp2 = new long[len];
            
            dp1[0] = sequence[0];
            dp2[0] = -sequence[0];
            
            for(int i=1;i<len;i++) {
                long num = sequence[i];
                
                // 홀수인 경우
                if(i % 2 == 1) {
                    // 앞에 값과 연산한 값, 현재 값 비교해서 더 큰 값으로
                    dp1[i] = Math.max(dp1[i-1] + (-num), -num);
                    dp2[i] = Math.max(dp2[i-1] + num, num);
                }
                else{
                    dp1[i] = Math.max(dp1[i-1] + num, num);
                    dp2[i] = Math.max(dp2[i-1] + (-num), -num);
                }
            }
            
            Arrays.sort(dp1);
            Arrays.sort(dp2);
            
            return Math.max(dp1[len-1], dp2[len-1]);
        }
    }
}