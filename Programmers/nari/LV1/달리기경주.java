// https://school.programmers.co.kr/learn/courses/30/lessons/178871
// title : 달리기 경주

import java.util.*;

public class 달리기경주 {
    // 시간 초과
    // hashmap, 이중 for문 활용
    class Solution1 {
        public String[] solution(String[] players, String[] callings) {
            int playersLen = players.length;
            String[] answer = new String[playersLen];
            HashMap<String, Integer> map = new HashMap<>();
            
            for(int i=0;i<playersLen;i++) {
                map.put(players[i], i);
            }
            
            for(String calling : callings) {
                int cur = map.get(calling);
                int change = cur - 1;
                
                for(String key : map.keySet()) {
                    if(map.get(key).equals(change)) {
                        map.replace(key, cur);
                        break;
                    }
                }
                
                map.replace(calling, change);
            }
            
            ArrayList<String> keySetList = new ArrayList<>(map.keySet());
            Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
            
            for(String key : keySetList) {
                answer[map.get(key)] = key;
            }
            
            return answer;
        }
    }

    // hashmap 2개 사용으로, 이중 for문 미사용
    class Solution2 {
        public String[] solution(String[] players, String[] callings) {
            int playersLen = players.length;
            String[] answer = new String[playersLen];
            HashMap<String, Integer> playerMap = new HashMap<>();
            HashMap<Integer, String> rankMap = new HashMap<>();
            
            for(int i=0;i<playersLen;i++) {
                playerMap.put(players[i], i);
                rankMap.put(i, players[i]);
            }
            
            for(String calling : callings) {
                // 추월한 선수 등수
                int cur = playerMap.get(calling);
                // 추월 당한 선수 이름
                String name = rankMap.get(cur-1);
                
                playerMap.replace(name, cur);
                playerMap.replace(calling, cur-1);
                rankMap.replace(cur, name);
                rankMap.replace(cur-1, calling);
            }
            
            ArrayList<String> keySetList = new ArrayList<>(playerMap.keySet());
            Collections.sort(keySetList, (o1, o2) -> (playerMap.get(o1).compareTo(playerMap.get(o2))));
            
            for(String key : keySetList) {
                answer[playerMap.get(key)] = key;
            }
            
            return answer;
        }
    }
}