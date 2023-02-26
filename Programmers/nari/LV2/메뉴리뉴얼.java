// https://school.programmers.co.kr/learn/courses/30/lessons/72411
// title : 메뉴 리뉴얼

import java.util.*;

public class 메뉴리뉴얼 {
    // dfs 사용해서 모든 코스 조합 탐색
    class Solution {
        public String[] solution(String[] orders, int[] course) {
            // 완성된 코스 조합
            ArrayList<String> list = new ArrayList<>();
            
            for(int c : course) {
                // 코스 조합
                HashMap<String, Integer> map = new HashMap<>();
                
                // 해당 코스의 개수로 구성 가능한 조합을 모두 찾기
                for(String order : orders) {
                    map = dfs(order, "", c, 0, 0, map);
                }
                
                // 해당 코스 조합에서 최대 주문수를 찾기
                int max = 0;
                for(String key : map.keySet()) {
                    max = Math.max(max, map.get(key));
                }
                
                for(String key : map.keySet()) {
                    // 해당 코스 조합의 주문수
                    int orderCnt = map.get(key);
                    
                    // 주문수가 2이상이고, max 값과 동일한 경우
                    if(orderCnt >= 2 && max == orderCnt) list.add(key);
                }
            }
            
            String[] answer = new String[list.size()];
            for(int i=0;i<list.size();i++) {
                answer[i] = list.get(i);
            }
            
            Arrays.sort(answer);
            
            return answer;
        }
        
        HashMap<String, Integer> dfs(String order, String course, int max, int idx, int start, HashMap<String,Integer> map) {
            // 해당 코스의 최대 개수와 동일한 경우
            if(idx == max) {
                // 각 코스요리 메뉴의 구성을 오름차순으로 정렬
                char[] ch = course.toCharArray();
                Arrays.sort(ch);
                course = new String(ch);
                // 또는 String.valueOf(ch);  
                
                map.put(course, map.getOrDefault(course, 0) + 1);
            } 
            else {
                // 모든 코스 조합의 경우 찾기
                for(int i=start;i<order.length();i++) {
                    dfs(order, course+String.valueOf(order.charAt(i)), max, idx+1, i+1, map);
                }
            }
            
            return map;
        }
    }
}