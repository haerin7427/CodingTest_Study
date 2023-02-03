// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// title : 완주하지 못한 선수

import java.util.*;

public class 완주하지못한선수 {
    // 효율성 테스트 실패 - 시간 초과
    // sort를 하면 시간이 좀더 줄어듬
    class Solution1 {
        public String solution(String[] participant, String[] completion) {
            Arrays.sort(participant);
            // LinkedList가 ArrayList보다 remove operation이 빠르다
            LinkedList<String> list = new LinkedList<>(Arrays.asList(participant));
            
            Arrays.sort(completion);
            for(String c : completion) {
                if(list.contains(c)) list.remove(c);
            }
            
            return list.get(0);
        }
    }

    // hashmap
    class Solution2 {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map = new HashMap<>();
            
            for(int i=0;i<participant.length;i++) {
                if(map.containsKey(participant[i])) 
                    map.put(participant[i], map.get(participant[i])+1);
                else map.put(participant[i], 1);
            }
            
            for(int i=0;i<completion.length;i++) {
                map.put(completion[i], map.get(completion[i])-1);
            }
            
            for(int i=0;i<participant.length;i++) {
                if(map.get(participant[i]) != 0) answer = participant[i]; 
            }
            
            return answer;
        }
    }

    // hashmap -> getOrDefault() 함수 사용
    class Solution3 {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map = new HashMap<>();
            
            for (String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);
            for (String c : completion) map.put(c, map.get(c) - 1);

            for (String key : map.keySet()) {
                if (map.get(key) != 0) answer = key;
            }
            
            return answer;
        }
    }
}