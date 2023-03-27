// https://school.programmers.co.kr/learn/courses/30/lessons/132266
// title : 부대복귀

import java.util.*;

public class 부대복귀 {
    // 다익스트라(dijkstra) 알고리즘 사용 -> 시간 복잡도 O(VlogV + ElogV)
    class Solution {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // destination에서 index에 해당하는 지역까지 거리
        int[] dis;
        
        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];
            for(int i=0;i<n+1;i++) graph.add(new ArrayList<>());
            dis = new int[n+1];
            
            for(int[] road : roads) {
                int s = road[0];
                int e = road[1];

                // 연결된 지역
                graph.get(s).add(e);
                graph.get(e).add(s);
            }
            
            Arrays.fill(dis, Integer.MAX_VALUE);
            dijkstra(destination);
            
            for(int i=0;i<sources.length;i++) {
                // 복귀 불가능일 경우, -1
                answer[i] = (dis[sources[i]] < Integer.MAX_VALUE) ? dis[sources[i]] : -1;
            }
            
            return answer;
        }
        
        void dijkstra(int destination) {
            Queue<Integer> queue = new LinkedList<>();
            
            queue.add(destination);
            dis[destination] = 0;

            while(!queue.isEmpty()) {
                int area = queue.poll();

                for(int i=0;i<graph.get(area).size();i++) {
                    int connect = graph.get(area).get(i);
                    
                    if(dis[connect] > dis[area]+1) {
                        dis[connect] = dis[area] + 1;
                        queue.add(connect);
                    }
                }
            }
        }
    }
}