package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/64064
// title : 불량 사용자
// type : DFS
// time : 30m
// Created by haerin on 2023-03-21
import java.util.*;
public class 불량사용자 {
    class Solution {
        public HashSet<HashSet<String>> answer;
        public int solution(String[] user_id, String[] banned_id) {
            answer = new HashSet<>();
    
            dfs(new LinkedHashSet<>(), user_id, banned_id);
    
            return answer.size();
        }
        
        public void dfs(HashSet<String> hashset, String[] user_id, String[] banned_id) {
            if (hashset.size() == banned_id.length) {
                if (isBanList(hashset, banned_id)) {
                    answer.add(new HashSet<>(hashset));
                }
                return;
            }
    
            for (String userId : user_id) {
                if (hashset.add(userId)) {
                    dfs(hashset, user_id, banned_id);
                    hashset.remove(userId);
                }
            }
        }
        
        public boolean isBanList(HashSet<String> hashset, String[] banned_id) {
            int idx = 0;
            for (String userID : hashset) {
                String banID = banned_id[idx++];
                if (userID.length() != banID.length()) {
                    return false;
                }
                for (int i = 0; i < banID.length(); i++) {
                    if (banID.charAt(i) != '*' &&  banID.charAt(i) != userID.charAt(i)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
