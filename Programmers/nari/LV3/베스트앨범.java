// https://school.programmers.co.kr/learn/courses/30/lessons/42579
// title : 베스트앨범

import java.util.*;

public class 베스트앨범 {
    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            // genre - {(index - play), (index - play)}
            HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
            // genre - 총 play 수
            HashMap<String, Integer> count = new HashMap<>();
            
            for(int i=0;i<genres.length;i++) {
                // 해당 장르가 이미 map에 들어있는 경우
                if(count.containsKey(genres[i])) {
                    count.put(genres[i], count.get(genres[i]) + plays[i]);
                    music.get(genres[i]).put(i, plays[i]);
                }
                else {
                    count.put(genres[i], plays[i]);
                    
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.put(i, plays[i]);
                    music.put(genres[i], map);
                }
            }
            
            // count hashmap을 play를 기준으로 내림차순 정렬
            ArrayList<String> keySet = new ArrayList(count.keySet());
            Collections.sort(keySet, (s1, s2) -> count.get(s2) - count.get(s1));
            
            // 정답 담을 list
            ArrayList<Integer> list = new ArrayList<>();
            
            for(String key : keySet) {
                HashMap<Integer, Integer> map = music.get(key);
                
                // (index - play)에서 play를 기준으로 내림차순 정렬
                ArrayList<Integer> genre_key = new ArrayList(map.keySet());
                Collections.sort(genre_key, (s1, s2) -> map.get(s2) - map.get(s1));
    
                // index만 담으면 되기 때문에 ArrayList에서 가져와도 상관X
                list.add(genre_key.get(0));
                
                // 2개 이상일 경우, 2번째까지 담기
                if(genre_key.size() > 1) list.add(genre_key.get(1));
            }
            
            int[] answer = new int[list.size()];
            
            for(int i=0;i<list.size();i++) {
                answer[i] = list.get(i);
            }
            
            return answer;
        }
    }
}