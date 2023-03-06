// https://school.programmers.co.kr/learn/courses/30/lessons/161989
// title : 덧칠하기

public class 덧칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            // 페인트칠 마지막으로 한 구역
            int area = 0;

            for(int i=0;i<section.length;i++) {
                // 이미 페인트칠을 한 구역일 경우
                if(section[i] < area) continue;

                // 페인트칠 count
                answer += 1;
                // 현재 구역에서 m만큼 증가한 구역에 페일트칠
                area = section[i] + m;
            }
            
            return answer;
        }
    }
}