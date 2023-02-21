// https://school.programmers.co.kr/learn/courses/30/lessons/87946
// title : 피로도

public class 피로도 {
    class Solution {
        boolean[] visited;
        int answer = 0;
        
        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];
            dfs(0, k, dungeons);
            
            return answer;
        }
        
        void dfs(int depth, int k, int[][] dungeons){  
            for(int i=0;i<dungeons.length;i++) {
                // 이미 방문했거나 남은 피로도가 최소 필요 피로도보다 작은 경우
                if(visited[i] || dungeons[i][0] > k) continue;  
                
                visited[i] = true;
                // depth 증가, 남은 피로도 계산
                dfs(depth+1, k - dungeons[i][1], dungeons);  
                visited[i] = false;  
            }  
            
            answer = Math.max(answer, depth);
        } 
    }
}