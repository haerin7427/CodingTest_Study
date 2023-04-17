// https://school.programmers.co.kr/learn/courses/30/lessons/178871
// title : 달리기 경주
// type : HashMap
// time : 17m
// Created by haerin on 2023-04-17
import java.util.*;
public class 달리기경주 {
    // 75점 : 시간초과
    class Solution {
        public String[] solution(String[] players, String[] callings) {
            for(String name : callings){
                for(int i=1; i<players.length; i++){
                    if(name.equals(players[i])){
                        String temp = players[i];
                        players[i] = players[i-1];
                        players[i-1] = temp;
                        break;
                    }
                }
            }
            return players;
        }
    }
    class Solution2 {
        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> recodeMap = new HashMap<>();
            for(int i=0; i<players.length; i++){
                recodeMap.put(players[i], i);
            }
            for(String name : callings){
                int score = recodeMap.get(name);
                
                String temp = players[score];
                players[score] = players[score-1];
                players[score-1] = temp;
                
                recodeMap.put(name, score-1);
                recodeMap.put(players[score], score);
                
            }
            return players;
        }
    }
}
