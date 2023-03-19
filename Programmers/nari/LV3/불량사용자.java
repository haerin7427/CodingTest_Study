// https://school.programmers.co.kr/learn/courses/30/lessons/64064
// title : 불량 사용자

import java.util.*;

public class 불량사용자 {
    class Solution {
        HashSet<HashSet<String>> answer = new HashSet<>();
        String[] ban;
        
        public int solution(String[] user_id, String[] banned_id) {
            // int answer = 0;
            ban = new String[banned_id.length];
            
            for(int i=0;i<banned_id.length;i++) {
                // 0~9, a~z의 문자 탐색이 가능하도록 정규표현식 \w로 변경
                ban[i] = banned_id[i].replace("*", "[\\w]");
            }
            
            dfs(new HashSet<>(), 0, user_id, 0);
            
            return answer.size();
        }
        
        void dfs(HashSet<String> set, int depth, String[] user_id, int index) {
            // 불량 사용자 명수와 depth가 같을 경우
            if(depth == ban.length) {
                answer.add(set);
                return;
            }

            for(int i=0;i<user_id.length;i++) {
                // 이미 set에 user가 들어있는 경우
                if(set.contains(user_id[i])) continue;

                // user[i]가 ban[index]의 문자열과 동일한 경우
                if(user_id[i].matches(ban[index])) {
                    set.add(user_id[i]);
                    dfs(new HashSet<>(set), depth+1, user_id, index+1);
                    set.remove(user_id[i]);
                }
            }
        }
    }
}