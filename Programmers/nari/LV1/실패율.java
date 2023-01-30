// https://school.programmers.co.kr/learn/courses/30/lessons/42889
// title : 실패율

import java.util.*;

public class 실패율 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            HashMap<Integer, Double> map = new HashMap<Integer, Double>();
            int people = stages.length;
            
            for(int i=1;i<=N;i++) {
                int cnt = 0;
                
                for(int s : stages) {
                    if(s == i) cnt++;
                }
                
                if(cnt == 0) map.put(i, 0.0);
                else map.put(i, (double) cnt / people);
                people -= cnt;
            }
                            
            List<Integer> keySetList = new ArrayList<>(map.keySet());

            Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
            
            for(int i=0;i<keySetList.size();i++) {
                answer[i] = keySetList.get(i);
            }
            
            return answer;
        }
    }
}