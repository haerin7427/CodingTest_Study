// https://school.programmers.co.kr/learn/courses/30/lessons/64065
// title : 튜플

import java.util.*;

public class 튜플 {
    class Solution1 {
        public int[] solution(String s) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            
            s = s.substring(1, s.length()-1);
            String[] str = s.split("\\}");
            
            for(String ss : str) {
                ss = ss.substring(1, ss.length()).replace("{", "");
                
                ArrayList<Integer> list = new ArrayList<>();
                
                if(ss.length() > 1) {
                    String[] split = ss.split(",");
                    
                    for(String sSplit : split) {
                        list.add(Integer.parseInt(sSplit));
                    }
                    
                    map.put(split.length, list);
                }
                else {
                    list.add(Integer.parseInt(ss));
                    
                    map.put(1, list);
                }
            }
            
            int[] answer = new int[map.size()];
            
            for (int key : map.keySet()) {
                ArrayList<Integer> value = map.get(key);
                
                if(key == 1) answer[key-1] = value.get(0);
                else {
                    // 기존 map value를 변경하지 않기 위해 새로운 list 생성
                    ArrayList<Integer> newList = new ArrayList<>(value);
                    ArrayList<Integer> beforeValue = map.get(key-1);
                    
                    newList.removeAll(beforeValue);
                    
                    answer[key-1] = newList.get(0);
                }
            }
            
            return answer;
        }
    }

    class Solution2 {
        public int[] solution(String s) {
            Set<String> set = new HashSet<>();
            String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
            
            Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
            
            int[] answer = new int[arr.length];
            int idx = 0;
            
            for(String s1 : arr) {
                for(String s2 : s1.split(",")) {
                    if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
                }
            }
            
            return answer;
        }
    }
}