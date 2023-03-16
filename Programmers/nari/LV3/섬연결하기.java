// https://school.programmers.co.kr/learn/courses/30/lessons/42861
// title : 섬 연결하기

import java.util.*;

public class 섬연결하기 {
    class Solution {
        int[] parent;
        
        public int solution(int n, int[][] costs) {
            int answer = 0;
            parent = new int[n];
            
            // 크루스칼 알고리즘 사용하기 위해 다리 건설 비용을 기준으로 오름차순 정렬
            Arrays.sort(costs, (int[] a, int[] b) -> a[2]-b[2]);
            
            // 자기자신으로 부모노드 초기화
            for(int i=0;i<n;i++) {
                parent[i] = i;
            }
            
            for(int[] info : costs) {
                // 연결되는 두 섬의 parent
                int aParent = findParent(info[0]);
                int bParent = findParent(info[1]);
                
                // 부모노드가 같을 경우, 건설 X
                //   -> 두 노드가 같은 그래프에 속한 것을 의미 = 두 섬은 이미 연결되었다
                if(aParent == bParent) continue;
                
                // 다리 건설 -> 비용 더하기
                answer += info[2];
                // 다리를 건설해서 두 node가 같은 그래프에 속하게 되었기 때문에 부모노드 갱신
                parent[bParent] = aParent;
            }
            
            return answer;
        }
        
        // 부모노드가 현재 노드와 같은 값을 찾을 때까지 재귀호출
        int findParent(int node) {
            if(node == parent[node]) return node;
            
            return parent[node] = findParent(parent[node]);
        }
    }
}