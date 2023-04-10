// https://school.programmers.co.kr/learn/courses/30/lessons/12920
// title : 선입 선출 스케줄링

public class 선입선출스케줄링 {
    // 효율성 테스트 - 시간 초과
    class Solution1 {
        public int solution(int n, int[] cores) {
            int answer = 0;
            int len = cores.length;
            int[] works = new int[len];
            
            // works 초기화 -> 코어의 수보다 처리할 양이 적은 경우도 생각
            for(int i=0;i<len;i++) {
                if(n == 0) break;
                
                works[i] = cores[i];
                answer = i+1;
                n--;
            }
            
            // n이 0이 될때까지 반복
            while(n > 0) {
                for(int i=0;i<len;i++) {
                    if(n == 0) break;
                    
                    works[i]--;
                    
                    if(works[i] == 0) {
                        works[i] = cores[i];
                        answer = i+1;
                        n--;
                    }
                }
            }
            
            return answer;
        }
    }

    // 파라메트릭 서치
    class Solution2 {
        public int solution(int n, int[] cores) {
            // 코어의 수보다 처리할 양이 적은 경우
            if (n <= cores.length) return n;
            
            int len = cores.length;
            int minCore = Integer.MAX_VALUE, maxCore = 0;
            
            for(int core : cores) {
                minCore = Math.min(minCore, core);
                maxCore = Math.max(maxCore, core);
            }
            
            // 작업을 처리하는 최소시간, 최대시간
            int left = minCore * (n / len);
            int right = maxCore * n;
            
            while(left <= right) {
                // 현재 시점
                int mid = (left + right) / 2;
                // mid 전까지 한 작업량
                int workCnt = len;
                // mid 시점에 한 작업량
                int curWorkCnt = 0;
                
                for(int core : cores) {
                    // 현재까지 처리한 양 더하기
                    workCnt += (mid / core);
                    
                    // 작업을 받은 경우
                    if(mid % core == 0) {
                        workCnt--;
                        curWorkCnt++;
                    }
                }
                
                // 총 작업량
                int sum = workCnt + curWorkCnt;
                
                // 이전까지 처리한 작업량이 이미 넘친 경우 -> 최대시간 줄이기
                if(workCnt >= n) right = mid - 1;
                // 총 작업량이 코어 수보다 작은 경우 -> 처리해야할 작업이 남아있는 경우
                else if(sum < n) left = mid + 1;
                // 
                else {
                    for(int i=0;i<len;i++) {
                        // 앞의 코어부터 작업 처리
                        if(mid % cores[i] == 0) workCnt++;
                        // n개째 작업인 경우, 해당 코어 번호 return
                        if(workCnt == n) return i+1;
                    }
                }
            }
            
            return 0;
        }
    }
}