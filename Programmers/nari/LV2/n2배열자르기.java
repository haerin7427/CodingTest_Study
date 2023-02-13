// https://school.programmers.co.kr/learn/courses/30/lessons/87390
// title : n^2 배열 자르기

public class n2배열자르기 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = new int[(int)(right-left)+1];
            
            //    0 1 2
            //    -----
            // 0| 1 2 3
            // 1| 2 2 3
            // 2| 3 3 3
            // 행과 열 index 중에서 큰 값의 +1 한 값
            int idx = 0;
            for (long i=left;i<=right;i++) {
                // row와 col이 int일 때, 결과 실패
                long row = i / n;
                long col = i % n;
                answer[idx++] = Math.max((int)row, (int)col) + 1;
            }
            
            return answer;
        }
    }
}