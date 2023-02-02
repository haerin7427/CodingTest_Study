// https://school.programmers.co.kr/learn/courses/30/lessons/42862
// title : 체육복

import java.util.*;

public class 체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n;
            
            Arrays.sort(lost);
            Arrays.sort(reserve);
            
            // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 때
            for(int i=0;i<lost.length;i++) {
                for(int j=0;j<reserve.length;j++) {
                    if(lost[i] == reserve[j]) {
                        lost[i] = reserve[j] = -1;
                        answer++;
                        break;
                    }
                }
            }
            
            for(int l : lost){
                for(int i=0;i<reserve.length;i++){
                    if(l == reserve[i]-1 || l == reserve[i]+1){
                        reserve[i] = -1;
                        answer++;
                        break;
                    }
                }
            }
            
            return answer - lost.length;
        }
    }
}