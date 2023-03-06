// https://school.programmers.co.kr/learn/courses/30/lessons/92342
// title : 양궁대회

public class 양궁대회 {
    class Solution {
        int[] answer = {-1};
        int[] lion = new int[11];
        int max = 0;
        
        public int[] solution(int n, int[] info) {
            // 어피치 정보, 현재 쏜 화살 갯수, 총 쏠 수 있는 화살 갯수
            dfs(info, 1, n);
            
            return answer;
        }
        
        void dfs(int[] info, int cnt, int n) {
            // 현재까지 쏜 화살 갯수가 총 쓸 수 있는 화살 갯수를 넘은 경우
            if(cnt > n) {
                int apeach_point = 0;
                int lion_point = 0;
                
                // 0점 ~ 10점 = 11개
                for(int i=0;i<11;i++) {
                    // 해당 과녁에 대한 info에 화살 갯수가 있거나 lion에 화살 갯수가 있을 경우
                    if(info[i] != 0 || lion[i] != 0) {
                        // i번째 원소는 과녁의 10 - i 점을 맞힌 화살 개수
                        if(info[i] < lion[i]) lion_point += 10 - i;
                        else apeach_point += 10 - i;
                    }
                }
                
                // lion이 apeach보다 점수를 더 받았고, 둘의 점수차가 최댓값인 경우
                if(lion_point > apeach_point && lion_point - apeach_point >= max) {
                    // answer 배열은 lion 배열을 clone
                    answer = lion.clone();
                    // max는 둘의 점수차
                    max = lion_point - apeach_point;
                }
                
                return ;
            }
            
            // 0점 ~ 10점 = 11개
            for(int i=0;i<11;i++) {
                // 해당 lion의 화살 갯수가 info의 화살 갯수보다 클 경우, 제외
                if(lion[i] > info[i]) break;
                
                lion[i]++;
                dfs(info, cnt+1, n);
                lion[i]--;
            }
        }
    }
}