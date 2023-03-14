// https://school.programmers.co.kr/learn/courses/30/lessons/43164
// title : 여행경로

import java.util.*;

public class 여행경로 {
    class Solution {
        boolean[] visited;
        ArrayList<String> allRoute = new ArrayList<>();
        
        public String[] solution(String[][] tickets) {
            visited = new boolean[tickets.length];
            
            // 항상 "ICN" 공항에서 출발
            dfs("ICN", "ICN", tickets, 0);

            Collections.sort(allRoute);
            
            String[] answer = allRoute.get(0).split(" ");
            
            return answer;
        }
        
        void dfs(String start, String route, String[][] tickets, int cnt) {
            // 배열을 모두 탐색했을 경우
            if(cnt == tickets.length) {
                allRoute.add(route);
                return;
            }
            
            for(int i=0;i<tickets.length;i++) {
                StringBuilder sb = new StringBuilder(route);
                
                // ticket의 출발지가 함수에 넘어온 출발지와 동일하고, 방문한 적 없는 경우
                if(tickets[i][0].equals(start) && !visited[i]) {
                    visited[i] = true;
                    sb.append(" ");
                    sb.append(tickets[i][1]);
                    dfs(tickets[i][1], sb.toString(), tickets, cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}