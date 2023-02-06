// https://school.programmers.co.kr/learn/courses/30/lessons/42747
// title : H-Index

import java.util.Arrays;

public class HIndex {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            
            // 배열을 오름차순으로 정렬
            Arrays.sort(citations);
            
            // 현재 index와 남은 개수 비교해서 최댓값 찾기
            for(int i=0;i<citations.length;i++) {
                // 현재 index와 남은 개수가 동일하면 break;
                // if(citations[i] == citations.length-i) {
                //     answer = citations[i];
                //     break;
                // }
                
                // 예외처리 필요 -> citations에 h값이 들어가 있지 않을 때
                if(citations[i] >= citations.length-i) {
                    answer = citations.length-i;
                    break;
                }
            }
            
            return answer;
        }
    }
}