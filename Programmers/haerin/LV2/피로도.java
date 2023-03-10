package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
// title : 피로도
// type : dfs
// time : 20m, 26m
// Created by haerin on 2023-02-22, 2023-03-10
import java.util.*;
public class 피로도 {
    // 오답
    class Solution {
        public int solution(int k, int[][] dungeons) {
            Arrays.sort(dungeons ,new Comparator<int[]>(){
              @Override
              public int compare(int[] d1, int[] d2){
                if(d1[0] - d1[1] > d2[0] - d2[1]) 
                  return -1;
                else if(d1[0] - d1[1] < d2[0] - d2[1]){
                    return 1;
                }
                else{
                    return Integer.compare(d2[0],d1[0]);
                }
              }
            });
            int answer = 0;
            for(int i=0; i<dungeons.length; i++){
                if(k >= dungeons[i][0]){
                    answer+=1;
                    k -= dungeons[i][1];
                }
            }
            return answer;
        }
    }
    // 정답
    class Solution2 {
        int  count = 0;
        List<Integer> list = new ArrayList<>();
        public int solution(int k, int[][] dungeons) {
            boolean[] visited = new boolean[dungeons.length];
            dfs(dungeons,k, 0, visited, 0, dungeons.length, 0);
            list.sort(Comparator.reverseOrder());
            return list.get(0);
        }
    
        public void dfs(int[][] dungeons, int k,int i,boolean[] visited, int depth,int r, int count) {
    
            for(int j = 0; j < dungeons.length; j++) {
                if(!visited[j] && k >= dungeons[j][0]) {
                    visited[j] = true;
                    dfs(dungeons, k - dungeons[j][1], j, visited, depth+1, dungeons.length, count+1);
                    visited[j] = false;
                }
            }
            list.add(count);
        }
    }
    // 2023-03-10 작성
    class Solution3 {
        public int solution(int k, int[][] dungeons) {
            boolean[] isVisited = new boolean[dungeons.length];
            
            int answer = 0;
            for(int i=0; i<dungeons.length; i++){
                answer = Math.max(answer, dfs(dungeons, isVisited, k, i, 0));
            }
            return answer;
        }
        
        private int dfs(int[][] dungeons, boolean[] isVisited, int k, int idx, int cnt){
            if(dungeons[idx][0] > k){
                return cnt;
            }
            
            k -= dungeons[idx][1];
            isVisited[idx] = true;
            cnt+=1;
            
            if(cnt == dungeons.length){
                return dungeons.length;
            }
            
            int ans = 0;
            for(int i=0; i<dungeons.length; i++){
                if(!isVisited[i]){
                    ans = Math.max(ans, dfs(dungeons, isVisited, k, i, cnt));
                }
            }
            isVisited[idx] = false;
            return ans;
        }
    }
    // 2023-03-10 더 간결한 코드 발견
    class Solution4 {
        public boolean check[];
        public  int ans = 0;
    
        public int solution(int k, int[][] dungeons) {
            check = new boolean[dungeons.length];
    
            dfs(k, dungeons, 0);
    
            return ans;
        }
        public void dfs(int tired, int[][] dungeons, int cnt){
            for(int i=0; i<dungeons.length; i++){
                if(!check[i] && dungeons[i][0]<=tired){
                    check[i] = true;
                    dfs(tired-dungeons[i][1], dungeons, cnt+1);
                    check[i] = false;
                }
            }
            ans = Math.max(ans, cnt);
        }
    }
}
