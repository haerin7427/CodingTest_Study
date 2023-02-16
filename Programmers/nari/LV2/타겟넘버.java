// https://school.programmers.co.kr/learn/courses/30/lessons/43165
// title : 타겟 넘버

public class 타겟넘버 {
    class Solution1 {
        public int solution(int[] numbers, int target) {
            return dfs(numbers, target, 0, 0);
        }
        
        int dfs(int[] numbers, int target, int idx, int sum) {
            if(idx == numbers.length) {
                if(sum == target) return 1;
                else return 0;
            }
            return dfs(numbers, target, idx + 1, sum + numbers[idx]) + dfs(numbers, target, idx + 1, sum - numbers[idx]);
        }
    }

    class Solution2 {
        int answer = 0;
        
        public int solution(int[] numbers, int target) {
            dfs(numbers, 0, target, 0);
            
            return answer;
        }
        
        // 깊이 우선 탐색
        void dfs(int[] numbers, int depth, int target, int sum) {
            // 마지막 노드 까지 탐색한 경우
            if(depth == numbers.length) { 
                if(target == sum) answer++;
            }
            else {
                // 해당 노드의 값을 더하고 다음 깊이 탐색
                dfs(numbers, depth + 1, target, sum + numbers[depth]);
                // 해당 노드의 값을 빼고 다음 깊이 탐색
                dfs(numbers, depth + 1, target, sum - numbers[depth]);
            }
        }
    }
}