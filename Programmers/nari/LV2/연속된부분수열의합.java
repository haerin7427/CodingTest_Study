// https://school.programmers.co.kr/learn/courses/30/lessons/178870
// title : 연속된 부분 수열의 합

public class 연속된부분수열의합 {
    // 시간 초과
    class Solution1 {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            // 가장 짧은 길이
            int minLen = Integer.MAX_VALUE;
            
            for(int i=0;i<sequence.length;i++) {
                int sum = 0;
                int idx = i;
                
                while(idx < sequence.length && sum < k) {
                    sum += sequence[idx++];
                }
                
                // idx는 증가하고 나왔기 때문에 -1
                if(sum == k && minLen > (idx-1-i)) {
                    answer[0] = i;
                    answer[1] = idx-1;
                    minLen = idx-1-i;
                }
            }
            
            return answer;
        }
    }

    // 처음 index를 빼주고 그다음 index로 넘어가기 -> Solution1은 0부터 다시 덧셈
    class Solution2 {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            // 가장 짧은 길이
            int minLen = Integer.MAX_VALUE;
            int sum = 0, idx = 0;
            
            for(int i=0;i<sequence.length;i++) {
                while(idx < sequence.length && sum < k) {
                    sum += sequence[idx++];
                }
                
                // idx는 증가하고 나왔기 때문에 -1
                if(sum == k && minLen > (idx-1-i)) {
                    answer[0] = i;
                    answer[1] = idx-1;
                    minLen = idx-1-i;
                }
                
                sum -= sequence[i];
            }
            
            return answer;
        }
    }
}