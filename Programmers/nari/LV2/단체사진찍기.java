// https://school.programmers.co.kr/learn/courses/30/lessons/1835
// title : 단체사진 찍기

import java.util.*;

public class 단체사진찍기 {
    class Solution {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[8];
        int[] ch = new int[8];
        int answer = 0;
        
        public int solution(int n, String[] data) {
            map.put('A', 0);
            map.put('C', 1);
            map.put('F', 2);
            map.put('J', 3);
            map.put('M', 4);
            map.put('N', 5);
            map.put('R', 6);
            map.put('T', 7);
            
            dfs(0, data);
            
            return answer;
        }
        
        void dfs(int idx, String[] data) {
            // 끝까지 도달한 경우
            if(idx == 8) {
                for(String d : data) {
                    // 첫번째 프렌즈
                    int a = ch[map.get(d.charAt(0))];
                    // 두번째 프렌즈
                    int b = ch[map.get(d.charAt(2))];
                    char op = d.charAt(3);
                    // 조건에 제시되는 간격 (= 다른 프렌즈의 수)
                    int other = Character.getNumericValue(d.charAt(4)) + 1;

                    // 두 프렌즈 사이의 간격이 other와 같지 않은 경우
                    if(op == '=' && Math.abs(a-b) != other) return;
                    // 두 프렌즈 사이의 간격이 other보다 작거나 같을 경우
                    else if(op == '>' && Math.abs(a-b) <= other) return;
                    // 두 프렌즈 사이의 간격이 other보다 크거나 같을 경우
                    else if(op == '<' && Math.abs(a-b) >= other) return;
                }
                
                answer++;
            }
            else {
                for(int i=0;i<8;i++) {
                    // 방문하지 않은 프렌즈가 있는 경우
                    if(!visited[i]) {
                        visited[i] = true;
                        // 배열의 현재 index가 현재 깊이에 현재 프렌즈 값 저장
                        ch[idx] = i;
                        dfs(idx + 1, data);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}