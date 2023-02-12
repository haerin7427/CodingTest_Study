// https://school.programmers.co.kr/learn/courses/30/lessons/12913
// title : 땅따먹기

public class 땅따먹기 {
    // Dynamic Programming
    class Solution {
        int solution(int[][] land) {
            int answer = 0;

            // 이전 행에서 현재 열을 제외한 열의 최대값을 더하기
            for(int i = 1;i<land.length;i++) {
                land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
                land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
                land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
                land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
            }

            // 마지막 행의 최대값 탐색
            for(int score : land[land.length - 1]) { 
                answer = Math.max(answer, score);
            }

            return answer;
        }
    }
}