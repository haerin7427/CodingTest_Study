// https://school.programmers.co.kr/learn/courses/30/lessons/49189
// title : 가장 먼 노드

import java.util.*;

public class 가장먼노드 {
    class Solution1 {
        int[] depths;
        int maxDepth = 0;
        
        public int solution(int n, int[][] edge) {
            int answer = 0;
            depths = new int[n+1];
            
            bfs(1, 1, edge);
            
            // maxDepth와 동일한 depth일 경우, 가장 먼 노드라고 판단
            for(int i=1;i<=n;i++) {
                if(maxDepth == depths[i]) answer++;
            }
            
            return answer;
        }
        
        void bfs(int start, int count, int[][] edge){
            Queue<Integer> queue = new LinkedList();
            queue.add(start);
            queue.add(count);
            
            // 현재 노드 번호에 갯수 저장
            depths[start] = count;
            
            while(!queue.isEmpty()) {
                int node = queue.poll();
                int n = queue.poll();
                
                if(maxDepth < n) maxDepth = n;
                
                for(int i=0;i<edge.length;i++) {
                    // edge[i]에 해당 노드가 없는 경우
                    if(edge[i][0] != node && edge[i][1] != node) continue;
                    
                    // 해당 노드와 연결된 다음 노드
                    int next = edge[i][0] == node ? edge[i][1] : edge[i][0];
                    
                    // 다음 노드에 이미 값이 저장되어 있는 경우 
                    if(depths[next] != 0) continue;
                    
                    depths[next] = n+1;
                    queue.add(next);
                    queue.add(n+1);
                }
            }
        }
    }

    // dfs 경우 -> 깊이 탐색이기 때문에 maxDepth 값을 구하기 어려움
    // graph 배열 만들어서 연결했을 경우 -> 메모리 초과
    class Solution2 {
        int[][] Edge;
        // 1번 노드에서 각 노드의 간선 갯수
        int[] depths;
        int maxDepth = 0;
        
        public int solution(int n, int[][] edge) {
            int answer = 0;
            Edge = edge;
            depths = new int[n+1];
            
            bfs(1, 1);
            
            for(int depth : depths) {
                if(depth == maxDepth) answer++;
            }

            return answer;
        }
        
        public void bfs(int idx, int count) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{idx, count});
            
            depths[idx] = count;
            
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                
                if(maxDepth < cur[1]) maxDepth = cur[1];
                
                for(int i=0;i<Edge.length;i++) {
                    // 연결되어 있지 않은 경우
                    if(Edge[i][0] != cur[0] && Edge[i][1] != cur[0]) continue;
                    
                    int next = Edge[i][0] == cur[0] ? Edge[i][1] : Edge[i][0];
                    
                    // 이미 값이 저장되어 있는 경우
                    // bfs라 최단 거리 우선 저장
                    if(depths[next] != 0) continue;
                    
                    depths[next] = cur[1] + 1;
                    
                    queue.add(new int[]{next, cur[1]+1});
                }
            }
        }
    }
}