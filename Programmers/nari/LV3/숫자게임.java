// https://school.programmers.co.kr/learn/courses/30/lessons/12987
// title : 숫자 게임

import java.util.*;

public class 숫자게임 {
    class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;
            int idx = B.length-1;
            
            Arrays.sort(A);
            Arrays.sort(B);
            
            // 뒤에서부터 시작
            for(int i=A.length-1;i>=0;i--) {
                // 해당 idx번째 숫자가 i번째 숫자보다 큰 경우, 카드 사용(= idx 내려주기)
                // 작은 경우, 앞에 있는 제일 작은 숫자를 사용(= idx 내려주기 X)
                if(B[idx] > A[i]) {
                    answer++;
                    idx--;
                }
            }
            
            return answer;
        }
    }
}