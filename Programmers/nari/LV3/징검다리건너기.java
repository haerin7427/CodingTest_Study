// https://school.programmers.co.kr/learn/courses/30/lessons/64062
// title : 징검다리 건너기

public class 징검다리건너기 {
    class Solution {
        public int solution(int[] stones, int k) {
            int answer = 0;
            int left = 1;
            // 친구들의 수는 무제한
            int right = Integer.MAX_VALUE;
            
            // 이분탐색 기준 : 징검다리는 건널 수 있는 친구의 수
            while(left <= right) {
                int mid = (left + right) / 2;
                int skip = 0;
                boolean isPass = true;
                
                for(int stone : stones) {
                    // 해당 디딤돌이 mid보다 작은 경우, 밟을 수 없다
                    // 같을 때도 조건을 넣어주면 실패,,,
                    if(stone < mid) skip++;
                    // 크거나 같은 경우, 0으로 초기화 -> 밟을 수 없는 연속된 디딤돌을 체크해야하기 떄문에
                    else skip = 0;
                    
                    if(skip == k) {
                        isPass = false;
                        break;
                    }
                }
                
                // mid까지 모두 건널 수 있는 경우, min 위치 이동
                if(isPass) {
                    left = mid + 1;
                    answer = Math.max(answer, mid);
                }
                else right = mid - 1;
            }
            
            return answer;
        }
    }
}