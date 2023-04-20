// https://school.programmers.co.kr/learn/courses/30/lessons/138475
// title : 억억단을 외우자

public class 억억단을외우자 {
    class Solution {
        public int[] solution(int e, int[] starts) {
            int len = starts.length;
            int[] answer = new int[len];
            // 해당 index의 값이 몇번 나오는지
            int[] arr = new int[e+1];
            // 각 index의 값에서 가장 많이 등장한 수
            int[] cnt = new int[e+1];
            
            // 1은 자기 자신과 곱했을 때만 나오니까
            arr[1] = 1;
            
            for(int i=2;i<=e;i++) {
                // e를 i로 나눠서 구한 n까지 j에 i를 더하며, count
                int n = e/i;
                int j = i;
                
                for(int k=1;k<=n;k++) {
                    arr[j]++;
                    j += i;
                }   
            }
            
            // e부터 1까지 가장 많이 등장한 수 각각 cnt에 저장
            int max = 0;
            for(int i=e;i>=1;i--) {
                // max보다 큰 경우
                if(arr[i] >= max) {
                    max = arr[i];
                    cnt[i] = i;
                }
                else cnt[i] = cnt[i+1];
            }
            
            for(int i=0;i<len;i++) {
                answer[i] = cnt[starts[i]];
            }
            
            return answer;
        }
    }
}