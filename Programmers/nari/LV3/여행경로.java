// https://school.programmers.co.kr/learn/courses/30/lessons/43164
// title : 여행경로

import java.util.*;

public class 여행경로 {
    class Solution1 {
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

    // ArrayList<ArrayList<String>> allRoute 으로 했다가 arraylist 안에 arraylist가 있을 때, 정렬 X
    class Solution2 {
        String[][] ticket;
        int len;
        boolean[] visited;
        ArrayList<String> allRoute = new ArrayList<>();
        
        public String[] solution(String[][] tickets) {
            ticket = tickets;
            len = tickets.length;
            visited = new boolean[len];
            
            // 인천 공항 출발 찾기
            for(int i=0;i<len;i++) {
                if(ticket[i][0].equals("ICN")) {
                    StringBuilder newRoute = new StringBuilder(ticket[i][0]);
                    newRoute.append(" ");
                    newRoute.append(ticket[i][1]);
                    
                    visited[i] = true;
                    dfs(0, ticket[i][1], newRoute);
                    visited[i] = false;
                }
            }
            
            // 담겨진 모든 경로 정렬
            Collections.sort(allRoute);
            
            return allRoute.get(0).split(" ");
        }
        
        public void dfs(int idx, String start, StringBuilder route) {
            // 모든 경로를 탐색했을 경우
            if(idx == len-1) {
                allRoute.add(route.toString());
                return;
            }
            
            // 넘어온 다음 출발지에 대한 값 찾기
            for(int i=0;i<len;i++) {
                if(visited[i]) continue;
                
                if(ticket[i][0].equals(start)) {
                    StringBuilder newRoute = new StringBuilder(route);
                    newRoute.append(" ");
                    newRoute.append(ticket[i][1]);
                    
                    visited[i] = true;
                    dfs(idx+1, ticket[i][1], newRoute);
                    visited[i] = false;
                }
            }
        }
}
}