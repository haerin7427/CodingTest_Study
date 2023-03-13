// https://school.programmers.co.kr/learn/courses/30/lessons/43162
// title : 네트워크

public class 네트워크 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            
            for(int i=0;i<n;i++) {
                if(!visited[i]) {
                    dfs(i, visited, computers);
                    answer++;
                }
            }
            
            return answer;
        }
        
        void dfs(int idx, boolean[] visited, int[][] computers) {
            visited[idx] = true;
            
            for(int i=0;i<computers.length;i++) {
                // 방문한 적 없는 경우 -> 자기 자신인 경우엔 이미 방문했기때문에 여기서 걸러짐
                // computer 배열의 값이 1인 경우
                if(!visited[i] && computers[idx][i] == 1) 
                    dfs(i, visited, computers);
            }
        }
    }
}