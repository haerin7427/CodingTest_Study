// https://school.programmers.co.kr/learn/courses/30/lessons/86971
// title : 전력망을 둘로 나누기

import java.util.*;

public class 전력망을둘로나누기 {
    class Solution {
        int[][] arr;
        
        public int solution(int n, int[][] wires) {
            // 최솟값을 구해야하기 때문에 ansewr를 제일 큰 값으로 초기화
            int answer = Integer.MAX_VALUE;
            
            // 인접 행렬 만들기
            arr = new int[n+1][n+1];
            
            for(int i=0;i<wires.length;i++) {
                arr[wires[i][0]][wires[i][1]] = 1;
                arr[wires[i][1]][wires[i][0]] = 1;
            }
            
            // 전선 하나씩 끊으면서 탐색
            for(int i=0;i<wires.length;i++) {
                int v1 = wires[i][0];
                int v2 = wires[i][1];

                // 전선 끊기
                arr[v1][v2] = 0;
                arr[v2][v1] = 0;

                // answer & 끊긴 전선을 기준으로 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값), 둘 중에서 작은 값
                answer = Math.min(answer, bfs(v1, n));

                // 끊었던 전선 다시 연결
                arr[v1][v2] = 1;
                arr[v2][v1] = 1;
            }

            return answer;
        }
        
        int bfs(int v1, int n) {
            // 현재 전력망의 송전탑 갯수
            int cnt = 1;
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new LinkedList<>();
            
            queue.add(v1);

            while(!queue.isEmpty()) {
                // 현재 송전탑
                int tower = queue.poll();
                visited[tower] = true;
                
                for(int i=1;i<=n;i++) {
                    // 현재 송전탑 기준으로 1번부터 n번까지 전선이 연결되어있고, 방문한 적 없는 경우
                    if(arr[tower][i] == 1 && !visited[i]) {
                        // i번째 송전탑 add
                        queue.add(i);
                        // 현재 전력망의 송전탑 갯수 증가
                        cnt++;
                    }
                }
            }
            
            // 현재 전력망의 송전탑 갯수 - (전체 송전탑 갯수 - 현재 전력망의 송전탑 갯수)의 절댓값
            return Math.abs(cnt - (n - cnt));
        }
    }
}